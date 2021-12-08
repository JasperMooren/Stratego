package model.pieces;

import model.Player;

public final class Miner extends Piece {

    // Constants
    public static final int AMOUNT = 5;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public Miner(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
