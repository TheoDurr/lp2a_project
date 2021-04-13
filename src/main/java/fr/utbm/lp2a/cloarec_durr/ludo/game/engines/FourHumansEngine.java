package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

public class FourHumansEngine extends Engine {
    public FourHumansEngine(String[] pseudos) {
        super(GameMode.fourHumans, pseudos);
    }

    public String getMessage() {
        return null;
    }

    public void play() {

    }
}
