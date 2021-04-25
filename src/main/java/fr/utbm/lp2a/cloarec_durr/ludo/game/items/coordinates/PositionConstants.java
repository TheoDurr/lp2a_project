package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;

/**
 * Store all the constant very useful to calculate coordinate on the grind
 * for each special case we associate the number of progress in the class Position
 * @author Florian CLOAREC
 */
public final class PositionConstants {
    public static final int STABLE = -1;
    public static final int START = 0;
    public static final int DELTA = 5*2+3;
    public static final int ONE_TURN = DELTA*4;
    public static final int HOME = DELTA * 4 + 4;//56
    public static final int ARROW = ONE_TURN -2;//50
    public static final int STAR = 5+4;//9

}
