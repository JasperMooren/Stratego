package model.pieces;

import model.Player;

public final class P2Scout extends AbstractPiece {

    // Constants
    public static final int AMOUNT = 8;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P2Scout(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
