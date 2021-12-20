package model.pieces;

import model.Player;

public class P3Miner extends Piece {

    // Constants
    public static final int AMOUNT = 5;
    public static final int VALUE = 3;
    public static final PieceType PIECE_TYPE = PieceType.P3_MINER;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P3Miner(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }
}
