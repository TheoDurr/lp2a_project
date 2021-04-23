package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

public class FourAIEngine extends Engine{

    public FourAIEngine(String[] pseudos){
        super(GameMode.fourArtificialIntelligence, pseudos);
    }

    protected void updateBoard() {}
}
