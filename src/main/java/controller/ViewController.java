package controller;

import itvitae.strategogui.FXController;
import javafx.scene.paint.Color;
import model.Board;
import model.pieces.*;

public class ViewController {

    // Instance Variables
    private final FXController fxController;
    private final ModelController modelController;
    private int[] firstCoordinate;

    // Constructor
    public ViewController(FXController fxController) {
        this.fxController = fxController;
        modelController = new ModelController(this);
    }

    public void buttonClicked(int x, int y) {
        //TODO: remove test code

        // System.out.println("(" + x + "," + y + ")");

        // TODO: add some code for if the game has started or not (now the game starts when the application is loaded)
        setCoordinate(x, y);
    }

    private void setCoordinate(int x, int y) {
        if (firstCoordinate == null) {
            firstCoordinate = new int[]{x, y};
            System.out.println("First coordinate: (" + x + ", " + y + ")");
        } else {
            System.out.println("Second coordinate: (" + x + ", " + y + ")");
            modelController.doTurn(firstCoordinate[0], firstCoordinate[1], x, y);
            firstCoordinate = null;
            System.out.println("First coordinate: null");
        }
    }

    public void buttonClicked(boolean isFirst, PieceType pieceType) {
        System.out.println("(" + isFirst + "," + pieceType.toString() + ")");
    }

    /**
     * Requests the model Controller to show the board based on the board found in the model.
     */
    public void updateBoard() {
        modelController.showBoard();
    }

    /**
     * Updates the board according to the board given in the parameter.
     *
     * @param board the board to be updated.
     */
    public void updateBoard(Board board) {
        Piece p;
        String pieceName;
        Color color;
        for (int y = 0; y < Board.Y_LENGTH; y++) {
            for (int x = 0; x < Board.X_LENGTH; x++) {
                p = board.getPiece(x, y);
                pieceName = pieceToString(p);
                if (p == null) {
                    color = Color.BLACK;
                } else if (p.getPlayer().getIsFirst()) {
                    color = Color.rgb(160, 0, 0);
                } else {
                    color = Color.BLUE;
                }
                if (pieceName != null) {
                    fxController.setButtonText(pieceName, x, y, color);
                } else {
                    // test code, this shouldn't run -> piece is not one of the defined subclasses or null.
                    System.out.println("ERROR: invalid piece!");
                }
            }
        }
    }

    private String pieceToString(Piece piece) {
        if (piece == null) {
            return "";
        }
        if (piece instanceof P1Spy) {
            return "S";
        }
        if (piece instanceof P2Scout) {
            return "2";
        }
        if (piece instanceof P3Miner) {
            return "3";
        }
        if (piece instanceof P4Sergeant) {
            return "4";
        }
        if (piece instanceof P5Lieutenant) {
            return "5";
        }
        if (piece instanceof P6Captain) {
            return "6";
        }
        if (piece instanceof P7Major) {
            return "7";
        }
        if (piece instanceof P8Colonel) {
            return "8";
        }
        if (piece instanceof P9General) {
            return "9";
        }
        if (piece instanceof P10Marshal) {
            return "10";
        }
        if (piece instanceof PFlag) {
            return "F";
        }
        if (piece instanceof PBomb) {
            return "B";
        }
        return null;
    }
}
