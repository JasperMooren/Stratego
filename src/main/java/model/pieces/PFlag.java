package model.pieces;

import model.Player;

public final class PFlag extends AbstractPiece {

    // Constants
    public static final int AMOUNT = 1;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public PFlag(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}