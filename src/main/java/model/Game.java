package model;

import model.pieces.Piece;
import model.pieces.PieceType;

import java.util.HashMap;

public class Game {

    // Constants
    private static final int AMOUNT_OF_PLAYERS = 2;

    // Instance Variable
    private final Player[] players;
    private final Board board;
    private int currentPlayerIndex;

    public Game() {
        board = new Board();
        players = createTestPlayers(board);
        currentPlayerIndex = 0;
        board.printBoard();
    }

    // Factory
    private Player[] createPlayers(Board board) {
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

    public Player[] getPlayers() {
        return players;
    }

    // Other methods

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }

    /**
     * Checks whether the coordinates are valid or not,
     * whether there is a piece to move or not,
     * and whether that piece can move.
     *
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the desired x-position of the piece.
     * @param toY   the desired y-position of the piece.
     * @return true if the piece can move, otherwise false.
     */
    public boolean canMove(int fromX, int fromY, int toX, int toY) {
        return board.canMove(fromX, fromY, toX, toY, getCurrentPlayer());
    }

    /**
     * Only use this method after canMove is called!
     * <p>
     * Checks whether the move constitutes an attack or not
     *
     * @param toX the x-coordinate the player is attacking towards
     * @param toY the y-coordinate the player is attacking towards
     * @return true if it is an attack, false otherwise.
     */
    public boolean isAttacking(int toX, int toY) {
        // the move already checks if the piece is of the same player, so if there IS a piece, it is an opponent piece.
        return board.getPiece(toX, toY) != null;
    }

    /**
     * This method assumes the move is valid!
     * <p>
     * Moves a piece from the old to the new position in a way that assumes no attack.
     *
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the x-position the piece moves towards.
     * @param toY   the y-position of the piece moves towards.
     */
    public void move(int fromX, int fromY, int toX, int toY) {
        board.move(fromX, fromY, toX, toY);
    }

    /**
     * This method assumes the action is a successful attack!
     *
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the x-position the piece moves towards.
     * @param toY   the y-position of the piece moves towards.
     */
    public void take(int fromX, int fromY, int toX, int toY) {
        board.take(fromX, fromY, toX, toY);
    }

    /**
     * This method assumes that both the from and to positions have opposing pieces!
     * <p>
     * Check if the piece wins or not.
     *
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the x-position the piece moves towards.
     * @param toY   the y-position of the piece moves towards.
     * @return
     */
    public Boolean wins(int fromX, int fromY, int toX, int toY) {
        Piece movingPiece = board.getPiece(fromX, fromY);
        Piece attackedPiece = board.getPiece(toX, toY);
        return movingPiece.winsAttack(attackedPiece);
    }

    private HashMap<PieceType, Integer> takenPieces(Player player) {
        HashMap<PieceType, Integer> pieceTypeAmounts = new HashMap<>();
        for (PieceType pieceType :
                PieceType.values()) {
            int amount = player.getAmount(pieceType);
            pieceTypeAmounts.put(pieceType, amount);
        }
        return pieceTypeAmounts;
    }

    public HashMap<Player, HashMap<PieceType, Integer>> takenPieces() {
        HashMap<Player, HashMap<PieceType, Integer>> playersPiecesTaken = new HashMap<>();
        for (Player player :
                getPlayers()) {
            playersPiecesTaken.put(player, takenPieces(player));
        }
        return playersPiecesTaken;
    }

    // TODO: remove test method
    @Deprecated
    private Player[] createTestPlayers(Board board) {
        Player[] players = new Player[AMOUNT_OF_PLAYERS];
        players[0] = new Player(board, true, BasicBoardSetup.TEST_A);
        players[1] = new Player(board, false, BasicBoardSetup.TEST_B);
        return players;
    }
}
