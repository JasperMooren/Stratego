package model.pieces;

import model.Player;

public final class Bomb extends Piece {

    // Constants
    public static final int AMOUNT = 6;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public Bomb(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
