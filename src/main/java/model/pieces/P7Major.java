package model.pieces;

import model.Player;

public final class P7Major extends AbstractPiece {

    // Constants
    public static final int AMOUNT = 3;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P7Major(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
