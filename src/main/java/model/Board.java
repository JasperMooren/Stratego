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
    public void setTestPieces(Player player){
        setPiece(3,2, new Bomb(player));
        setPiece(2,3, new Bomb(player));
        setPiece(4,3, new Bomb(player));
        setPiece(3,3, new Flag(player));
        setPiece(4,2, new Miner(player));
        setPiece(5,3, new Sergeant(player));
        setPiece(6,2, new Lieutenant(player));
        setPiece(7,3, new Captain(player));
        setPiece(8,2, new Major(player));
        setPiece(9,3, new Colonel(player));
        setPiece(8,1, new General(player));
        setPiece(8,0, new Marshal(player));
        setPiece(9,0, new Spy(player));
        setPiece(3,1, new Scout(player));
    }
    public void setPiece(int x, int y, Piece piece){
        squares[y][x].setPiece(piece);
    }
}
