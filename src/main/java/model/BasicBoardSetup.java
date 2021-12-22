package model;

import model.pieces.*;

public enum BasicBoardSetup {
    DUTCH_OPENING(0),
    DE_BOER_OFFENSE(1),
    SHORELINE_GAMBIT(2), // not yet converted over
    FLAG_FLANK_ASSAULT(3), // not yet converted over
    SCOTTISH_DEFENSE(4), // not yet converted over
    MINE_FIELD_DEFENSE(5), // not yet converted over
    TEST_A(6),
    TEST_B(7);

    private PieceType[][] setup;

    BasicBoardSetup(int setupIndex) {
        switch (setupIndex) {
            case 0:
                setup = DUTCH_OPENING_SETUP;
            case 1:
                setup = DE_BOER_OFFENSE_SETUP;
            case 2:
                setup = SHORELINE_GAMBIT_SETUP;
            case 3:
                setup = FLAG_FLANK_ASSAULT_SETUP;
            case 4:
                setup = SCOTTISH_DEFENSE_SETUP;
            case 5:
                setup = MINE_FIELD_DEFENSE_SETUP;
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

    private final PieceType[][] SHORELINE_GAMBIT_SETUP = {
            {PieceType.P2_SCOUT, PieceType.P4_SERGEANT, PieceType.P3_MINER, PieceType.P5_LIEUTENANT, PieceType.P2_SCOUT,
                PieceType.P1_SPY, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P5_LIEUTENANT, PieceType.P3_MINER},
            {PieceType.P5_LIEUTENANT, PieceType.P4_SERGEANT, PieceType.P6_CAPTAIN, PieceType.P6_CAPTAIN, PieceType.P3_MINER,
                    PieceType.P3_MINER, PieceType.P6_CAPTAIN, PieceType.P2_SCOUT, PieceType.P6_CAPTAIN, PieceType.P5_LIEUTENANT},
            {PieceType.P7_MAJOR, PieceType.P9_GENERAL, PieceType.P8_COLONEL, PieceType.P_BOMB, PieceType.P10_MARSHAL,
                    PieceType.P7_MAJOR, PieceType.P_BOMB, PieceType.P3_MINER, PieceType.P8_COLONEL, PieceType.P7_MAJOR},
            {PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P_BOMB, PieceType.P_FLAG, PieceType.P_BOMB,
                    PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P2_SCOUT}
    };

    private final PieceType[][] FLAG_FLANK_ASSAULT_SETUP = {
            {PieceType.P_FLAG, PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P6_CAPTAIN,
                    PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P5_LIEUTENANT, PieceType.P7_MAJOR},
            {PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P2_SCOUT, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P4_SERGEANT, PieceType.P6_CAPTAIN, PieceType.P2_SCOUT, PieceType.P6_CAPTAIN},
            {PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P3_MINER, PieceType.P6_CAPTAIN, PieceType.P7_MAJOR,
                    PieceType.P10_MARSHAL, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P7_MAJOR, PieceType.P2_SCOUT},
            {PieceType.P_BOMB, PieceType.P9_GENERAL, PieceType.P1_SPY, PieceType.P8_COLONEL, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P3_MINER, PieceType.P8_COLONEL,PieceType.P2_SCOUT, PieceType.P5_LIEUTENANT}

    };

    private final  PieceType[][] SCOTTISH_DEFENSE_SETUP = {
            {PieceType.P_FLAG, PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P6_CAPTAIN,
                    PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P3_MINER, PieceType.P5_LIEUTENANT, PieceType.P7_MAJOR},
            {PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P2_SCOUT, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P4_SERGEANT, PieceType.P6_CAPTAIN, PieceType.P2_SCOUT, PieceType.P6_CAPTAIN},
            {PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P3_MINER, PieceType.P6_CAPTAIN, PieceType.P7_MAJOR,
                    PieceType.P10_MARSHAL, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P7_MAJOR, PieceType.P2_SCOUT},
            {PieceType.P_BOMB, PieceType.P9_GENERAL, PieceType.P1_SPY, PieceType.P8_COLONEL, PieceType.P2_SCOUT,
                    PieceType.P5_LIEUTENANT, PieceType.P3_MINER, PieceType.P8_COLONEL, PieceType.P2_SCOUT, PieceType.P5_LIEUTENANT}

    };

    private final PieceType [][] MINE_FIELD_DEFENSE_SETUP = {
            {PieceType.P_FLAG, PieceType.P_BOMB, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P2_SCOUT,
                    PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P3_MINER, PieceType.P4_SERGEANT},
            {PieceType.P_BOMB, PieceType.P10_MARSHAL, PieceType.P5_LIEUTENANT, PieceType.P3_MINER, PieceType.P3_MINER,
                    PieceType.P7_MAJOR, PieceType.P6_CAPTAIN, PieceType.P5_LIEUTENANT, PieceType.P5_LIEUTENANT, PieceType.P5_LIEUTENANT},
            {PieceType.P9_GENERAL, PieceType.P8_COLONEL, PieceType.P1_SPY,  PieceType.P3_MINER, PieceType.P6_CAPTAIN,
                    PieceType.P8_COLONEL, PieceType.P6_CAPTAIN, PieceType.P6_CAPTAIN, PieceType.P7_MAJOR, PieceType.P4_SERGEANT},
            {PieceType.P2_SCOUT, PieceType.P2_SCOUT, PieceType.P3_MINER, PieceType.P7_MAJOR, PieceType.P_BOMB,
                    PieceType.P_BOMB, PieceType.P4_SERGEANT, PieceType.P4_SERGEANT, PieceType.P_BOMB, PieceType.P_BOMB}

    };

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
