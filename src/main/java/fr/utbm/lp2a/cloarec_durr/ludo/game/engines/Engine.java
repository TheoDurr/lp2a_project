package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public abstract class Engine {
    Board gameBoard;
    public abstract String getMessage();
    public abstract void throwDice();
    public abstract void play();




    abstract void startGame();


}
