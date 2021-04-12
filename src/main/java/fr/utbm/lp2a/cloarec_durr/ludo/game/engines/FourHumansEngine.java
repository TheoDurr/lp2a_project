package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

public class FourHumansEngine extends Engine{
    public FourHumansEngine(String[] names) {
        this.gameBoard = new Board(GameMode.fourHumans, names);
    }
    public void startGame(){}

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public void throwDice() {

    }

    @Override
    public void play() {

    }
}
