package model.pieces;

import model.Player;

public final class Marshal extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Marshal(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
