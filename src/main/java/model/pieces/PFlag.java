package model.pieces;

import model.Board;
import model.Player;

public class PFlag extends Piece {

    // Constants
    public static final int AMOUNT = 1;
    public static final int VALUE = -1;
    public static final PieceType PIECE_TYPE = PieceType.P_FLAG;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public PFlag(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }

    /**
     * Flags cannot move, so always returns false.
     *
     * @param board the board on which the piece wants to move.
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the desired x-position of the piece.
     * @param toY   the desired y-position of the piece.
     * @return false
     */
    @Override
    public boolean canMove(Board board, int fromX, int fromY, int toX, int toY) {
        return false;
    }
}