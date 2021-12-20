package model;

import model.pieces.*;

import java.util.ArrayList;

public class Player {

    // Instance Variables
    private final boolean isFirst;
    private final Board board;
    private final ArrayList<Piece> pieces;

    // Constructor
    public Player(Board board, boolean isFirst) {
        this.isFirst = isFirst;
        this.board = board;
        pieces = buildPieces();
    }

    // Test Constructor
    @Deprecated
    public Player(Board board, boolean isFirst, BasicBoardSetup basicBoardSetup) {
        this.isFirst = isFirst;
        this.board = board;
        pieces = buildPieces();
        setBoard(basicBoardSetup);
    }

    // Factories

    /**
     * Factory for the pieces to be constructed, based on the AMOUNT static variable in the subclass of Piece.
     *
     * @return the starting pieces that each player has.
     */
    private ArrayList<Piece> buildPieces() {
        // create an ArrayList of the pieces
        ArrayList<Piece> pieces = new ArrayList<>();
        for (Class<? extends Piece> cls : Piece.PIECE_SUBCLASS_LIST) {
            for (int i = 0; i < Piece.getAmount(cls); i++) {
                try {
                    pieces.add(cls.getDeclaredConstructor(Player.class).newInstance(this));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return pieces;
    }

    // Setters

    /**
     * Sets the whole board according to a basic setup defined in the setBoard method.
     *
     * @param basicBoardSetup a type of opening setup
     * @return true if the board is set, else false.
     */
    public boolean setBoard(BasicBoardSetup basicBoardSetup) {
        Class<? extends Piece>[][] setupPieces;
        switch (basicBoardSetup) {
            case DUTCH_OPENING -> setupPieces = getDutchOpening();
            case DE_BOER_OFFENSE -> setupPieces = getDeBoerOffense();
            case SHORELINE_GAMBIT -> setupPieces = getShorelineGambit();
            case FLAG_FLANK_ASSAULT -> setupPieces = getFlagFlankAssault();
            case SCOTTISH_DEFENSE -> setupPieces = getScottishDefense();
            case MINE_FIELD_DEFENSE -> setupPieces = getMineFieldDefense();
            // TODO: remove test code
            case TEST_A -> setupPieces = getTestA();
            case TEST_B -> setupPieces = getTestB();
            // end test code

            // code should never run, but if something funny happens that a BasicBoardSetup is called that doesn't exist
            // (or a null input), then at least we get a useful error.
            default -> throw new IllegalStateException("Unexpected value: " + basicBoardSetup);
        }
        // check if the setup is smaller than half of the board.
        if (!(setupPieces.length < (Board.Y_LENGTH / 2))) {
            System.out.println("Y_LENGTH incorrect");
            return false;
        }
        // check if all x values are the width of the board.
        for (int y = 0; y < setupPieces.length; y++) {
            if (setupPieces[y].length != Board.X_LENGTH) {
                System.out.println("X_LENGTH incorrect");
                return false;
            }
        }
        for (int y = 0; y < setupPieces.length; y++) {
            for (int x = 0; x < setupPieces[y].length; x++) {
                if (!placePiece(x, y, setupPieces[y][x])) {
                    reset(x, y, setupPieces);
                    return false;
                }
            }
        }
        return true;
    }

    // Getters

    public boolean getIsFirst() {
        return isFirst;
    }

    /**
     * refills the pieces ArrayList and empties the board, based on incorrect changes to both
     *
     * @param maxX        the x position at which the error occurred
     * @param maxY        the y position at which the error occurred
     * @param setupPieces the format from which the player tried to add pieces.
     */
    private void reset(int maxX, int maxY, Class<? extends Piece>[][] setupPieces) {
        System.out.println("Reset method called: maxX: " + maxX + ", maxY: " + maxY);
        for (int y = 0; y < setupPieces.length; y++) {
            for (int x = 0; x < setupPieces[y].length; x++) {
                if (x == maxX && y == maxY) {
                    return;
                }
                placePiece(x, y, (Piece) null);
                // try always works, because it asks for a constructor of a subclass of Piece,
                // which has to be implemented
                try {
                    // Reflectively constructs a piece based on the subclass given in the array.
                    Piece piece =
                            setupPieces[y][x].getDeclaredConstructor(Player.class).newInstance(this);
                    pieces.add(piece);
                } catch (Exception e) { // this code should never run -> getDeclaredConstructor() demands it.
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Places a piece on a coordinate based on the orientation of the player.
     *
     * @param playerX the x coordinate to place the piece from the perspective of the player
     * @param playerY the y coordinate to place the piece from the perspective of the player
     * @param piece   the piece to place.
     */
    public void placePiece(int playerX, int playerY, Piece piece) {
        int boardX = getFlipped(playerX, true);
        int boardY = getFlipped(playerY, false);
        board.setPiece(boardX, boardY, piece);
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
    public boolean placePiece(int playerX, int playerY, Class<? extends Piece> pieceClass) {
        Piece piece = takePiece(pieceClass);
        if (piece == null) {
            System.out.println(pieceClass.getName() + " not found in player pieces list");
            return false;
        }
        int boardX = getFlipped(playerX, true);
        int boardY = getFlipped(playerY, false);
        board.setPiece(boardX, boardY, piece);
        return true;
    }

    /**
     * Takes a piece of a specific class from the player and returns it.
     *
     * @param pieceClass a subclass (such as Scout.class) of Piece
     * @return a Piece object, or null of no instance of the given class exists in the array.
     */
    private Piece takePiece(Class<? extends Piece> pieceClass) {
        // loop through the ArrayList
        for (int i = 0; i < pieces.size(); i++) {
            // check if the piece is of the type given.
            if (pieceClass.isInstance(pieces.get(i))) {
                // remove it from the player's stock.
                return pieces.remove(i);
            }
        }
        // return the piece.
        return null;
    }

    /**
     * If the player is the top player, the board positions should flip.
     *
     * @param coordinate the original coordinate
     * @param isX        if asking for the x coordinate, is true, for y is false.
     * @return the flipped coordinate (from board coordinate to player coordinate or from player coordinate to board coordinate)
     */
    private int getFlipped(int coordinate, boolean isX) {
        if (isFirst) {
            return coordinate;
        }
        return Board.getFlippedCoordinate(coordinate, isX);
    }

    // test method
    @Deprecated
    private void printPieces() {
        String playerName;
        if (isFirst) {
            playerName = "Player 1";
        } else {
            playerName = "Player 2";
        }
        System.out.println(playerName + " pieces:");
        for (Piece p :
                pieces) {
            System.out.println(p.getClass().getName());
        }
    }

    // Standard Openings with hard coded setups:
    private static Class<? extends Piece>[][] getDutchOpening() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
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

    private static Class<? extends Piece>[][] getDeBoerOffense() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed
        // (warning indicates that the class may not extend Piece, but all of them do).
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
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

    private static Class<? extends Piece>[][] getShorelineGambit() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        // (warning indicates that the class may not extend Piece, but all of them do).
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
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

    private static Class<? extends Piece>[][] getFlagFlankAssault() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        // (warning indicates that the class may not extend Piece, but all of them do).
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
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

    private static Class<? extends Piece>[][] getScottishDefense() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        // (warning indicates that the class may not extend Piece, but all of them do).
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
                {PFlag.class, PBomb.class, P4Sergeant.class, PBomb.class, P6Captain.class,
                        P3Miner.class, P3Miner.class, P3Miner.class, P5Lieutenant.class, P7Major.class},
                {PBomb.class, P4Sergeant.class, PBomb.class, P2Scout.class, P2Scout.class,
                        P5Lieutenant.class, P4Sergeant.class, P6Captain.class, P2Scout.class, P6Captain.class},
                {P4Sergeant.class, PBomb.class, P3Miner.class, P6Captain.class, P7Major.class,
                        P10Marshal.class, P2Scout.class, P2Scout.class, P7Major.class, P2Scout.class},
                {PBomb.class, P9General.class, P1Spy.class, P8Colonel.class, P2Scout.class,
                        P5Lieutenant.class, P3Miner.class, P8Colonel.class, P2Scout.class, P5Lieutenant.class}
        };
        return setup;
    }

    private static Class<? extends Piece>[][] getMineFieldDefense() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        // (warning indicates that the class may not extend Piece, but all of them do).
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
                {PFlag.class, PBomb.class, P2Scout.class, P2Scout.class, P2Scout.class,
                        P2Scout.class, P2Scout.class, P2Scout.class, P3Miner.class, P4Sergeant.class},
                {PBomb.class, P10Marshal.class, P5Lieutenant.class, P3Miner.class, P3Miner.class,
                        P7Major.class, P6Captain.class, P5Lieutenant.class, P5Lieutenant.class, P5Lieutenant.class},
                {P9General.class, P8Colonel.class, P1Spy.class, P3Miner.class, P6Captain.class,
                        P8Colonel.class, P6Captain.class, P6Captain.class, P7Major.class, P4Sergeant.class},
                {P2Scout.class, P2Scout.class, P3Miner.class, P7Major.class, PBomb.class,
                        PBomb.class, P4Sergeant.class, P4Sergeant.class, PBomb.class, PBomb.class}

        };
        return setup;
    }

    // Some test setups, so we can change the setups for tests in a way we want later.

    @Deprecated
    private static Class<? extends Piece>[][] getTestA() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
                {PFlag.class, PBomb.class, P4Sergeant.class, PBomb.class, P6Captain.class,
                        P3Miner.class, P3Miner.class, P3Miner.class, P5Lieutenant.class, P7Major.class},
                {PBomb.class, P4Sergeant.class, PBomb.class, P2Scout.class, P2Scout.class,
                        P5Lieutenant.class, P4Sergeant.class, P2Scout.class, P6Captain.class, P6Captain.class},
                {P4Sergeant.class, PBomb.class, P3Miner.class, P6Captain.class, P7Major.class,
                        P10Marshal.class, P2Scout.class, P2Scout.class, P7Major.class, P2Scout.class},
                {PBomb.class, P9General.class, P1Spy.class, P8Colonel.class, P2Scout.class,
                        P5Lieutenant.class, P3Miner.class, P8Colonel.class, P2Scout.class, P5Lieutenant.class}
        };
        return setup;
    }

    @Deprecated
    private static Class<? extends Piece>[][] getTestB() {
        // all classes are hardcoded subclasses of Piece, therefore this is always allowed.
        @SuppressWarnings("unchecked")
        Class<? extends Piece>[][] setup = new Class[][]{
                {PFlag.class, PBomb.class, P4Sergeant.class, PBomb.class, P3Miner.class,
                        P6Captain.class, P3Miner.class, P3Miner.class, P5Lieutenant.class, P7Major.class},
                {PBomb.class, P4Sergeant.class, PBomb.class, P2Scout.class, P2Scout.class,
                        P5Lieutenant.class, P4Sergeant.class, P6Captain.class, P2Scout.class, P6Captain.class},
                {P4Sergeant.class, PBomb.class, P3Miner.class, P6Captain.class, P7Major.class,
                        P10Marshal.class, P2Scout.class, P2Scout.class, P7Major.class, P2Scout.class},
                {PBomb.class, P9General.class, P1Spy.class, P8Colonel.class, P2Scout.class,
                        P5Lieutenant.class, P3Miner.class, P8Colonel.class, P2Scout.class, P5Lieutenant.class}
        };
        return setup;
    }
}
