package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.Engine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.FourArtificialIntelligenceEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.FourHumansEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.OneHumanVersusThreeArtificialIntelligenceEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameGui extends JFrame implements ActionListener {

    private Engine gameEngine;

    private JButton trowDice;

    private JRadioButton piece1;
    private JRadioButton piece2;
    private JRadioButton piece3;
    private JRadioButton piece4;
    private JRadioButton pass;
    private int pieceChoose;

    private JButton playButton;

    private JLabel messageBox;



    public GameGui(GameMode gameMode) throws HeadlessException {

        super("LUDO GAME - " + gameMode.toString());

        /* import the icon*/
        ImageIcon icon = new ImageIcon("src/main/resources/ludo_game_board.png");
        this.setIconImage(icon.getImage());

        /* set the property of the windows */
        this.setSize(550, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* set the mainPanel*/
        JPanel mainPanel = new JPanel();

        /* Create and add the tile*/
        JLabel title = new JLabel("LUDO GAME", JLabel.CENTER);
        title.setBackground(Color.yellow);
        title.setOpaque(true);
        mainPanel.add(title);

        /* Create the game board panel */
        JPanel gameBoardPanel = new JPanel(new GridLayout(1,1));

        /* Create and add the image of the game board */
        JLabel gameBoardImage = new JLabel(new ImageIcon("src/main/resources/ludo_game_board.png"));
        gameBoardPanel.add(gameBoardImage);

        mainPanel.add(gameBoardPanel);

        /* Create the trow dice button */
        this.trowDice = new JButton("Trow dice !");
        this.trowDice.addActionListener(this);
        mainPanel.add(trowDice);

        /* Create the panel for choosing the moving piece */
        JPanel panelMovePiece = new JPanel(new GridLayout(1, 5));
        Border border = BorderFactory.createTitledBorder("Choose the piece that you want move :");
        panelMovePiece.setBorder(border);

        /* Create  a group of radio button*/
        ButtonGroup movePiece = new ButtonGroup();
        
        this.piece1 = new JRadioButton("1");
        movePiece.add(piece1);
        panelMovePiece.add(piece1);
        piece1.addActionListener(this);

        this.piece2 = new JRadioButton("2");
        movePiece.add(piece2);
        panelMovePiece.add(piece2);
        piece2.addActionListener(this);

        this.piece3 = new JRadioButton("3");
        movePiece.add(piece3);
        panelMovePiece.add(piece3);
        piece3.addActionListener(this);

        this.piece4 = new JRadioButton("4");
        movePiece.add(piece4);
        panelMovePiece.add(piece4);
        piece4.addActionListener(this);

        this.pass = new JRadioButton("Pass");
        pass.setSelected(true);
        movePiece.add(pass);
        panelMovePiece.add(pass);
        pass.addActionListener(this);


        mainPanel.add(panelMovePiece);

        /* create the play button */
        this.playButton = new JButton("PLAY !");
        playButton.addActionListener(this);
        mainPanel.add(playButton);

        /* create the message box */
        this.messageBox = new JLabel("Let the game start");
        border = BorderFactory.createTitledBorder("Message");
        messageBox.setBorder(border);
        mainPanel.add(messageBox);





        switch (gameMode){
            case oneHumanVersusTreeArtificialIntelligence -> this.gameEngine = new OneHumanVersusThreeArtificialIntelligenceEngine();
            case fourArtificialIntelligence -> this.gameEngine = new FourArtificialIntelligenceEngine();
            case fourHumans -> this.gameEngine = new FourHumansEngine();
        }


        /* add the main panel to the window */
        this.getContentPane().add(mainPanel);
        setContentPane(mainPanel);

        /* set the visibility of the window*/
        this.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println("click on the button : " + e.getActionCommand());
        Object source = e.getSource();
        
        if (source == this.playButton){
            this.gameEngine.play();
            //System.out.println("piece choose" + this.pieceChoose);
            this.updateMessage();
            this.updatePiecePosition();

        }
        
        if (source == this.piece1){
            this.pieceChoose = 1;
        }

        if (source == this.piece2){
            this.pieceChoose = 2;
        }

        if (source == this.piece3){
            this.pieceChoose = 3;
        }

        if (source == this.piece4){
            this.pieceChoose = 4;
        }

        if (source == this.pass){
            this.pieceChoose = 0;
        }

        if (source == this.trowDice){
            this.gameEngine.trowDice();
        }
        
    }

    public void updateMessage(){
        this.messageBox.setText(this.gameEngine.getMessage());
    }

    public void updatePiecePosition(){


    }
}
