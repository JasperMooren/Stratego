package model.pieces;

import model.Player;

public final class Colonel extends Piece {

    // Constants
    public static final int AMOUNT = 2;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public Colonel(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
