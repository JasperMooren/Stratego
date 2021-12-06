package model;

import model.pieces.*;

import java.util.ArrayList;

public class Player {

    // Constants

    /**
     * A list of all subclasses of Piece
     */
    @SuppressWarnings("unchecked") // All subclasses of Piece by definition extend Piece.
    private static final Class<? extends Piece>[] PIECE_CLASS_LIST =
            (Class<? extends Piece>[]) Piece.class.getPermittedSubclasses();

    // Instance Variables
    private final Board board;
    private final ArrayList<Piece> pieces;

    // Constructor
    public Player(Board board) {
        pieces = buildPieces();
        this.board = board;
        System.out.println(totalAmountOfPieces());
    }

    /**
     * Factory for the pieces to be constructed, based on the AMOUNT static variable in the subclass of Piece.
     *
     * @return the starting pieces that each player has.
     */
    private ArrayList<Piece> buildPieces() {
        // create an ArrayList of the pieces
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Class<? extends Piece> cls : PIECE_CLASS_LIST) {
            for (int i = 0; i < getAmountOfPiece(cls); i++) {
                try {
                    pieces.add(cls.getDeclaredConstructor(Player.class).newInstance(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
        return pieces;
    }

    /**
     * Gets the totalAmountOfPieces
     *
     * @return the total amount
     */
    private int totalAmountOfPieces() {
        int total = 0;
        for (Class<? extends Piece> cls : PIECE_CLASS_LIST) {
            total += getAmountOfPiece(cls);
        }
        return total;
    }

    /**
     * returns the amount of pieces of a specified subclass.
     * @param cls a subclass object of
     * @return the amount of a specific piece, or 0 if there is no AMOUNT.
     */
    private int getAmountOfPiece(Class<? extends Piece> cls) {
        int amount = 0;
        try {
            // instantiate object
            Piece p = cls.getDeclaredConstructor(Player.class).newInstance(this);
            // gets the amount of this specific object aka class (because abstract static not part of Java)
            amount = (int) cls.getDeclaredMethod("getAmount").invoke(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

}
