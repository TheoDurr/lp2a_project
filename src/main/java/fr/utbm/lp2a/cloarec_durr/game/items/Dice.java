package fr.utbm.lp2a.cloarec_durr.game.items;

import java.util.Random;

public class Dice extends Random {

    public Dice() {
        super();
    }

    public Dice(long seed) {
        super(seed);
    }

    int Throw(){
        return this.nextInt() % 6;
    }
}
