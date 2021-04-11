package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;

public abstract class Engine {
    Board gameBoard;

    public abstract String getMessage();
    public abstract void trowDice();
    public abstract void play();






}
