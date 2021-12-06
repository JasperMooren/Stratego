package model;

public class Board {

    // Constants
    public static final int BOARD_SIZE = 10;
    public static final int X_LENGHT = BOARD_SIZE;
    public static final int Y_LENGHT = BOARD_SIZE;

    // Instance Variables
    private Square[][] squares;

    public Board() {
        squares = buildSquares();
    }

    private Square[][] buildSquares() {
        Square[][] squares = new Square[Y_LENGHT][X_LENGHT];
        for (int y = 0; y < squares.length; y++) {
            for (int x = 0; x < squares[y].length; x++) {
                squares[y][x] = new Square();
            }
        }
        return squares;
    }
}