package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import javax.swing.*;

/**
 * Engine for a game with four human that play together
 * @author Florian CLOAREC
 * @author Théo DURR
 */
public class FourHumansEngine extends Engine {
    private GameGui gui;


    /**
     * basic constructor for the class, create the board and the gui
     * @param pseudos: tab of all the pseudos of the players
     */
    public FourHumansEngine(String[] pseudos) {
        super(GameMode.fourHumans, pseudos);
        Piece[] pieces = new Piece[16];
        for (int i = 0; i < 16; i++) {
            pieces[i] = this.gameBoard.getPlayers()[i/4].getPieces()[i%4];
        }
        this.gui = new GameGui(GameMode.fourHumans, pseudos, pieces);

    }

    /**
     * update the board by update the gui
     */
    protected void updateBoard() {
        gui.updatePositions();
    }

    /**
     * sed a popup window with our message to the user
     * @param message : message that we want to print to user
     */
    @Override
    protected void printMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * clean close the engine
     * for the gui, set the visibility of the window on false and dispose it
     */
    @Override
    public void close() {
        gui.setVisible(false);
        gui.dispose();
    }
}
