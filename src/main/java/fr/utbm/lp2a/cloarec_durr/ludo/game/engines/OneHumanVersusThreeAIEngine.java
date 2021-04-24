package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;


import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import javax.swing.*;

/**
 * COOP VS IA Engine Class
 *
 * @author Florian CLOAREC
 * @author Théo DURR
 */
public class OneHumanVersusThreeAIEngine extends Engine {

    protected GameGui gui;

    /**
     * Initialize a new Coop VS IA Engine
     *
     * @param pseudos The name of the player
     */
    public OneHumanVersusThreeAIEngine(String[] pseudos) {
        super(GameMode.oneHumanVersusTreeArtificialIntelligence, pseudos);
        Piece[] pieces = new Piece[16];
        for (int i = 0; i < 16; i++) {
            pieces[i] = this.gameBoard.getPlayers()[i/4].getPieces()[i%4];
        }
        this.gui = new GameGui(GameMode.oneHumanVersusTreeArtificialIntelligence, pseudos, pieces);
    }

    /**
     * update the gui
     */
    @Override
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
