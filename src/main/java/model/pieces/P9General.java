package model.pieces;

import model.Player;

public final class P9General extends AbstractPiece {

    // Constants
    public static final int AMOUNT = 1;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P9General(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
