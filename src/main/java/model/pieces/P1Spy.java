package model.pieces;

import model.Player;

public class P1Spy extends Piece {

    // Constants
    public static final int AMOUNT = 1;
    public static final int VALUE = 1;
    public static final PieceType PIECE_TYPE = PieceType.P1_SPY;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P1Spy(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
