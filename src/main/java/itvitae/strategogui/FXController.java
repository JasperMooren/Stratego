package itvitae.strategogui;

import controller.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.io.File;
import java.security.InvalidParameterException;


public class FXController {

    @FXML private Button button99;
    @FXML private Button button89;
    @FXML private Button button79;
    @FXML private Button button69;
    @FXML private Button button59;
    @FXML private Button button49;
    @FXML private Button button39;
    @FXML private Button button29;
    @FXML private Button button19;
    @FXML private Button button09;
    @FXML private Button button98;
    @FXML private Button button88;
    @FXML private Button button78;
    @FXML private Button button68;
    @FXML private Button button58;
    @FXML private Button button48;
    @FXML private Button button38;
    @FXML private Button button28;
    @FXML private Button button18;
    @FXML private Button button08;
    @FXML private Button button97;
    @FXML private Button button87;
    @FXML private Button button77;
    @FXML private Button button67;
    @FXML private Button button57;
    @FXML private Button button47;
    @FXML private Button button37;
    @FXML private Button button27;
    @FXML private Button button17;
    @FXML private Button button07;
    @FXML private Button button96;
    @FXML private Button button86;
    @FXML private Button button76;
    @FXML private Button button66;
    @FXML private Button button56;
    @FXML private Button button46;
    @FXML private Button button36;
    @FXML private Button button26;
    @FXML private Button button16;
    @FXML private Button button06;
    @FXML private Button button95;
    @FXML private Button button85;
    @FXML private Button button75;
    @FXML private Button button65;
    @FXML private Button button55;
    @FXML private Button button45;
    @FXML private Button button35;
    @FXML private Button button25;
    @FXML private Button button15;
    @FXML private Button button05;
    @FXML private Button button94;
    @FXML private Button button84;
    @FXML private Button button74;
    @FXML private Button button64;
    @FXML private Button button54;
    @FXML private Button button44;
    @FXML private Button button34;
    @FXML private Button button24;
    @FXML private Button button14;
    @FXML private Button button04;
    @FXML private Button button93;
    @FXML private Button button83;
    @FXML private Button button73;
    @FXML private Button button63;
    @FXML private Button button53;
    @FXML private Button button43;
    @FXML private Button button33;
    @FXML private Button button23;
    @FXML private Button button13;
    @FXML private Button button03;
    @FXML private Button button92;
    @FXML private Button button82;
    @FXML private Button button72;
    @FXML private Button button62;
    @FXML private Button button52;
    @FXML private Button button42;
    @FXML private Button button32;
    @FXML private Button button22;
    @FXML private Button button12;
    @FXML private Button button02;
    @FXML private Button button91;
    @FXML private Button button81;
    @FXML private Button button71;
    @FXML private Button button61;
    @FXML private Button button51;
    @FXML private Button button41;
    @FXML private Button button31;
    @FXML private Button button21;
    @FXML private Button button11;
    @FXML private Button button01;
    @FXML private Button button90;
    @FXML private Button button80;
    @FXML private Button button70;
    @FXML private Button button60;
    @FXML private Button button50;
    @FXML private Button button40;
    @FXML private Button button30;
    @FXML private Button button20;
    @FXML private Button button10;
    @FXML private Button button00;

    @FXML
    private GridPane gridPane;

    // Constants
    public static final int X_SIZE = 10;
    public static final int Y_SIZE = 10;

    private static final Background BACKGROUND = getBackground();

