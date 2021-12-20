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
        setPiece(3,2, new PBomb(player));
        setPiece(2,3, new PBomb(player));
        setPiece(4,3, new PBomb(player));
        setPiece(3,3, new PFlag(player));
        setPiece(4,2, new P3Miner(player));
        setPiece(5,3, new P4Sergeant(player));
        setPiece(6,2, new P5Lieutenant(player));
        setPiece(7,3, new P6Captain(player));
        setPiece(8,2, new P7Major(player));
        setPiece(9,3, new P8Colonel(player));
        setPiece(8,1, new P9General(player));
        setPiece(8,0, new P10Marshal(player));
        setPiece(9,0, new P1Spy(player));
        setPiece(3,1, new P2Scout(player));
    }
    public void setPiece(int x, int y, Piece piece){
        squares[y][x].setPiece(piece);
    }
}
