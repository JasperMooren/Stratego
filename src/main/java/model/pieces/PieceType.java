package model.pieces;

import model.Player;

public enum PieceType {
    P1_SPY(P1Spy.VALUE, P1Spy.AMOUNT, P1Spy.class),
    P2_SCOUT(P2Scout.VALUE, P2Scout.AMOUNT, P2Scout.class),
    P3_MINER(P3Miner.VALUE, P3Miner.AMOUNT, P3Miner.class),
    P4_SERGEANT(P4Sergeant.VALUE, P4Sergeant.AMOUNT, P4Sergeant.class),
    P5_LIEUTENANT(P5Lieutenant.VALUE, P5Lieutenant.AMOUNT, P5Lieutenant.class),
    P6_CAPTAIN(P6Captain.VALUE, P6Captain.AMOUNT, P6Captain.class),
    P7_MAJOR(P7Major.VALUE, P7Major.AMOUNT, P7Major.class),
    P8_COLONEL(P8Colonel.VALUE, P8Colonel.AMOUNT, P8Colonel.class),
    P9_GENERAL(P9General.VALUE, P9General.AMOUNT, P9General.class),
    P10_MARSHAL(P10Marshal.VALUE, P10Marshal.AMOUNT, P10Marshal.class),
    P_FLAG(PFlag.VALUE, PFlag.AMOUNT, PFlag.class),
    P_BOMB(PBomb.VALUE, PBomb.AMOUNT, PBomb.class);

    private int value;
    private int amount;
    private Class<? extends Piece> subclass;

    PieceType(int value, int amount, Class<? extends Piece> subclass) {
        this.value = value;
        this.amount = amount;
        this.subclass = subclass;
    }

    public int getValue() {
        return value;
    }

    public int getAmount() {
        return amount;
    }

    /**
     * Creates a new Piece object with a subclass based in the PieceType
     *
     * @param player the player in the constructor of the subclass
     * @return a new Piece object of a certain subclass
     */
    public Piece newInstance(Player player) {
        try {
            return subclass.getConstructor(Player.class).newInstance(player);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
