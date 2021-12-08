package model.pieces;

import model.Player;

public final class General extends Piece {

    // Constants
    public static final int AMOUNT = 1;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public General(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
