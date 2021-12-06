package model.pieces;

import model.Player;

public final class Spy extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    public Spy(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
