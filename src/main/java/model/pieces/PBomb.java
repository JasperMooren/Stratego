package model.pieces;

import model.Board;
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

    /**
     * Bombs cannot move, so always returns false.
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

    /**
     * This subclass cannot attack, therefore this shouldn't be called.
     */
    @Override
    public Boolean winsAttack(Piece attackedPiece) {
        System.out.println("Player is attacking with a Bomb!");
        throw new IllegalArgumentException();
    }
}
