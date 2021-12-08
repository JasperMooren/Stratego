package model.pieces;

import model.Player;

public abstract sealed class Piece
        permits Bomb, Captain, Colonel, Flag, General, Lieutenant, Major, Marshal, Miner, Scout, Sergeant, Spy {

    /**
     * A list of all subclasses of Piece
     */
    @SuppressWarnings("unchecked") // All subclasses of Piece by definition extend Piece.
    public static final Class<? extends Piece>[] PIECE_CLASS_LIST =
            (Class<? extends Piece>[]) Piece.class.getPermittedSubclasses();

    // Instance Variable
    protected Player player;

    // Constructor
    public Piece(Player player) {
        this.player = player;
    }

    /**
     * The amount of pieces that every player has.
     * This should be static, but Java cannot accept static abstract methods, nor abstract constants.
     * @return the amount of pieces that every player has of the specific piece.
     */
    public abstract int getAmount();

    /**
     * returns the amount of pieces of a specified subclass.
     * @param cls a subclass object of
     * @return the amount of a specific piece, or 0 if there is no AMOUNT.
     */
    public static int getAmount(Class<? extends Piece> cls) {
        int amount = 0;
        try {
            // instantiate object
            Piece p = cls.getDeclaredConstructor(Player.class).newInstance((Player) null);
            // gets the amount of this specific object aka class (because abstract static not part of Java)
            amount = (int) cls.getDeclaredMethod("getAmount").invoke(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amount;
    }

    public static int getTotalAmount() {
        int total = 0;
        for (Class<? extends Piece> cls : PIECE_CLASS_LIST) {
            total += getAmount(cls);
        }
        return total;
    }
}
