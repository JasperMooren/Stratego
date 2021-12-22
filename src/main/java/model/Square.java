package model;

import model.pieces.Piece;

public class Square {

    private Piece piece;
    private boolean isWater;

    public Square() {
        piece = null;
        isWater = false;
    }

    // Getters
    public Piece getPiece() {
        return piece;
    }

    public boolean isWater() {
        return isWater;
    }

    // Setters
    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setToWater() {
        isWater = true;
    }
}
