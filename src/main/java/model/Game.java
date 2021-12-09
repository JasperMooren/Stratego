package model;

public class Game {

    // Constants
    private static final int AMOUNT_OF_PLAYERS = 2;

    // Instance Variable
    private final Player[] players;
    private final Board board;

    public Game() {
        board = new Board();
        players = setPlayers(board);
    }

    private Player[] setPlayers(Board board) {
        Player[] players = new Player[AMOUNT_OF_PLAYERS];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player(board, i == 0);
        }
        return players;
    }

}
