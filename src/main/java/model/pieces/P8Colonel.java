package model.pieces;

import model.Player;

public class P8Colonel extends Piece {

    // Constants
    public static final int AMOUNT = 2;
    public static final int VALUE = 8;
    public static final PieceType PIECE_TYPE = PieceType.P8_COLONEL;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P8Colonel(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
