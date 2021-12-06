package itvitae.strategogui;

import controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXController {

    // Instance Variables
    private final ViewController viewController;

    // Constructor
    public FXController() {
        viewController = new ViewController(this);
    }

    public void initialise() {

    }

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

}