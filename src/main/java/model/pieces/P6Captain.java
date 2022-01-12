package model.pieces;

import model.Player;

public class P6Captain extends Piece {

    // Constants
    public static final int AMOUNT = 4;
    public static final int VALUE = 6;
    public static final PieceType PIECE_TYPE = PieceType.P6_CAPTAIN;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P6Captain(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
