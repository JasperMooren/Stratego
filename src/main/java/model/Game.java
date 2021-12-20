package model;

public class Game {

    // Constants
    private static final int AMOUNT_OF_PLAYERS = 2;

    // Instance Variable
    private final Player[] players;
    private final Board board;
    private int currentPlayerIndex;

    public Game() {
        board = new Board();
        players = setTestPlayers(board);
        board.printBoard();
        currentPlayerIndex = 0;
    }

    // Setters
    private Player[] setPlayers(Board board) {
        Player[] players = new Player[AMOUNT_OF_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(board, i == 0);
        }
        return players;
    }

    // Getters
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public Board getBoard() {
        return board;
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    // TODO: remove test method
    @Deprecated
    private Player[] setTestPlayers(Board board) {
        Player[] players = new Player[AMOUNT_OF_PLAYERS];
        players[0] = new Player(board, true, BasicBoardSetup.TEST_A);
        players[1] = new Player(board, false, BasicBoardSetup.TEST_B);
        return players;
    }
}
