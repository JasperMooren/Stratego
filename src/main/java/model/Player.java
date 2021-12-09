package model;

import model.pieces.*;

import java.util.ArrayList;

public class Player {

    // Instance Variables
    private final Board board;
    private final ArrayList<AbstractPiece> pieces;
    private final boolean isFirst;

    // Constructor
    public Player(Board board, boolean isFirst) {
        pieces = buildPieces();
        this.board = board;
        this.isFirst = isFirst;
    }

    /**
     * Factory for the pieces to be constructed, based on the AMOUNT static variable in the subclass of Piece.
     *
     * @return the starting pieces that each player has.
     */
    private ArrayList<AbstractPiece> buildPieces() {
        // create an ArrayList of the pieces
        ArrayList<AbstractPiece> abstractPieces = new ArrayList<>();
        for (Class<? extends AbstractPiece> cls : AbstractPiece.PIECE_SUBCLASS_LIST) {
            for (int i = 0; i < AbstractPiece.getAmount(cls); i++) {
                try {
                    abstractPieces.add(cls.getDeclaredConstructor(Player.class).newInstance(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return abstractPieces;
    }

    /**
     * Sets the whole board according to a basic setup defined in the setBoard method.
     *
     * @param basicBoardSetup a type of opening setup
     * @return true if the board is set, else false.
     */
    public boolean setBoard(BasicBoardSetup basicBoardSetup) {
        Class<? extends AbstractPiece>[][] setupPieces = null;
        switch (basicBoardSetup) {
            case DUTCH_OPENING -> setupPieces = getDutchOpening();
            case DE_BOER_OFFENSE -> setupPieces = getDeBoerOffense();
            case SHORELINE_GAMBIT -> setupPieces = getShorelineGambit();
            case FLAG_FLANK_ASSAULT -> setupPieces = getFlagFlankAssault();
            case SCOTTISH_DEFENSE -> setupPieces = getScottishDefense();
            case MINE_FIELD_DEFENSE -> setupPieces = getMineFieldDefense();
            default -> throw new IllegalStateException("Unexpected value: " + basicBoardSetup);
        }
        if (setupPieces.length != Board.Y_LENGTH) {
            return false;
        }
        if (setupPieces[0].length != Board.X_LENGTH) {
            return false;
        }
        for (int y = 0; y < setupPieces.length; y++) {
            for (int x = 0; x < setupPieces[y].length; x++) {
                if (!placePiece(x, y, setupPieces[y][x])) {
                    // TODO: repair stuff
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Takes a piece of a specific type and sets it on the board.
     * If no Piece of the type is found, return false, else return true.
     *
     * @param playerX    the x coordinate to place the piece from the perspective of the player
     * @param playerY    the y coordinate to place the piece from the perspective of the player
     * @param pieceClass the type of piece to place.
     * @return true if the piece is placed, otherwise false (no piece of required type exists).
     */
    public boolean placePiece(int playerX, int playerY, Class<? extends AbstractPiece> pieceClass) {
        AbstractPiece abstractPiece = takePiece(pieceClass);
        if (abstractPiece == null) {
            return false;
        }
        int boardX = getBoardX(playerX);
        int boardY = getBoardY(playerY);
        board.setPiece(boardX, boardY, abstractPiece);
        return true;
    }

    // Standard Openings with hard coded setups:
    private Class<? extends AbstractPiece>[][] getDutchOpening() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends AbstractPiece>[][] setup = new Class[][]{
                {P2Scout.class, P3Miner.class, PBomb.class, P2Scout.class, P3Miner.class,
                        PBomb.class, PFlag.class, PBomb.class, P3Miner.class, P3Miner.class},
                {P4Sergeant.class, PBomb.class, P4Sergeant.class, P7Major.class, P8Colonel.class,
                        P5Lieutenant.class, PBomb.class, P5Lieutenant.class, P6Captain.class, P4Sergeant.class},
                {P5Lieutenant.class, P4Sergeant.class, PBomb.class, P1Spy.class, P9General.class,
                        P2Scout.class, P7Major.class, P7Major.class, P8Colonel.class, P2Scout.class},
                {P6Captain.class, P2Scout.class, P2Scout.class, P5Lieutenant.class, P2Scout.class,
                        P6Captain.class, P3Miner.class, P10Marshal.class, P2Scout.class, P6Captain.class}
        };
        return setup;
    }

    private Class<? extends AbstractPiece>[][] getDeBoerOffense() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends AbstractPiece>[][] setup = new Class[][]{
                {P7Major.class, P3Miner.class, P3Miner.class, P3Miner.class, P4Sergeant.class,
                        PBomb.class, PFlag.class, PBomb.class, PBomb.class, P3Miner.class},
                {P7Major.class, P2Scout.class, P7Major.class, P1Spy.class, P6Captain.class,
                        P5Lieutenant.class, PBomb.class, P4Sergeant.class, P5Lieutenant.class, P2Scout.class},
                {P4Sergeant.class, P2Scout.class, P8Colonel.class, P8Colonel.class, P9General.class,
                        P2Scout.class, P4Sergeant.class, PBomb.class, PBomb.class, P5Lieutenant.class},
                {P10Marshal.class, P6Captain.class, P5Lieutenant.class, P3Miner.class, P2Scout.class,
                        P6Captain.class, P2Scout.class, P2Scout.class, P2Scout.class, P6Captain.class}
        };
        return setup;
    }

    private Class<? extends AbstractPiece>[][] getShorelineGambit() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends AbstractPiece>[][] setup = new Class[][]{
                {P2Scout.class, P4Sergeant.class, P3Miner.class, P5Lieutenant.class, P2Scout.class,
                        P1Spy.class, P4Sergeant.class, PBomb.class, P5Lieutenant.class, P3Miner.class},
                {P5Lieutenant.class, P4Sergeant.class, P6Captain.class, P6Captain.class, P3Miner.class,
                        P3Miner.class, P6Captain.class, P2Scout.class, P6Captain.class, P5Lieutenant.class},
                {P7Major.class, P9General.class, P8Colonel.class, PBomb.class, P10Marshal.class,
                        P7Major.class, PBomb.class, P3Miner.class, P8Colonel.class, P7Major.class},
                {P2Scout.class, P2Scout.class, PBomb.class, PFlag.class, PBomb.class,
                        PBomb.class, P4Sergeant.class, P2Scout.class, P2Scout.class, P2Scout.class}
        };
        return setup;
    }

    private Class<? extends AbstractPiece>[][] getFlagFlankAssault() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends AbstractPiece>[][] setup = new Class[][]{
                {PFlag.class, PBomb.class, P7Major.class, P3Miner.class, P7Major.class,
                        P6Captain.class, PBomb.class, P3Miner.class, P2Scout.class, P5Lieutenant.class},
                {PBomb.class, P3Miner.class, P1Spy.class, P7Major.class, P6Captain.class,
                        PBomb.class, P3Miner.class, P6Captain.class, P5Lieutenant.class, P2Scout.class},
                {P8Colonel.class, P10Marshal.class, P2Scout.class, P8Colonel.class, PBomb.class,
                        P5Lieutenant.class, P2Scout.class, P5Lieutenant.class, P2Scout.class, P3Miner.class},
                {P6Captain.class, P2Scout.class, P9General.class, PBomb.class, P4Sergeant.class,
                        P4Sergeant.class, P2Scout.class, P2Scout.class, P4Sergeant.class, P4Sergeant.class}
        };
        return setup;
    }

    private Class<? extends AbstractPiece>[][] getScottishDefense() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends AbstractPiece>[][] setup = new Class[][]{
                {PFlag.class, PBomb.class, P4Sergeant.class, PBomb.class, P6Captain.class,
                        P3Miner.class, P3Miner.class, P3Miner.class, P5Lieutenant.class, P7Major.class},
                {PBomb.class, P4Sergeant.class, PBomb.class, P2Scout.class, P2Scout.class,
                        P5Lieutenant.class, P4Sergeant.class, P6Captain.class, P2Scout.class, P6Captain.class},
                {P4Sergeant.class, PBomb.class, P3Miner.class, P6Captain.class, P7Major.class,
                        P10Marshal.class, P2Scout.class, P2Scout.class, P7Major.class, P2Scout.class},
                {PBomb.class, P9General.class, P1Spy.class, P8Colonel.class, P4Sergeant.class,
                        P4Sergeant.class, P2Scout.class, P2Scout.class, P4Sergeant.class, P4Sergeant.class}
        };
        return setup;
    }

    private Class<? extends AbstractPiece>[][] getMineFieldDefense() {

    }

    /**
     * Takes a piece of a specific class from the player and returns it.
     *
     * @param pieceClass a subclass (such as Scout.class) of Piece
     * @return a Piece object, or null of no instance of the given class exists in the array.
     */
    private AbstractPiece takePiece(Class<? extends AbstractPiece> pieceClass) {
        // create the variable
        AbstractPiece abstractPiece = null;
        // loop through the ArrayList
        for (int i = 0; i < pieces.size(); i++) {
            // check if the piece is of the type given.
            if (pieceClass.isInstance(pieces.get(i))) {
                // remove it from the player's stock.
                abstractPiece = pieces.remove(i);
            }
        }
        // return the piece.
        return abstractPiece;
    }

    private int getBoardX(int playerX) {
        if (isFirst) {
            return playerX;
        }
        // -1 because a board length of 10 goes from 0 to 9, so position 2 flips to 7, not 8.
        int boardX = Board.X_LENGTH - playerX - 1;
        return boardX;
    }


    private int getBoardY(int playerY) {
        if (isFirst) {
            return playerY;
        }
        // -1 because a board length of 10 goes from 0 to 9, so position 2 flips to 7, not 8.
        int boardY = Board.Y_LENGTH - playerY - 1;
        ;
        return boardY;
    }
}
