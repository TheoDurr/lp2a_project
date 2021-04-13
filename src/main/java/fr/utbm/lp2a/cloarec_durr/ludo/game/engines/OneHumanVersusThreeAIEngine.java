package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;


import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

/**
 * COOP VS IA Engine Class
 *
 * @author Florian CLOAREC, Théo DURR
 */
public class OneHumanVersusThreeAIEngine extends Engine {
    /**
     * Initialize a new Coop VS IA Engine
     *
     * @param pseudos The name of the player
     */
    public OneHumanVersusThreeAIEngine(String[] pseudos) {
        super(GameMode.oneHumanVersusTreeArtificialIntelligence, pseudos);
    }

    public void startGame() {
        // We need to now which player will play in first
        // The players launch the dices

    }
}
