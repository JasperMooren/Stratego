package model;

import model.pieces.*;

public class Board {

    // Constants
    public static final int BOARD_SIZE = 10;
    public static final int X_LENGTH = BOARD_SIZE;
    public static final int Y_LENGTH = BOARD_SIZE;

    // Instance Variables
    private final Square[][] squares;


    // Constructor
    public Board() {
        squares = buildSquares();
    }

    // constructor methods
    private Square[][] buildSquares() {
        Square[][] squares = new Square[Y_LENGTH][X_LENGTH];
        for (int y = 0; y < squares.length; y++) {
            for (int x = 0; x < squares[y].length; x++) {
                squares[y][x] = new Square();
            }
        }
        // add water squares
        if (X_LENGTH >=3 && Y_LENGTH >= 5) {
            squares[4][2].setToWater();
            squares[4][3].setToWater();
            squares[5][2].setToWater();
            squares[5][3].setToWater();
        }
        if (X_LENGTH >= 7 && Y_LENGTH >= 5) {
            squares[4][6].setToWater();
            squares[4][7].setToWater();
            squares[5][6].setToWater();
            squares[5][7].setToWater();
        }
        return squares;
    }

    // Getters
    public Piece getPiece(int x, int y) {
        return squares[y][x].getPiece();
    }

    public Square getSquare(int x, int y) {
        return squares[y][x];
    }

    /**
     * Gets the flipped position on the board, so 1,2 results in 8,7 for a 10x10 board
     *
     * @param coordinate the original coordinate
     * @param isX        if asking for the x coordinate, is true, for y is false.
     * @return the flipped coordinate.
     */
    public static int getFlippedCoordinate(int coordinate, boolean isX) {
        int boardLength;
        if (isX) {
            boardLength = Board.X_LENGTH;
        } else {
            boardLength = Board.Y_LENGTH;
        }
        // -1 because a board length of 10 goes from 0 to 9, so position 2 flips to 7, not 8.
        int flipped = boardLength - coordinate - 1;
        return flipped;
    }

    // Setters

    /**
     * Sets a piece at a specified coordinate on the board
     *
     * @param x     the x coordinate of the board
     * @param y     the y coordinate of the board
     * @param piece the piece to be place, or null if the piece should be removed.
     *              -> use (Piece) null, otherwise Java doesn't understand the parameter.
     */
    public void setPiece(int x, int y, Piece piece) {
        squares[y][x].setPiece(piece);
    }

    public Board getFlippedBoard() {
        Board flippedBoard = new Board();
        for (int y = 0; y < squares.length; y++) {
            for (int x = 0; x < squares[y].length; x++) {
                flippedBoard.setPiece(getFlippedCoordinate(x, true), getFlippedCoordinate(y, false), squares[y][x].getPiece());
            }
        }
        return flippedBoard;
    }

    // Other methods

    public boolean coordinatesWithinBounds(int x, int y) {
        return x >= 0 && x < squares[0].length && y >= 0 && y < squares.length;
    }

    /**
     * Checks whether the coordinates are valid or not,
     * whether there is a piece to move or not,
     * and whether that piece can move.
     *
     * @param fromX         the original x-position of the piece.
     * @param fromY         the original y-position of the piece.
     * @param toX           the desired x-position of the piece.
     * @param toY           the desired y-position of the piece.
     * @param currentPlayer the current player's turn.
     * @return true if the piece can move, otherwise false.
     */
    public boolean canMove(int fromX, int fromY, int toX, int toY, Player currentPlayer) {

        // check if the coordinates are actually on the board.
        if (!coordinatesWithinBounds(fromX, fromY)) {
            return false;
        }
        if (!coordinatesWithinBounds(toX, toY)) {
            return false;
        }

        // Set the moving piece as a variable
        Piece p = getPiece(fromX, fromY);

        // check if there is an actual piece on the square you want to move.
        if (p == null) {
            return false;
        }

        // check if the piece is of the player that is actually allowed to move.
        if (p.getPlayer() != currentPlayer) {
            return false;
        }

        // check if all coordinates are within bounds.
        // -> the Game.move method checks this already

        // check if target square is not water
        if (getSquare(toX, toY).isWater()) {
            return false;
        }

        // check if trying to move to own piece.
        Piece pieceTo = getPiece(toX, toY);
        if (pieceTo != null) {
            if (pieceTo.getPlayer() == p.getPlayer()) {
                return false;
            }
        }

        // check if the piece can move
        return p.canMove(this, fromX, fromY, toX, toY);
    }

