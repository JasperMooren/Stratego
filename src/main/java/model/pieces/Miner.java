package model.pieces;

import model.Player;

public final class Miner extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Miner(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
