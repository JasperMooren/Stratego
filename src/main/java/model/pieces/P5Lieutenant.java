package model.pieces;

import model.Player;

public class P5Lieutenant extends Piece {

    // Constants
    public static final int AMOUNT = 4;
    public static final int VALUE = 5;
    public static final PieceType PIECE_TYPE = PieceType.P5_LIEUTENANT;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P5Lieutenant(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
