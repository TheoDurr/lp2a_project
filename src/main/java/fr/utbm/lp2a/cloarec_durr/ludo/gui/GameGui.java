package fr.utbm.lp2a.cloarec_durr.ludo.gui;


import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameGui extends JFrame{

    private JLabel messageBox;

    private JLabel[] piecesImage;
    private JRadioButton piece1;


    public GameGui(GameMode gameMode, String[] pseudo) throws HeadlessException {

        super("LUDO GAME - " + gameMode.toString());

        build();
    }

    private void build() {
        /* import the icon*/
        ImageIcon icon = new ImageIcon("src/main/resources/ludo_game_board.png");
        this.setIconImage(icon.getImage());

        /* set the property of the windows */
        this.setSize(550, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /* add the main panel to the window */
        this.setContentPane(buildContentPane());

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
        mainPanel.add(buildGameBoard());

        /* create the message box */
        this.messageBox = new JLabel("Let the game start");
        Border border = BorderFactory.createTitledBorder("Message");
        messageBox.setBorder(border);
        mainPanel.add(messageBox);

        return mainPanel;
    }

    private JPanel buildGameBoard() {
        JPanel gameBoardPanel = new JPanel(new GridLayout(1, 1));

        /* Create and add the image of the game board */
        JLabel gameBoardImage = new JLabel(new ImageIcon("src/main/resources/ludo_game_board.png"));
        gameBoardPanel.add(gameBoardImage);

        /* Create the piece and add them to the board */
        /*this.piecesImage = new JLabel[16];
        ImageIcon[] images = new ImageIcon[16];
        for (int i = 0; i < 2; i++){
            images[i] = new ImageIcon(("src/main/resources/piece/piece" + fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color.intToColor((i/4)+1)) + (i%4) + ".png");
            this.piecesImage[i] = new JLabel(images[i]);
            gameBoardPanel.add(this.piecesImage[i]);

        }*/

        return gameBoardPanel;
    }


    public void updateMessage() {
        //this.messageBox.setText(this.gameEngine.getMessage());
    }

    public void printPiecePosition(Piece[] pieces) {

    }

    public void updatePiecePosition(Piece[] pieces){

    }

    public void updatePositions() {
    }
}
