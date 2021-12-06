package controller;

import model.Game;

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

}
