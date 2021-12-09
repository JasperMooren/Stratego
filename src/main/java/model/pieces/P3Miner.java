package model.pieces;

import model.Player;

public final class P3Miner extends AbstractPiece {

    // Constants
    public static final int AMOUNT = 5;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P3Miner(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