    private static Background getBackground() {
        // get the absolute path to the background image
        String backgroundPath =
                new File("src/main/resources/images/Stratego_better 800x800.jpg").toURI().toString();
        BackgroundImage backgroundImage = new BackgroundImage(new Image(backgroundPath),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }


    // Instance Variables
    private final ViewController viewController;

    // Constructor
    public FXController() {
        viewController = new ViewController(this);
    }

    @FXML
    public void initialize() {
        for (int y = 0; y < Y_SIZE; y++) {
            for (int x = 0; x < X_SIZE; x++) {
                initializeButton(getButton(x, y));
            }
        }
        gridPane.setBackground(BACKGROUND);
        gridPane.setGridLinesVisible(false);
        viewController.showBoard();
    }

    private void initializeButton(Button button) {
        button.setStyle(
                "-fx-background-color:transparent;"
        );
        button.setFont(Font.font(null, FontWeight.BOLD, 28));
    }


    public void onButton99Click() {viewController.buttonClicked(9,9);}
    public void onButton89Click() {viewController.buttonClicked(8,9);}
    public void onButton79Click() {viewController.buttonClicked(7,9);}
    public void onButton69Click() {viewController.buttonClicked(6,9);}
    public void onButton59Click() {viewController.buttonClicked(5,9);}
    public void onButton49Click() {viewController.buttonClicked(4,9);}
    public void onButton39Click() {viewController.buttonClicked(3,9);}
    public void onButton29Click() {viewController.buttonClicked(2,9);}
    public void onButton19Click() {viewController.buttonClicked(1,9);}
    public void onButton09Click() {viewController.buttonClicked(0,9);}
    public void onButton98Click() {viewController.buttonClicked(9,8);}
    public void onButton88Click() {viewController.buttonClicked(8,8);}
    public void onButton78Click() {viewController.buttonClicked(7,8);}
    public void onButton68Click() {viewController.buttonClicked(6,8);}
    public void onButton58Click() {viewController.buttonClicked(5,8);}
    public void onButton48Click() {viewController.buttonClicked(4,8);}
    public void onButton38Click() {viewController.buttonClicked(3,8);}
    public void onButton28Click() {viewController.buttonClicked(2,8);}
    public void onButton18Click() {viewController.buttonClicked(1,8);}
    public void onButton08Click() {viewController.buttonClicked(0,8);}
    public void onButton97Click() {viewController.buttonClicked(9,7);}
    public void onButton87Click() {viewController.buttonClicked(8,7);}
    public void onButton77Click() {viewController.buttonClicked(7,7);}
    public void onButton67Click() {viewController.buttonClicked(6,7);}
    public void onButton57Click() {viewController.buttonClicked(5,7);}
    public void onButton47Click() {viewController.buttonClicked(4,7);}
    public void onButton37Click() {viewController.buttonClicked(3,7);}
    public void onButton27Click() {viewController.buttonClicked(2,7);}
    public void onButton17Click() {viewController.buttonClicked(1,7);}
    public void onButton07Click() {viewController.buttonClicked(0,7);}
    public void onButton96Click() {viewController.buttonClicked(9,6);}
    public void onButton86Click() {viewController.buttonClicked(8,6);}
    public void onButton76Click() {viewController.buttonClicked(7,6);}
    public void onButton66Click() {viewController.buttonClicked(6,6);}
    public void onButton56Click() {viewController.buttonClicked(5,6);}
    public void onButton46Click() {viewController.buttonClicked(4,6);}
    public void onButton36Click() {viewController.buttonClicked(3,6);}
    public void onButton26Click() {viewController.buttonClicked(2,6);}
    public void onButton16Click() {viewController.buttonClicked(1,6);}
    public void onButton06Click() {viewController.buttonClicked(0,6);}
    public void onButton95Click() {viewController.buttonClicked(9,5);}
    public void onButton85Click() {viewController.buttonClicked(8,5);}
    public void onButton75Click() {viewController.buttonClicked(7,5);}
    public void onButton65Click() {viewController.buttonClicked(6,5);}
    public void onButton55Click() {viewController.buttonClicked(5,5);}
    public void onButton45Click() {viewController.buttonClicked(4,5);}
    public void onButton35Click() {viewController.buttonClicked(3,5);}
    public void onButton25Click() {viewController.buttonClicked(2,5);}
    public void onButton15Click() {viewController.buttonClicked(1,5);}
    public void onButton05Click() {viewController.buttonClicked(0,5);}
    public void onButton94Click() {viewController.buttonClicked(9,4);}
    public void onButton84Click() {viewController.buttonClicked(8,4);}
    public void onButton74Click() {viewController.buttonClicked(7,4);}
    public void onButton64Click() {viewController.buttonClicked(6,4);}
    public void onButton54Click() {viewController.buttonClicked(5,4);}
    public void onButton44Click() {viewController.buttonClicked(4,4);}
    public void onButton34Click() {viewController.buttonClicked(3,4);}
    public void onButton24Click() {viewController.buttonClicked(2,4);}
    public void onButton14Click() {viewController.buttonClicked(1,4);}
    public void onButton04Click() {viewController.buttonClicked(0,4);}
    public void onButton93Click() {viewController.buttonClicked(9,3);}
    public void onButton83Click() {viewController.buttonClicked(8,3);}
    public void onButton73Click() {viewController.buttonClicked(7,3);}
    public void onButton63Click() {viewController.buttonClicked(6,3);}
    public void onButton53Click() {viewController.buttonClicked(5,3);}
    public void onButton43Click() {viewController.buttonClicked(4,3);}
    public void onButton33Click() {viewController.buttonClicked(3,3);}
    public void onButton23Click() {viewController.buttonClicked(2,3);}
    public void onButton13Click() {viewController.buttonClicked(1,3);}
    public void onButton03Click() {viewController.buttonClicked(0,3);}
    public void onButton92Click() {viewController.buttonClicked(9,2);}
    public void onButton82Click() {viewController.buttonClicked(8,2);}
    public void onButton72Click() {viewController.buttonClicked(7,2);}
    public void onButton62Click() {viewController.buttonClicked(6,2);}
    public void onButton52Click() {viewController.buttonClicked(5,2);}
    public void onButton42Click() {viewController.buttonClicked(4,2);}
    public void onButton32Click() {viewController.buttonClicked(3,2);}
    public void onButton22Click() {viewController.buttonClicked(2,2);}
    public void onButton12Click() {viewController.buttonClicked(1,2);}
    public void onButton02Click() {viewController.buttonClicked(0,2);}
    public void onButton91Click() {viewController.buttonClicked(9,1);}
    public void onButton81Click() {viewController.buttonClicked(8,1);}
    public void onButton71Click() {viewController.buttonClicked(7,1);}
    public void onButton61Click() {viewController.buttonClicked(6,1);}
    public void onButton51Click() {viewController.buttonClicked(5,1);}
    public void onButton41Click() {viewController.buttonClicked(4,1);}
    public void onButton31Click() {viewController.buttonClicked(3,1);}
    public void onButton21Click() {viewController.buttonClicked(2,1);}
    public void onButton11Click() {viewController.buttonClicked(1,1);}
    public void onButton01Click() {viewController.buttonClicked(0,1);}
    public void onButton90Click() {viewController.buttonClicked(9,0);}
    public void onButton80Click() {viewController.buttonClicked(8,0);}
    public void onButton70Click() {viewController.buttonClicked(7,0);}
    public void onButton60Click() {viewController.buttonClicked(6,0);}
    public void onButton50Click() {viewController.buttonClicked(5,0);}
    public void onButton40Click() {viewController.buttonClicked(4,0);}
    public void onButton30Click() {viewController.buttonClicked(3,0);}
    public void onButton20Click() {viewController.buttonClicked(2,0);}
    public void onButton10Click() {viewController.buttonClicked(1,0);}
    public void onButton00Click() {viewController.buttonClicked(0,0);}

    private Button getButton(int x, int y) {
        if (x == 9 && y == 9) {return button99;}
        if (x == 8 && y == 9) {return button89;}
        if (x == 7 && y == 9) {return button79;}
        if (x == 6 && y == 9) {return button69;}
        if (x == 5 && y == 9) {return button59;}
        if (x == 4 && y == 9) {return button49;}
        if (x == 3 && y == 9) {return button39;}
        if (x == 2 && y == 9) {return button29;}
        if (x == 1 && y == 9) {return button19;}
        if (x == 0 && y == 9) {return button09;}
        if (x == 9 && y == 8) {return button98;}
        if (x == 8 && y == 8) {return button88;}
        if (x == 7 && y == 8) {return button78;}
        if (x == 6 && y == 8) {return button68;}
        if (x == 5 && y == 8) {return button58;}
        if (x == 4 && y == 8) {return button48;}
        if (x == 3 && y == 8) {return button38;}
        if (x == 2 && y == 8) {return button28;}
        if (x == 1 && y == 8) {return button18;}
        if (x == 0 && y == 8) {return button08;}
        if (x == 9 && y == 7) {return button97;}
        if (x == 8 && y == 7) {return button87;}
        if (x == 7 && y == 7) {return button77;}
        if (x == 6 && y == 7) {return button67;}
        if (x == 5 && y == 7) {return button57;}
        if (x == 4 && y == 7) {return button47;}
        if (x == 3 && y == 7) {return button37;}
        if (x == 2 && y == 7) {return button27;}
        if (x == 1 && y == 7) {return button17;}
        if (x == 0 && y == 7) {return button07;}
        if (x == 9 && y == 6) {return button96;}
        if (x == 8 && y == 6) {return button86;}
        if (x == 7 && y == 6) {return button76;}
        if (x == 6 && y == 6) {return button66;}
        if (x == 5 && y == 6) {return button56;}
        if (x == 4 && y == 6) {return button46;}
        if (x == 3 && y == 6) {return button36;}
        if (x == 2 && y == 6) {return button26;}
        if (x == 1 && y == 6) {return button16;}
        if (x == 0 && y == 6) {return button06;}
        if (x == 9 && y == 5) {return button95;}
        if (x == 8 && y == 5) {return button85;}
        if (x == 7 && y == 5) {return button75;}
        if (x == 6 && y == 5) {return button65;}
        if (x == 5 && y == 5) {return button55;}
        if (x == 4 && y == 5) {return button45;}
        if (x == 3 && y == 5) {return button35;}
        if (x == 2 && y == 5) {return button25;}
        if (x == 1 && y == 5) {return button15;}
        if (x == 0 && y == 5) {return button05;}
        if (x == 9 && y == 4) {return button94;}
        if (x == 8 && y == 4) {return button84;}
        if (x == 7 && y == 4) {return button74;}
        if (x == 6 && y == 4) {return button64;}
        if (x == 5 && y == 4) {return button54;}
        if (x == 4 && y == 4) {return button44;}
        if (x == 3 && y == 4) {return button34;}
        if (x == 2 && y == 4) {return button24;}
        if (x == 1 && y == 4) {return button14;}
        if (x == 0 && y == 4) {return button04;}
        if (x == 9 && y == 3) {return button93;}
        if (x == 8 && y == 3) {return button83;}
        if (x == 7 && y == 3) {return button73;}
        if (x == 6 && y == 3) {return button63;}
        if (x == 5 && y == 3) {return button53;}
        if (x == 4 && y == 3) {return button43;}
        if (x == 3 && y == 3) {return button33;}
        if (x == 2 && y == 3) {return button23;}
        if (x == 1 && y == 3) {return button13;}
        if (x == 0 && y == 3) {return button03;}
        if (x == 9 && y == 2) {return button92;}
        if (x == 8 && y == 2) {return button82;}
        if (x == 7 && y == 2) {return button72;}
        if (x == 6 && y == 2) {return button62;}
        if (x == 5 && y == 2) {return button52;}
        if (x == 4 && y == 2) {return button42;}
        if (x == 3 && y == 2) {return button32;}
        if (x == 2 && y == 2) {return button22;}
        if (x == 1 && y == 2) {return button12;}
        if (x == 0 && y == 2) {return button02;}
        if (x == 9 && y == 1) {return button91;}
        if (x == 8 && y == 1) {return button81;}
        if (x == 7 && y == 1) {return button71;}
        if (x == 6 && y == 1) {return button61;}
        if (x == 5 && y == 1) {return button51;}
        if (x == 4 && y == 1) {return button41;}
        if (x == 3 && y == 1) {return button31;}
        if (x == 2 && y == 1) {return button21;}
        if (x == 1 && y == 1) {return button11;}
        if (x == 0 && y == 1) {return button01;}
        if (x == 9 && y == 0) {return button90;}
        if (x == 8 && y == 0) {return button80;}
        if (x == 7 && y == 0) {return button70;}
        if (x == 6 && y == 0) {return button60;}
        if (x == 5 && y == 0) {return button50;}
        if (x == 4 && y == 0) {return button40;}
        if (x == 3 && y == 0) {return button30;}
        if (x == 2 && y == 0) {return button20;}
        if (x == 1 && y == 0) {return button10;}
        if (x == 0 && y == 0) {return button00;}
        return null;
    }

    /**
     * sets the text of a button to the designated value.
     *
     * @param text the String to be set
     * @param x    the x value between 0 and X_SIZE
     * @param y    the y value between 0 and Y_SIZE
     */
    public void setButtonText(String text, int x, int y) {
        if (x < 0 || x >= X_SIZE || y < 0 || y >= Y_SIZE || text == null) {
            throw new InvalidParameterException();
        }
        System.out.println("x: " + x + ", y: " + y + ", text: " + text);
        Button b = getButton(x, y);
        b.setText(text); // for valid inputs this shouldn't be null.
    }
}
