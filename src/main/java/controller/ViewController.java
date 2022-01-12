package controller;

import itvitae.strategogui.FXController;
import javafx.scene.paint.Color;
import model.Board;
import model.Player;
import model.pieces.*;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;

public class ViewController {

    public static final int AMOUNT_OF_PLAYERS = 2;
    public static final Color BLACK = Color.BLACK;
    public static final Color BLUE = Color.BLUE;
    public static final Color RED = Color.rgb(160, 0, 0);

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
                if (p == null) {
                    pieceName = "";
                }
                else {
                    pieceName = pieceToString(p.getPieceType());
                }
                if (p == null) {
                    color = BLACK;
                } else if (p.getPlayer().getIsFirst()) {
                    color = RED;
                } else {
                    color = BLUE;
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

    private String pieceToString(PieceType pieceType) {
        if (pieceType == null) {
            return "";
        }
        if (pieceType == PieceType.P1_SPY) {
            return "S";
        }
        if (pieceType == PieceType.P2_SCOUT) {
            return "2";
        }
        if (pieceType == PieceType.P3_MINER) {
            return "3";
        }
        if (pieceType == PieceType.P4_SERGEANT) {
            return "4";
        }
        if (pieceType == PieceType.P5_LIEUTENANT) {
            return "5";
        }
        if (pieceType == PieceType.P6_CAPTAIN) {
            return "6";
        }
        if (pieceType == PieceType.P7_MAJOR) {
            return "7";
        }
        if (pieceType == PieceType.P8_COLONEL) {
            return "8";
        }
        if (pieceType == PieceType.P9_GENERAL) {
            return "9";
        }
        if (pieceType == PieceType.P10_MARSHAL) {
            return "10";
        }
        if (pieceType == PieceType.P_FLAG) {
            return "F";
        }
        if (pieceType == PieceType.P_BOMB) {
            return "B";
        }
        return null;
    }

    public void showTakenPieces(HashMap<Player, HashMap<PieceType, Integer>> takenPieces, boolean flippedBoard) {
        Player[] players = takenPieces.keySet().toArray(new Player[0]);

        if (players.length != AMOUNT_OF_PLAYERS) {
            System.out.println("ERROR: Wrong amount of players!");
            return;
        }
        boolean isFirst;
        for (Player player :
                players) {
            isFirst = player.getIsFirst();
            Color color;
            if (isFirst) {
                color = RED;
            }
            else {
                color = BLUE;
            }
            if (flippedBoard) {
                System.out.println("Board is flipped!");
                System.out.println("Preflip: " + isFirst);
                isFirst = !isFirst;
                System.out.println("Postflip: " + isFirst);
            }
            showTakenPieces(isFirst, takenPieces.get(player), color);
        }
    }

    private void showTakenPieces(boolean isFirst, HashMap<PieceType, Integer> pieceTypeAmounts, Color color) {
        setButton(isFirst, PieceType.P1_SPY, pieceTypeAmounts.get(PieceType.P1_SPY), color);
        setButton(isFirst, PieceType.P2_SCOUT, pieceTypeAmounts.get(PieceType.P2_SCOUT), color);
        setButton(isFirst, PieceType.P3_MINER, pieceTypeAmounts.get(PieceType.P3_MINER), color);
        setButton(isFirst, PieceType.P4_SERGEANT, pieceTypeAmounts.get(PieceType.P4_SERGEANT), color);
        setButton(isFirst, PieceType.P5_LIEUTENANT, pieceTypeAmounts.get(PieceType.P5_LIEUTENANT), color);
        setButton(isFirst, PieceType.P6_CAPTAIN, pieceTypeAmounts.get(PieceType.P6_CAPTAIN), color);
        setButton(isFirst, PieceType.P7_MAJOR, pieceTypeAmounts.get(PieceType.P7_MAJOR), color);
        setButton(isFirst, PieceType.P8_COLONEL, pieceTypeAmounts.get(PieceType.P8_COLONEL), color);
        setButton(isFirst, PieceType.P9_GENERAL, pieceTypeAmounts.get(PieceType.P9_GENERAL), color);
        setButton(isFirst, PieceType.P10_MARSHAL, pieceTypeAmounts.get(PieceType.P10_MARSHAL), color);
        setButton(isFirst, PieceType.P_BOMB, pieceTypeAmounts.get(PieceType.P_BOMB), color);
        setButton(isFirst, PieceType.P_FLAG, pieceTypeAmounts.get(PieceType.P_FLAG), color);
    }

    private void setButton(boolean isFirst, PieceType pieceType, int amount, Color color) {
        String buttonText;
        switch (pieceType) {
            case P1_SPY -> buttonText = "S: ";
            case P2_SCOUT -> buttonText = "2: ";
            case P3_MINER -> buttonText = "3: ";
            case P4_SERGEANT -> buttonText = "4: ";
            case P5_LIEUTENANT -> buttonText = "5: ";
            case P6_CAPTAIN -> buttonText = "6: ";
            case P7_MAJOR -> buttonText = "7: ";
            case P8_COLONEL -> buttonText = "8: ";
            case P9_GENERAL -> buttonText = "9: ";
            case P10_MARSHAL -> buttonText = "10: ";
            case P_BOMB -> buttonText = "B: ";
            case P_FLAG -> buttonText = "F: ";
            default -> throw new InvalidParameterException();
        }
        buttonText += amount;
        fxController.setButton(isFirst, pieceType, buttonText, color);
    }

    public void updateView() {
        modelController.updateView();
    }
}
