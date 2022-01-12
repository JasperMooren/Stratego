package model.pieces;

import model.Player;

public class P10Marshal extends Piece {

    // Constants
    public static final int AMOUNT = 1;
    public static final int VALUE = 10;
    public static final PieceType PIECE_TYPE = PieceType.P10_MARSHAL;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P10Marshal(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
