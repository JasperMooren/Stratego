package model;

import model.pieces.AbstractPiece;

public class Square {

    private AbstractPiece abstractPiece;

    public Square() {
        abstractPiece = null;
    }

    // Getters
    public AbstractPiece getPiece() {
        return abstractPiece;
    }

    // Setters
    public void setPiece(AbstractPiece abstractPiece) {
        this.abstractPiece = abstractPiece;
    }
}
