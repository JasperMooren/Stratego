package model;

import model.pieces.*;

public class Board {

    // Constants
    public static final int BOARD_SIZE = 10;
    public static final int X_LENGTH = BOARD_SIZE;
    public static final int Y_LENGTH = BOARD_SIZE;

    // Instance Variables
    private Square[][] squares;

    public Board() {
        squares = buildSquares();
        // test setup//
        setPiece(3,2, new Bomb(new Player(this)));
        setPiece(2,3, new Bomb(new Player(this)));
        setPiece(4,3, new Bomb(new Player(this)));
        setPiece(3,3, new Flag(new Player(this)));
        setPiece(4,2, new Miner(new Player(this)));
        setPiece(5,3, new Sergeant(new Player(this)));
        setPiece(6,2, new Lieutenant(new Player(this)));
        setPiece(7,3, new Captain(new Player(this)));
        setPiece(8,2, new Major(new Player(this)));
        setPiece(9,3, new Colonel(new Player(this)));
        setPiece(8,1, new General(new Player(this)));
        setPiece(8,0, new Marshal(new Player(this)));
        setPiece(9,0, new Spy(new Player(this)));
        setPiece(3,1, new Scout(new Player(this)));
    }

    private Square[][] buildSquares() {
        Square[][] squares = new Square[Y_LENGTH][X_LENGTH];
        for (int y = 0; y < squares.length; y++) {
            for (int x = 0; x < squares[y].length; x++) {
                squares[y][x] = new Square();
            }
        }
        return squares;
    }

    public void setPiece(int x, int y, Piece piece){
        squares[y][x].setPiece(piece);
    }
}
