package model.pieces;

import model.Player;

public class P9General extends Piece {

    // Constants
    public static final int AMOUNT = 1;
    public static final int VALUE = 9;
    public static final PieceType PIECE_TYPE = PieceType.P9_GENERAL;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P9General(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
