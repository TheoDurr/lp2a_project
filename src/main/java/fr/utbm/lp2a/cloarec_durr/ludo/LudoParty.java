package fr.utbm.lp2a.cloarec_durr.ludo;

import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.Engine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.FourAIEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.FourHumansEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.OneHumanVersusThreeAIEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import javax.swing.*;

public class LudoParty {
    Engine gameEngine;

    public LudoParty(){
        String[] choosableGameMode = new String[]{GameMode.oneHumanVersusTreeArtificialIntelligence.toString(), GameMode.fourHumans.toString(), GameMode.fourArtificialIntelligence.toString()};
        String stringMode = (String) JOptionPane.showInputDialog(null, "Choose your game mode", GameMode.fourArtificialIntelligence.toString(), JOptionPane.QUESTION_MESSAGE, null, choosableGameMode, choosableGameMode[0]);
        GameMode gameMode;
        String[] pseudos = new String[]{"Player1", "Player2", "Player3", "Player4"};

        if (stringMode.equals(GameMode.oneHumanVersusTreeArtificialIntelligence.toString())){
            pseudos[3] = JOptionPane.showInputDialog(null, "Enter your pseudo");
            this.gameEngine = new OneHumanVersusThreeAIEngine(pseudos);

        }
        else if (stringMode.equals(GameMode.fourHumans.toString())){
            for (int i = 0; i < 4; i++){
                pseudos[i] = JOptionPane.showInputDialog(null, ("Enter the pseudo of" + pseudos[i]));
            }
            this.gameEngine = new FourHumansEngine(pseudos);
        }
        else {
            this.gameEngine = new FourAIEngine(pseudos);
        }
    }
}
