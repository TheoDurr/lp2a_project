package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.util.EventListener;

public class GameGui extends JFrame implements EventListener {

    GameMode gameMode;

    public GameGui(GameMode gameMode) throws HeadlessException {
        super("LUDO GAME - " + gameMode.toString());
    }
}
