package model;

import model.pieces.*;

import java.util.ArrayList;

public class Player {

    // Instance Variables
    private final Board board;
    private final ArrayList<Piece> pieces;

    // Constructor
    public Player(Board board) {
        pieces = buildPieces();
        this.board = board;
    }

    /**
     * Factory for the pieces to be constructed, based on the AMOUNT static variable in the subclass of Piece.
     *
     * @return the starting pieces that each player has.
     */
    private ArrayList<Piece> buildPieces() {
        // create an ArrayList of the pieces
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Class<? extends Piece> cls : Piece.PIECE_CLASS_LIST) {
            for (int i = 0; i < Piece.getAmount(cls); i++) {
                try {
                    pieces.add(cls.getDeclaredConstructor(Player.class).newInstance(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return pieces;
    }
}
