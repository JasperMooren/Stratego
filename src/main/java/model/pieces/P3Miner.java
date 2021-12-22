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

    /**
     * Checks whether the piece that is attacking wins from the attacked piece.
     *
     * @param attackedPiece the piece that is attacked
     * @return true if it wins, false if it loses, draw if equal.
     */
    @Override
    public Boolean winsAttack(Piece attackedPiece) {
        PieceType attackedPieceType = attackedPiece.getPieceType();
        // attacking a bomb wins with a Miner!
        if (attackedPieceType == PieceType.P_BOMB) {
            return true;
        }
        return super.winsAttack(attackedPiece);
    }
}
