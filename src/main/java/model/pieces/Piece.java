package model.pieces;

import model.Board;
import model.Player;

public abstract class Piece {

    // Instance Variable
    protected Player player;

    // Constructor
    public Piece(Player player) {
        this.player = player;
    }

    // Getters

    /**
     * Gets the PieceType as defined by the subclass.
     *
     * @return the PieceType of the subclass.
     */
    public abstract PieceType getPieceType();

    public static int getTotalAmount() {
        int total = 0;
        for (PieceType pieceType : PieceType.values()) {
            total += pieceType.getAmount();
        }
        return total;
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Checks if the piece can move from position (fromX,fromY) to position (toX,toY).
     * This method gets overridden by PFlag and PBomb (cannot move, always return false).
     * The P2Scout moves differently over a distance, which is partly overridden in the subclass.
     *
     * @param board the board on which the piece wants to move.
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the desired x-position of the piece.
     * @param toY   the desired y-position of the piece.
     * @return true if it can move (even if it is an attack), false otherwise.
     */
    public boolean canMove(Board board, int fromX, int fromY, int toX, int toY) {
        // check if target square is not the original square
        if (fromX == toX && fromY == toY) {
            return false;
        }

        // calculate distance
        int distance = toX - fromX;

        // check if x is within distance 1
        if (distance < -1 || distance > 1) {
            return false;
        }

        // check if y is within distance 1
        distance = toY - fromY;
        if (distance < -1 || distance > 1) {
            return false;
        }

        // both x and y are within distance
        return true;
    }

    /**
     * Checks whether the piece that is attacking wins from the attacked piece.
     *
     * @param attackedPiece the piece that is attacked
     * @return true if it wins, false if it loses, draw if equal.
     */
    public Boolean winsAttack(Piece attackedPiece) {
        PieceType attackedPieceType = attackedPiece.getPieceType();
        // attacking a bomb always loses (exceptions are overwritten)
        if (attackedPieceType == PieceType.P_BOMB) {
            return false;
        }
        // attacking a flag always wins! -> wins the game, so this should be seperated at some point.
        if (attackedPieceType == PieceType.P_FLAG) {
            return true;
        }
        // same returns null, to indicate a draw.
        if (getPieceType().getValue() == attackedPieceType.getValue()) {
            return null;
        }
        // if the value is higher it wins, otherwise loses.
        return getPieceType().getValue() > attackedPieceType.getValue();
    }
}
