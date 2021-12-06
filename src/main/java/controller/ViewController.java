package controller;

import itvitae.strategogui.FXController;

public class ViewController {

    // Instance Variables
    private final FXController fxController;
    private final ModelController modelController;

    // Constructor
    public ViewController(FXController fxController) {
        this.fxController = fxController;
        modelController = new ModelController(this);
    }
}
