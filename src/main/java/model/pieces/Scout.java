package model.pieces;

import model.Player;

public final class Scout extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Scout(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
