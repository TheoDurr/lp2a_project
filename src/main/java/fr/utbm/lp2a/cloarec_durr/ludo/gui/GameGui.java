package fr.utbm.lp2a.cloarec_durr.ludo.gui;


import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;

import javax.swing.*;
import java.awt.*;

public class GameGui extends JFrame{

    private GameBoardGui gameBoardGui;
    private JPanel mainPanel;
    private Piece[] pieces;
    private String[] pseudos;


    public GameGui(GameMode gameMode, String[] pseudo, Piece[] pieces) throws HeadlessException {

        super("LUDO GAME - " + gameMode.toString());
        this.pieces = pieces;
        this.pseudos = pseudo;
        build();
    }

    private void build() {
        /* import the icon*/
        ImageIcon icon = new ImageIcon("src/main/resources/ludo_game_board.png");
        this.setIconImage(icon.getImage());

        /* set the property of the windows */
        this.setSize(640, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /* add the main panel to the window */
        this.mainPanel = buildContentPane();
        this.setContentPane(this.mainPanel);

        /* set the visibility of the window*/
        this.setVisible(true);
    }

    private JPanel buildContentPane() {
        /* set the mainPanel*/
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        mainPanel.setBackground(Color.WHITE);

        /* Create and add the tile*/
        JLabel title = new JLabel("LUDO GAME", JLabel.CENTER);
        title.setBackground(Color.yellow);
        title.setOpaque(true);
        mainPanel.add(title);

        /* Create the game board panel */
        this.gameBoardGui = new GameBoardGui(this.pieces, this.pseudos);
        mainPanel.add(this.gameBoardGui);

        return mainPanel;
    }


    public void updatePositions() {
        this.gameBoardGui.updatePieces();

    }
}
