package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.players.ArtificialIntelligence;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Human;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;

import java.awt.*;

/**
 * COOP VS IA Engine Class
 * @author Florian CLOAREC, Théo DURR
 */
public class OneHumanVersusThreeAIEngine extends Engine{
    /**
     * Initialize a new Coop VS IA Engine
     * @param name  The name of the player
     */
    public OneHumanVersusThreeAIEngine(String name) {
        super();
        // Adding the player
        players[0] = new Human(name, colorMap.get("4"));

        // Adding the 3 IAs
        for(int i = 1; i < 3; i++){
            players[i] = new ArtificialIntelligence("Bot "+(i+1), colorMap.get(""+(i+1)));
        }
    }

    public void startGame(){
        // We need to now which player will play in first
        // The players launch the dices

    }
}
