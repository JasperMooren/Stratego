package model.pieces;

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
}
