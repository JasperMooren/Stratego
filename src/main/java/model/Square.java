package model;

import model.pieces.Piece;

public class Square {

    private Piece piece;

    public Square() {
        piece = null;
    }

    // Getters
    public Piece getPiece() {
        return piece;
    }

    // Setters
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
