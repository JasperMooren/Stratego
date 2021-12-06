package model.pieces;

import model.Player;

public abstract sealed class Piece
        permits Bomb, Captain, Colonel, Flag, General, Lieutenant, Major, Marshal, Miner, Scout, Sergeant, Spy {

    // Instance Variable
    protected Player player;
    protected int amount;

    // Constructor
    public Piece(Player player) {
        this.player = player;
    }

    public abstract int getAmount();
}
