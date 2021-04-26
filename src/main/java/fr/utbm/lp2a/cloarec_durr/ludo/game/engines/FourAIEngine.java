package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;


/**
 * game engine for a game with four ia and no gui and printing
 *
 * @author Florian CLOAREC
 * @author Théo DURR
 */
public class FourAIEngine extends Engine{

    /**
     * basic constructor for the class, create the board
     * @param pseudos : tab of all the pseudos of the players
     */
    public FourAIEngine(String[] pseudos){
        super(GameMode.fourArtificialIntelligence, pseudos);
    }

    /**
     * do nothing because there is no gui
     */
    protected void updateBoard() {}

    /**
     * sed a our message to the user by the console
     * @param message : message that we want to print to user
     */
    @Override
    protected void printMessage(String message) {
        System.out.println(message);
    }


    /**
     * clean close the engine
     * do nothing because there is no gui
     */
    @Override
    public void close() {

    }
}
