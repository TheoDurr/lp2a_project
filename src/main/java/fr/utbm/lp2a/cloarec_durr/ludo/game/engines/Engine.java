package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;

import java.awt.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public abstract class Engine {
    Board gameBoard;
    protected Map<String, Color> colorMap = new HashMap<>(){{
        put("1", Color.GREEN);
        put("2", Color.YELLOW);
        put("3", Color.BLUE);
        put("4", Color.RED);
    }};
    public abstract String getMessage();
    public abstract void trowDice();
    public abstract void play();



    protected Player[] players;

    public Engine(){
        this.players = new Player[4];
    }

    abstract void startGame();

    @Override
    public String toString() {
        return "Engine{" +
                "players=" + Arrays.toString(players) +
                '}';
    }
}
