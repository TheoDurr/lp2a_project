package fr.utbm.lp2a.cloarec_durr.ludo.game.items;

import java.util.Random;

public class Dice extends Random {

    private int value;

    public Dice() {
        super();
    }

    public Dice(long seed) {
        super(seed);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int Throw() {
        this.setValue(this.nextInt(5) + 1);
        return this.getValue();
    }

    @Override
    public String toString() {
        return "" + getValue();
    }
}
