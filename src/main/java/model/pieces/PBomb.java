package model.pieces;

import model.Player;

public class PBomb extends Piece {

    // Constants
    public static final int AMOUNT = 6;
    public static final int VALUE = 0;
    public static final PieceType PIECE_TYPE = PieceType.P_BOMB;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public PBomb(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
