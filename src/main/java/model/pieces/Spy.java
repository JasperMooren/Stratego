package model.pieces;

import model.Player;

public final class Spy extends Piece {

    // Constants
    public static final int AMOUNT = 1;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public Spy(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
