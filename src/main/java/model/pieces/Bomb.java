package model.pieces;

import model.Player;

public final class Bomb extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    // Instance Variables

    // Constructor
    public Bomb(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
