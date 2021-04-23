package fr.utbm.lp2a.cloarec_durr.ludo.gui;


import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;

import javax.swing.*;
import java.awt.*;

/**
 * Class for gui window that contain the game board
 * @author Florian CLOAREC
 */

public class GameGui extends JFrame{

    private GameBoardGui gameBoardGui;
    private JPanel mainPanel;
    private Piece[] pieces;
    private String[] pseudos;

    /**
     * Create the window by calling the super methode of JFrame
     * @param gameMode : the gameMode that has been chose by the user for this game
     * @param pseudo : a table whit the four pseudo of the players
     * @param pieces : a table whit the 16 pieces that are used to the game and need to be printed in the board
     */
    public GameGui(GameMode gameMode, String[] pseudo, Piece[] pieces) {

        super("LUDO GAME - " + gameMode.toString());
        this.pieces = pieces;
        this.pseudos = pseudo;
        build();
    }


    /**
     * set all the property of the of the window, create and add the main panel of the window
     */
    private void build() {
        /* import the icon*/
        ImageIcon icon = new ImageIcon("src/main/resources/ludo_game_board.png");
        this.setIconImage(icon.getImage());

        /** set the property of the windows */
        this.setSize(640, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /** add the main panel to the window */
        this.mainPanel = buildContentPane();
        this.setContentPane(this.mainPanel);

        /** set the visibility of the window*/
        this.setVisible(true);
    }

    /**
     * create the main panel and add to it this content : title and the game board
     * @return the panel that has been created
     */
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

    /**
     * update the printing position of the pieces, call this each time the pieces change
     */
    public void updatePositions() {
        this.gameBoardGui.updatePieces();

    }
}
