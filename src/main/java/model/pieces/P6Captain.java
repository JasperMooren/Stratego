package model.pieces;

import model.Player;

public final class P6Captain extends Piece {

    // Constants
    public static final int AMOUNT = 4;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P6Captain(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
