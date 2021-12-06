package model.pieces;

import model.Player;

public final class General extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public General(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
