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
        return squares;
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

    // test methods
    @Deprecated
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

    @Deprecated // deprecated because it's a test method,
    // it shouldn't be used in the final program, just to check if stuff works.
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

    public Piece getPiece(int x, int y) {
        if (x >= squares[0].length) {
            return null;
        }
        if (y >= squares.length) {
            return null;
        }
        return squares[y][x].getPiece();
    }
}
