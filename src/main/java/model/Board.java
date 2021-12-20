package model;

import model.pieces.*;

public class Board {

    // Constants
    public static final int BOARD_SIZE = 10;
    public static final int X_LENGTH = BOARD_SIZE;
    public static final int Y_LENGTH = BOARD_SIZE;

    // Instance Variables
    private final Square[][] squares;


    // Constructor
    public Board() {
        squares = buildSquares();

    }

    // constructor methods
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
    
    

    // Setters

    /**
     * Sets a piece at a specified coordinate on the board
     * @param x the x coordinate of the board
     * @param y the y coordinate of the board
     * @param piece the piece to be place, or null if the piece should be removed.
     *              -> use (Piece) null, otherwise Java doesn't understand the parameter.
     */
    public void setPiece(int x, int y, Piece piece) {
        squares[y][x].setPiece(piece);
    }

    // test methods

    @Deprecated
    public void printBoard() {
        String print = "";
        print += "+ 01 02 03 04 05 06 07 08 09 10\n";
        print += "J ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,9) + " ";
        }
        print += "\n";
        print += "I ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,8) + " ";
        }
        print += "\n";
        print += "H ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,7) + " ";
        }
        print += "\n";
        print += "G ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,6) + " ";
        }
        print += "\n";
        print += "F ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,5) + " ";
        }
        print += "\n";
        print += "E ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,4) + " ";
        }
        print += "\n";
        print += "D ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,3) + " ";
        }
        print += "\n";
        print += "C ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,2) + " ";
        }
        print += "\n";
        print += "B ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,1) + " ";
        }
        print += "\n";
        print += "A ";
        for (int x = 0; x < 10; x++) {
            print += getSquareString(x,0) + " ";
        }
        print += "\n";
        System.out.println(print);
    }

    @Deprecated // deprecated because it's a test method,
    // it shouldn't be used in the final program, just to check if stuff works.
    private String getSquareString(int x, int y) {
        Piece p = squares[y][x].getPiece();
        if (p == null) {
            return "XX";
        }
        else if (p instanceof P1Spy) {
            return "S1";
        }
        else if (p instanceof P2Scout) {
            return "02";
        }
        else if (p instanceof P3Miner) {
            return "03";
        }
        else if (p instanceof P4Sergeant) {
            return "04";
        }
        else if (p instanceof P5Lieutenant) {
            return "05";
        }
        else if (p instanceof P6Captain) {
            return "06";
        }
        if (p instanceof P7Major) {
            return "07";
        }
        if (p instanceof P8Colonel) {
            return "08";
        }
        if (p instanceof P9General) {
            return "09";
        }
        if (p instanceof P10Marshal) {
            return "10";
        }
        if (p instanceof PFlag) {
            return "FF";
        }
        if (p instanceof PBomb) {
            return "BB";
        }
        return null;
    }

}
