package fr.utbm.lp2a.cloarec_durr.ludo;

import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.*;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import javax.swing.*;

public class LudoParty {
    Engine gameEngine;

    public LudoParty(){
        String[] choosableGameMode = new String[]{GameMode.oneHumanVersusTreeArtificialIntelligence.toString(), GameMode.fourHumans.toString(), GameMode.fourArtificialIntelligence.toString(), GameMode.debug.toString()};
        String stringMode = (String) JOptionPane.showInputDialog(null, "Choose your game mode", GameMode.fourArtificialIntelligence.toString(), JOptionPane.QUESTION_MESSAGE, null, choosableGameMode, choosableGameMode[0]);
        String[] pseudos = new String[]{"Player1", "Player2", "Player3", "Player4"};

        if (stringMode != null){
            if (stringMode.equals(GameMode.oneHumanVersusTreeArtificialIntelligence.toString())){
                String pseudoChoose  = JOptionPane.showInputDialog(null, "Enter your pseudo");
                System.out.println("pseudo : <"+ pseudoChoose + ">");
                if (pseudoChoose != null && !pseudoChoose.equals("")){
                    pseudos[3] = pseudoChoose;
                }

                this.gameEngine = new OneHumanVersusThreeAIEngine(pseudos);

            }
            else if (stringMode.equals(GameMode.fourHumans.toString())){
                for (int i = 0; i < 4; i++){
                    String pseudoChoose = JOptionPane.showInputDialog(null, ("Enter the pseudo of" + pseudos[i]));
                    if (pseudoChoose != null && !pseudoChoose.equals("")){
                        pseudos[i] = pseudoChoose;
                    }

                }
                this.gameEngine = new FourHumansEngine(pseudos);
            }
            else if (stringMode.equals(GameMode.debug.toString())){
                this.gameEngine = new DebugEngine(pseudos);
            }
            else {
                this.gameEngine = new FourAIEngine(pseudos);
            }
        }
        else {
            this.gameEngine = new FourAIEngine(pseudos);
        }
    }

    public void start(){
        this.gameEngine.start();
    }
}
