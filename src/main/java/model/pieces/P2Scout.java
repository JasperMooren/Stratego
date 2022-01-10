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
        // calculate distance
        int xDistance = toX - fromX;
        int yDistance = toY - fromY;

        //check if either x or y movement is 0 (to prevent diagonal moves)
        if (xDistance != 0 && yDistance != 0) {
            return false;
        }
        // 4 directions +x , -x , +y , -y

        if (yDistance == 0) {
            if (xDistance > 0) {
                for (int x = fromX; x < toX; x++) {
                    if (movingToWaterOrPieces(board, x, toY)) {
                        return false;
                    }
                }
            } else {
                for (int x = fromX; x > toX; x--) {
                    if (movingToWaterOrPieces(board, x, toY)) {
                        return false;
                    }
                }
            }
        } else {
            if (yDistance > 0) {
                for (int y = fromY; y < toY; y++) {
                    if (movingToWaterOrPieces(board, toX, y)) {
                        return false;

                    }
                }
            } else {
                for (int y = fromY; y > toY; y--) {
                    if (movingToWaterOrPieces(board, toX, y)) {
                        return false;

                    }
                }
            }
        }
        return true;
    }

    private boolean movingToWaterOrPieces(Board board, int x, int y) {
        return board.getPiece(x, y) != null || board.getSquare(x, y).isWater();
        
    }
}
