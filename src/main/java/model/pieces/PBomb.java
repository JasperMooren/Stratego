package model.pieces;

import model.Player;

public final class PBomb extends AbstractPiece {

    // Constants
    public static final int AMOUNT = 6;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public PBomb(Player player) {
        super(player);
    }

    @Override
    public int getAmount() {
        return AMOUNT;
    }
}
