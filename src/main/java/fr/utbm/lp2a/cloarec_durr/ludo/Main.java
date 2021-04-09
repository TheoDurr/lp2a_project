package fr.utbm.lp2a.cloarec_durr.ludo;

import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.MenuGui;

public class Main {
    public static void main(String[] args) {
        MenuGui menuGui = new MenuGui();
        GameMode gameMode = menuGui.getMode();
        String pseudo = menuGui.getPseudo();
        menuGui = null;

        GameGui gameGui = new GameGui(gameMode);

    }
}
