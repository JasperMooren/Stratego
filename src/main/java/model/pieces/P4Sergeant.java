package model.pieces;

import model.Player;

public class P4Sergeant extends Piece {

    // Constants
    public static final int AMOUNT = 4;
    public static final int VALUE = 4;
    public static final PieceType PIECE_TYPE = PieceType.P4_SERGEANT;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P4Sergeant(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
