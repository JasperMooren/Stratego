package model.pieces;

import model.Player;

public class P2Scout extends Piece {

    // Constants
    public static final int AMOUNT = 8;
    public static final int VALUE = 2;
    public static final PieceType PIECE_TYPE = PieceType.P2_SCOUT;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P2Scout(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
