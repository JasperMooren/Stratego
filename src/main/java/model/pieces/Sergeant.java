package model.pieces;

import model.Player;

public final class Sergeant extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Sergeant(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
