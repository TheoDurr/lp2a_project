package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

public class FourAIEngine extends Engine{

    public FourAIEngine(String[] pseudos){
        this.gameBoard = new Board(GameMode.fourArtificialIntelligence, pseudos);
    }

    public void startGame(){

    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void trowDice() {

    }

    @Override
    public void play() {

    }
}
