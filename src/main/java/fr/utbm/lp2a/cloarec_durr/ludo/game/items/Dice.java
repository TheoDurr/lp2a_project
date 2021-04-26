package fr.utbm.lp2a.cloarec_durr.ludo.game.items;

import java.util.Random;


/**
 * class that contain the dice of the game
 * @author Florian CLOAREC
 * @author Théo DURR
 */
public class Dice extends Random {

    private int value;

    /**
     * basic constructor of the class
     */
    public Dice() {
        super();
    }

    /**
     * constructor of the class with a seed
     * @param seed: the seed that we want to give to our dice
     */
    public Dice(long seed) {
        super(seed);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Throw the dice, set value to a random number between 1 and 6
     * @return a random number between 1 and 6
     */
    public int Throw() {
        this.setValue(this.nextInt(6) + 1);
        return this.getValue();
    }

    @Override
    public String toString() {
        return "" + getValue();
    }
}
