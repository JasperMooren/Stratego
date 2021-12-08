package model.pieces;

import model.Player;

public final class Marshal extends Piece {

    // Constants
    public static final int AMOUNT = 1;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public Marshal(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
