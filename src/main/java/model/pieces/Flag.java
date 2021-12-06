package model.pieces;

import model.Player;

public final class Flag extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Flag(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}