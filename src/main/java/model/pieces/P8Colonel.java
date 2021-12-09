package model.pieces;

import model.Player;

public final class P8Colonel extends AbstractPiece {

    // Constants
    public static final int AMOUNT = 2;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P8Colonel(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
