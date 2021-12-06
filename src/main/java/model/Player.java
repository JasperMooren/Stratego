package model;

import model.pieces.Piece;

public class Player {

    // Instance Variables
    private final Board board;
    private final Piece[] pieces;

    // Constructor
    public Player(Board board) {
        pieces = buildPieces();
        this.board = board;
    }

    /**
     * Factory for the pieces
     * @return the starting pieces that each player has
     */
    private Piece[] buildPieces() {
        // TODO: implement
        return null;
    }


}
