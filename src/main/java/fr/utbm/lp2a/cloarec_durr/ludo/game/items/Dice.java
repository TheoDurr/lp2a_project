package fr.utbm.lp2a.cloarec_durr.ludo.game.items;

import java.util.Random;

public class Dice extends Random {

    public Dice() {
        super();
    }

    public Dice(long seed) {
        super(seed);
    }

    public int Throw(){return this.nextInt() % 6;}
}
