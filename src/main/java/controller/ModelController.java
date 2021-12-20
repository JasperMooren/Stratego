package controller;

import model.Board;
import model.Game;
import model.Player;

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

}
