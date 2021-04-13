package fr.utbm.lp2a.cloarec_durr.ludo;

import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.MenuGui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //MenuGui menuGui = new MenuGui();
        //GameMode gameMode = menuGui.getMode();
        //String[] pseudos = menuGui.getPseudos();

        LudoParty party = new LudoParty();

        /*GameMode gameMode = GameMode.oneHumanVersusTreeArtificialIntelligence;
        String[] pseudos = new String[]{"Player1", "Player2", "Player3", "Player4"};
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameGui gameGui = new GameGui(gameMode, pseudos);
            }
        });*/


    }
}
