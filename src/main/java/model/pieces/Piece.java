package model.pieces;

import model.Player;

public abstract class Piece {

    // Instance Variable
    protected Player player;

    // Constructor
    public Piece(Player player) {
        this.player = player;
    }
}
