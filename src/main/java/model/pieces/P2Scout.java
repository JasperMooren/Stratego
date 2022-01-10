package model.pieces;

import model.Board;
import model.Player;

public class P2Scout extends Piece {

    // Constants
    public static final int AMOUNT = 8;
    public static final int VALUE = 2;
    public static final PieceType PIECE_TYPE = PieceType.P2_SCOUT;

    // Instance Variables
    // protected Player player; -> protected variable from parent

    // Constructor
    public P2Scout(Player player) {
        super(player);
    }

    @Override
    public PieceType getPieceType() {
        return PIECE_TYPE;
    }

    @Override
    public boolean canMove(Board board, int fromX, int fromY, int toX, int toY) {

        // TODO: Cannot move over pieces or water!

        // cannot move to the same position
        if (fromX == toX && fromY == toY) {
            return false;
        }

        // scouts can move any distance, as long as it is orthogonal: x remains the same or y remain the same.
        if (fromX == toX || fromY == toY) {
            return true;
        }

        // both x and y change, not an orthogonal movement, therefore illegal.
        return false;
    }
}
