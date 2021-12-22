package model;

import model.pieces.*;

import java.util.ArrayList;

public class Player {

    // Instance Variables
    private final boolean isFirst;
    private final Board board;
    private final ArrayList<Piece> pieces;

    // Constructor
    public Player(Board board, boolean isFirst) {
        this.isFirst = isFirst;
        this.board = board;
        pieces = buildPieces();
    }

    // Test Constructor
    @Deprecated
    public Player(Board board, boolean isFirst, BasicBoardSetup basicBoardSetup) {
        this.isFirst = isFirst;
        this.board = board;
        pieces = buildPieces();
        setBoard(basicBoardSetup);
    }

    // Factories

    /**
     * Factory for the pieces to be constructed, based on the AMOUNT static variable in the subclass of Piece.
     *
     * @return the starting pieces that each player has.
     */
    private ArrayList<Piece> buildPieces() {
        // create an ArrayList of the pieces
        ArrayList<Piece> pieces = new ArrayList<>();
        for (PieceType pieceType : PieceType.values()) {
            for (int i = 0; i < pieceType.getAmount(); i++) {
                pieces.add(pieceType.newInstance(this));
            }
        }
        return pieces;
    }

    // Setters

    /**
     * Sets the whole board according to a basic setup defined in the setBoard method.
     *
     * @param basicBoardSetup a type of opening setup
     */
    public void setBoard(BasicBoardSetup basicBoardSetup) {
        PieceType[][] setupPieces = basicBoardSetup.getSetup();
        // check if the setup is smaller than half of the board.
        if (!(setupPieces.length < (Board.Y_LENGTH / 2))) {
            System.out.println("Y_LENGTH incorrect");
            return;
        }
        // check if all x values are the width of the board.
        for (int y = 0; y < setupPieces.length; y++) {
            if (setupPieces[y].length != Board.X_LENGTH) {
                System.out.println("X_LENGTH incorrect");
                return;
            }
        }
        for (int y = 0; y < setupPieces.length; y++) {
            for (int x = 0; x < setupPieces[y].length; x++) {
                if (!placePiece(x, y, setupPieces[y][x])) {
                    reset(x, y, setupPieces);
                    return;
                }
            }
        }
    }

    // Getters

    public boolean getIsFirst() {
        return isFirst;
    }

    /**
     * refills the pieces ArrayList and empties the board, based on incorrect changes to both
     *
     * @param maxX        the x position at which the error occurred
     * @param maxY        the y position at which the error occurred
     * @param setupPieces the format from which the player tried to add pieces.
     */
    private void reset(int maxX, int maxY, PieceType[][] setupPieces) {
        System.out.println("Reset method called: maxX: " + maxX + ", maxY: " + maxY);
        for (int y = 0; y < setupPieces.length; y++) {
            for (int x = 0; x < setupPieces[y].length; x++) {
                if (x == maxX && y == maxY) {
                    return;
                }
                placePiece(x, y, (Piece) null);
                Piece piece = setupPieces[y][x].newInstance(this);
                pieces.add(piece);
            }
        }
    }

    /**
     * Places a piece on a coordinate based on the orientation of the player.
     *
     * @param playerX the x coordinate to place the piece from the perspective of the player
     * @param playerY the y coordinate to place the piece from the perspective of the player
     * @param piece   the piece to place.
     */
    public void placePiece(int playerX, int playerY, Piece piece) {
        int boardX = getFlipped(playerX, true);
        int boardY = getFlipped(playerY, false);
        board.setPiece(boardX, boardY, piece);
    }

    /**
     * Takes a piece of a specific type and sets it on the board.
     * If no Piece of the type is found, return false, else return true.
     *
     * @param playerX   the x coordinate to place the piece from the perspective of the player
     * @param playerY   the y coordinate to place the piece from the perspective of the player
     * @param pieceType the type of piece to place.
     * @return true if the piece is placed, otherwise false (no piece of required type exists).
     */
    public boolean placePiece(int playerX, int playerY, PieceType pieceType) {
        Piece piece = takePiece(pieceType);
        if (piece == null) {
            System.out.println(pieceType.getClass().getName() + " not found in player pieces list");
            return false;
        }
        int boardX = getFlipped(playerX, true);
        int boardY = getFlipped(playerY, false);
        board.setPiece(boardX, boardY, piece);
        return true;
    }

    /**
     * Takes a piece of a specific class from the player and returns it.
     *
     * @param pieceType the type of the piece to take
     * @return a Piece object, or null of no instance of the given class exists in the array.
     */
    private Piece takePiece(PieceType pieceType) {
        // loop through the ArrayList
        for (int i = 0; i < pieces.size(); i++) {
            // check if the piece is of the type given.
            if (pieces.get(i).getPieceType() == pieceType) {
                // remove it from the player's stock.
                return pieces.remove(i);
            }
        }
        // return the piece.
        return null;
    }

    /**
     * If the player is the top player, the board positions should flip.
     *
     * @param coordinate the original coordinate
     * @param isX        if asking for the x coordinate, is true, for y is false.
     * @return the flipped coordinate (from board coordinate to player coordinate or from player coordinate to board coordinate)
     */
    private int getFlipped(int coordinate, boolean isX) {
        if (isFirst) {
            return coordinate;
        }
        return Board.getFlippedCoordinate(coordinate, isX);
    }

    // test method
    @Deprecated
    private void printPieces() {
        String playerName;
        if (isFirst) {
            playerName = "Player 1";
        } else {
            playerName = "Player 2";
        }
        System.out.println(playerName + " pieces:");
        for (Piece p :
                pieces) {
            System.out.println(p.getClass().getName());
        }
    }
}
