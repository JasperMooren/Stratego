package model;

import model.pieces.*;

public enum BasicBoardSetup {
    DUTCH_OPENING(0),
    DE_BOER_OFFENSE(1),
    SHORELINE_GAMBIT(-1), // not yet converted over
    FLAG_FLANK_ASSAULT(-1), // not yet converted over
    SCOTTISH_DEFENSE(-1), // not yet converted over
    MINE_FIELD_DEFENSE(-1), // not yet converted over
    TEST_A(6),
    TEST_B(7);

    private PieceType[][] setup;

    BasicBoardSetup(int setupIndex) {
        switch (setupIndex) {
            case 0:
                setup = DUTCH_OPENING_SETUP;
            case 1:
                setup = DE_BOER_OFFENSE_SETUP;
            case 6:
                setup = TEST_A_SETUP;
            case 7:
                setup = TEST_B_SETUP;
            default:
                setup = TEST_A_SETUP;
        }
    }

    public PieceType[][] getSetup() {
        return setup;
    }

    private final PieceType[][] DUTCH_OPENING_SETUP = {
            {PieceType.P2_SCOUT, PieceType.P3_MINER, PieceType.P_BOMB, PieceType.P2_SCOUT, PieceType.P3_MINER,
                    PieceType.P_BOMB, PieceType.P_FLAG, PieceType.P_BOMB, PieceType.P3_MINER, PieceType.P3_MINER},
            {PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P7_MAJOR, PieceType.P8_COLONEL,
                    PieceType.P5_LIEUTENANT, PieceType.P_BOMB, PieceType.P5_LIEUTENANT, PieceType.P6_CAPTAIN, PieceType.P4_SERGEANT},
            {PieceType.P5_LIEUTENANT, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P1_SPY, PieceType.P9_GENERAL,
                    PieceType.P2_SCOUT, PieceType.P7_MAJOR, PieceType.P7_MAJOR, PieceType.P8_COLONEL, PieceType.P2_SCOUT},
            {PieceType.P6_CAPTAIN, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P5_LIEUTENANT, PieceType.P2_SCOUT,
                    PieceType.P6_CAPTAIN, PieceType.P3_MINER, PieceType.P10_MARSHAL, PieceType.P2_SCOUT, PieceType.P6_CAPTAIN}
    };

    private final PieceType[][] DE_BOER_OFFENSE_SETUP = {
            {PieceType.P7_MAJOR, PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P4_SERGEANT,
                    PieceType.P_BOMB, PieceType.P_FLAG, PieceType.P_BOMB, PieceType.P_BOMB, PieceType.P3_MINER},
            {PieceType.P7_MAJOR, PieceType.P2_SCOUT, PieceType.P7_MAJOR, PieceType.P1_SPY, PieceType.P6_CAPTAIN,
                    PieceType.P5_LIEUTENANT, PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P5_LIEUTENANT, PieceType.P2_SCOUT},
            {PieceType.P4_SERGEANT, PieceType.P2_SCOUT, PieceType.P8_COLONEL, PieceType.P8_COLONEL, PieceType.P9_GENERAL,
                    PieceType.P2_SCOUT, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P_BOMB, PieceType.P_BOMB},
            {PieceType.P10_MARSHAL, PieceType.P6_CAPTAIN, PieceType.P5_LIEUTENANT, PieceType.P3_MINER, PieceType.P2_SCOUT,
                    PieceType.P6_CAPTAIN, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P6_CAPTAIN}
    };

    // TODO: convert methods into PieceType[][]

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

    // Test setups
    @Deprecated
    private final PieceType[][] TEST_A_SETUP = {
            {PieceType.P_FLAG, PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P6_CAPTAIN,
                    PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P5_LIEUTENANT, PieceType.P7_MAJOR},
            {PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P2_SCOUT, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P4_SERGEANT, PieceType.P2_SCOUT, PieceType.P6_CAPTAIN, PieceType.P6_CAPTAIN},
            {PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P3_MINER, PieceType.P6_CAPTAIN, PieceType.P7_MAJOR,
                    PieceType.P10_MARSHAL, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P7_MAJOR, PieceType.P2_SCOUT},
            {PieceType.P_BOMB, PieceType.P9_GENERAL, PieceType.P1_SPY, PieceType.P8_COLONEL, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P3_MINER, PieceType.P8_COLONEL, PieceType.P2_SCOUT, PieceType.P5_LIEUTENANT}
    };

    @Deprecated
    private final PieceType[][] TEST_B_SETUP = {
            {PieceType.P_FLAG, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P6_CAPTAIN, PieceType.P8_COLONEL,
                    PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P5_LIEUTENANT, PieceType.P7_MAJOR},
            {PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P2_SCOUT, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P4_SERGEANT, PieceType.P2_SCOUT, PieceType.P6_CAPTAIN, PieceType.P6_CAPTAIN},
            {PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P3_MINER, PieceType.P6_CAPTAIN, PieceType.P7_MAJOR,
                    PieceType.P10_MARSHAL, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P7_MAJOR, PieceType.P2_SCOUT},
            {PieceType.P_BOMB, PieceType.P9_GENERAL, PieceType.P1_SPY, PieceType.P8_COLONEL, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P3_MINER, PieceType.P_BOMB, PieceType.P2_SCOUT, PieceType.P5_LIEUTENANT}
    };
}
