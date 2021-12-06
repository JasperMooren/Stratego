package model;

import model.pieces.Piece;

public class Player {

    // Constants
    private static final int AMOUNT_OF_PIECES = 40;

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
<<<<<<< Updated upstream
        // TODO: implement
        return null;
        // this is a test
=======
        Piece[] pieces = new Piece[AMOUNT_OF_PIECES];
        
        return pieces;
>>>>>>> Stashed changes
    }


}
