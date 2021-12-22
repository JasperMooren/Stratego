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

        // check if all coordinates are within bounds.
        if (!board.coordinatesWithinBounds(fromX, fromY)) {
            return false;
        }
        if (!board.coordinatesWithinBounds(toX, toY)) {
            return false;
        }

        // check if target square is not water
        if (board.getSquare(toX, toY).isWater()) {
            return false;
        }

        // check if trying to move to own piece.
        Piece pieceTo = board.getPiece(toX, toY);
        if (pieceTo != null) {
            if (pieceTo.getPlayer() == player) {
                return false;
            }
        }

        // check if piece is within distance of movement
        if (!withinMoveDistance(fromX, fromY, toX, toY)) {
            return false;
        }

        // everything is valid
        return true;
    }

    /**
     * Checks whether the distance is within 1 square orthogonally. P2Scout overrides this method.
     *
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the desired x-position of the piece.
     * @param toY   the desired y-position of the piece.
     * @return true if the distance is valid, false otherwise.
     */
    protected boolean withinMoveDistance(int fromX, int fromY, int toX, int toY) {
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
}
