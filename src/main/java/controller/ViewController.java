package controller;

import itvitae.strategogui.FXController;
import model.Board;
import model.pieces.*;

public class ViewController {

    // Instance Variables
    private final FXController fxController;
    private final ModelController modelController;

    // Constructor
    public ViewController(FXController fxController) {
        this.fxController = fxController;
        modelController = new ModelController(this);
    }

    public void buttonClicked(int x, int y) {
        System.out.println("(" + x + "," + y + ")");
    }

    public void showBoard(Board board) {
        String pieceName;
        for (int y = 0; y < Board.Y_LENGTH; y++) {
            for (int x = 0; x < Board.X_LENGTH; x++) {
                pieceName = pieceToString(board.getPiece(x, y));
                if (pieceName != null) {
                    fxController.setButtonText(pieceName, x, y);
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

    public void showBoard() {
        modelController.showBoard();
    }
}
