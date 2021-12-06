package model.pieces;

import model.Player;

public final class Colonel extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Colonel(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
