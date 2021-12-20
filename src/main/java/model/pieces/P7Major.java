package model.pieces;

import model.Player;

public class P7Major extends Piece {

    // Constants
    public static final int AMOUNT = 3;
    public static final int VALUE = 7;
    public static final PieceType PIECE_TYPE = PieceType.P7_MAJOR;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P7Major(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