    /**
     * This method assumes the move is valid!
     * <p>
     * Moves a piece from the old to the new position in a way that assumes no attack.
     *
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the x-position the piece moves towards.
     * @param toY   the y-position of the piece moves towards.
     */
    public void move(int fromX, int fromY, int toX, int toY) {
        Piece p = getPiece(fromX, fromY);
        setPiece(fromX, fromY, null);
        setPiece(toX, toY, p);
    }

    public void take(int fromX, int fromY, int toX, int toY) {
        Piece movingPiece = getPiece(fromX, fromY);
        Piece takenPiece = getPiece(toX, toY);
        setPiece(fromX, fromY, null);
        setPiece(toX, toY, movingPiece);
        takenPiece.getPlayer().returnPiece(takenPiece);
    }

    /**
     * The player which owns the piece on position (x,y) gets their piece back, and it is removed from the board.
     *
     * @param x the x-coordinate of the piece
     * @param y the y-coordinate of the piece
     */
    public void lose(int x, int y) {
        Piece p = getPiece(x, y);
        System.out.println("piece lost: " + p.toString());
        p.getPlayer().returnPiece(p);
        setPiece(x, y, null);
    }

    // test methods
    @Deprecated // deprecated because it's a test method
    public void setTestPieces(Player player) {
        setPiece(3, 2, new PBomb(player));
        setPiece(2, 3, new PBomb(player));
        setPiece(4, 3, new PBomb(player));
        setPiece(3, 3, new PFlag(player));
        setPiece(4, 2, new P3Miner(player));
        setPiece(5, 3, new P4Sergeant(player));
        setPiece(6, 2, new P5Lieutenant(player));
        setPiece(7, 3, new P6Captain(player));
        setPiece(8, 2, new P7Major(player));
        setPiece(9, 3, new P8Colonel(player));
        setPiece(8, 1, new P9General(player));
        setPiece(8, 0, new P10Marshal(player));
        setPiece(9, 0, new P1Spy(player));
        setPiece(3, 1, new P2Scout(player));
    }

    @Deprecated // deprecated because it's a test method
    public void printBoard() {
        String print = "";
        print += "+ 01 02 03 04 05 06 07 08 09 10\n";
        print += "J ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 9) + " ";
        }
        print += "\n";
        print += "I ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 8) + " ";
        }
        print += "\n";
        print += "H ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 7) + " ";
        }
        print += "\n";
        print += "G ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 6) + " ";
        }
        print += "\n";
        print += "F ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 5) + " ";
        }
        print += "\n";
        print += "E ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 4) + " ";
        }
        print += "\n";
        print += "D ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 3) + " ";
        }
        print += "\n";
        print += "C ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 2) + " ";
        }
        print += "\n";
        print += "B ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 1) + " ";
        }
        print += "\n";
        print += "A ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x, 0) + " ";
        }
        print += "\n";
        System.out.println(print);
    }

    @Deprecated // deprecated because it's a test method
    private String getSquareString(int x, int y) {
        Piece p = squares[y][x].getPiece();
        if (p == null) {
            return "XX";
        } else if (p instanceof P1Spy) {
            return "S1";
        } else if (p instanceof P2Scout) {
            return "02";
        } else if (p instanceof P3Miner) {
            return "03";
        } else if (p instanceof P4Sergeant) {
            return "04";
        } else if (p instanceof P5Lieutenant) {
            return "05";
        } else if (p instanceof P6Captain) {
            return "06";
        }
        if (p instanceof P7Major) {
            return "07";
        }
        if (p instanceof P8Colonel) {
            return "08";
        }
        if (p instanceof P9General) {
            return "09";
        }
        if (p instanceof P10Marshal) {
            return "10";
        }
        if (p instanceof PFlag) {
            return "FF";
        }
        if (p instanceof PBomb) {
            return "BB";
        }
        return null;
    }
}
