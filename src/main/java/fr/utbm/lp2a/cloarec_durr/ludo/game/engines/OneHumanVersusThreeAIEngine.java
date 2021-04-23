package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;


import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

/**
 * COOP VS IA Engine Class
 *
 * @author Florian CLOAREC, Théo DURR
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


    protected void updateBoard() {
        gui.updatePositions();
    }
}
