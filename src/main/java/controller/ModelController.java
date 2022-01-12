package controller;

import model.Board;
import model.Game;
import model.Player;
import model.pieces.Piece;
import model.pieces.PieceType;

import java.util.HashMap;

public class ModelController {

    // Instance Variable
    // View
    private final ViewController viewController;

    // Model
    private final Game game;

    public ModelController(ViewController viewController) {
        this.viewController = viewController;
        this.game = new Game();
    }

    public void showBoard() {
        Player currentPlayer = game.getCurrentPlayer();
        Board board = game.getBoard();
        if (!currentPlayer.getIsFirst()) {
            board = board.getFlippedBoard();
        }
        viewController.updateBoard(board);
    }

    /**
     * The game moves a piece from (fromX, fromY) to (toX, toY) and performs the necessary action.
     * If it cannot move, it returns false.
     *
     * @param fromX the original x-position of the piece.
     * @param fromY the original y-position of the piece.
     * @param toX   the desired x-position of the piece.
     * @param toY   the desired y-position of the piece.
     * @return true if it has moved, false otherwise.
     */
    private boolean move(int fromX, int fromY, int toX, int toY) {

        // check if the move is valid.
        if (!game.canMove(fromX, fromY, toX, toY)) {
            return false;
        }

        // check if the move is an attack or not.
        if (!game.isAttacking(toX, toY)) {

            // it is just a move, so do a move without an attack
            game.move(fromX, fromY, toX, toY);
            return true;
        }

        // See who wins the attack
        Boolean wins = game.wins(fromX, fromY, toX, toY);
        if (wins == null) {
            System.out.println("wins == null");
        }
        else {
            System.out.println("wins == "  + wins.toString());
        }

        // a draw, both players lose their pieces
        if (wins == null) {
            game.getBoard().lose(fromX, fromY);
            game.getBoard().lose(toX, toY);
            return true;
        }

        // the player takes the opponent's piece
        if (wins) {
            game.take(fromX, fromY, toX, toY);
            return true;
        }

        // the player loses their piece
        game.getBoard().lose(fromX, fromY);
        return true;
    }
  
    public void showTakenPieces() {
        viewController.showTakenPieces(game.takenPieces());
    }

    public void doTurn(int fromX, int fromY, int toX, int toY) {
        if (!game.getCurrentPlayer().getIsFirst()) {
            fromX = Board.getFlippedCoordinate(fromX, true);
            fromY = Board.getFlippedCoordinate(fromY, false);
            toX = Board.getFlippedCoordinate(toX, true);
            toY = Board.getFlippedCoordinate(toY, false);
        }
        // did not do a valid move, therefore didn't do a turn
        if (!move(fromX, fromY, toX, toY)) {
            return;
        }

        if (game.getCurrentPlayer().hasWon()) {
            endGame();
        }
        else {
            endTurn();
        }
    }

    private void endTurn() {
        game.nextTurn();
        showBoard();
    }

    //TODO: implement
    private void endGame() {
        System.out.println("Game ended!");
    }
}
