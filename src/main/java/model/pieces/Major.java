package model.pieces;

import model.Player;

public final class Major extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Major(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
