package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.Engine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.FourAIEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.FourHumansEngine;
import fr.utbm.lp2a.cloarec_durr.ludo.game.engines.OneHumanVersusThreeAIEngine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MenuGui extends JFrame implements ActionListener{

    private String[] pseudos;
    private GameMode mode;
    private Engine gameEngine;

    private final JRadioButton oneHumanVersusThreeArtificialIntelligence;
    private final JRadioButton fourHumans;
    private final JRadioButton fourArtificialIntelligence;

    private final JTextField fieldPseudo1;
    private final JTextField fieldPseudo2;
    private final JTextField fieldPseudo3;
    private final JTextField fieldPseudo4;

    private final JButton playButton;



    public MenuGui(){
        super("LUDO GAME");

        this.pseudos = new String[]{"Player1", "Player2", "Player3", "Player4"};
        this.mode = GameMode.oneHumanVersusTreeArtificialIntelligence;

        /* import the icon*/
        ImageIcon icon = new ImageIcon("src/main/resources/ludo_game_board.png");
        this.setIconImage(icon.getImage());


        /* set the property of the windows */
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* set the mainPanel*/
        JPanel mainPanel = new JPanel(new FlowLayout());

        /* Create and add the tile*/
        JLabel title = new JLabel("LUDO GAME", JLabel.CENTER);
        title.setBackground(Color.yellow);
        title.setOpaque(true);
        mainPanel.add(title);

        /* Creat and add the consign*/
        JLabel consign = new JLabel("Welcome in our LUDO game, please choose a nick name and a game mode, then click on play !", JLabel.LEFT);
        mainPanel.add(consign);



        /* Create the panel for game mode choose */
        JPanel panelModeSelection = new JPanel(new GridLayout(3,1));
        Border border = BorderFactory.createTitledBorder("Game Mode");
        panelModeSelection.setBorder(border);

        /* Create a group of radio button and add all the button in the group and in the panel */
        ButtonGroup modeSelection = new ButtonGroup();

        this.oneHumanVersusThreeArtificialIntelligence = new JRadioButton("One Human Versus Three Artificial Intelligence");
        oneHumanVersusThreeArtificialIntelligence.setSelected(true);
        modeSelection.add(oneHumanVersusThreeArtificialIntelligence);
        panelModeSelection.add(oneHumanVersusThreeArtificialIntelligence);
        oneHumanVersusThreeArtificialIntelligence.addActionListener(this);

        this.fourHumans = new JRadioButton("Four Humans");
        modeSelection.add(fourHumans);
        panelModeSelection.add(fourHumans);
        fourHumans.addActionListener(this);

        this.fourArtificialIntelligence = new JRadioButton("Four Artificial Intelligence");
        modeSelection.add(fourArtificialIntelligence);
        panelModeSelection.add(fourArtificialIntelligence);
        fourArtificialIntelligence.addActionListener(this);


        /* add the mode selection panel to the main panel*/
        mainPanel.add(panelModeSelection, BorderLayout.CENTER);

        /* Create and add the Pseudo Selection panel*/
        JPanel panelPseudoSelection = new JPanel(new GridLayout(1, 2));

        JLabel labelPseudo = new JLabel("Pseudo :");
        panelPseudoSelection.add(labelPseudo);

        this.fieldPseudo1 = new JTextField("Player1");
        fieldPseudo1.addActionListener(this);
        panelPseudoSelection.add(fieldPseudo1);

        this.fieldPseudo2 = new JTextField("Player2");
        fieldPseudo2.addActionListener(this);
        panelPseudoSelection.add(fieldPseudo2);

        this.fieldPseudo3 = new JTextField("Player3");
        fieldPseudo3.addActionListener(this);
        panelPseudoSelection.add(fieldPseudo3);

        this.fieldPseudo4 = new JTextField("Player4");
        fieldPseudo4.addActionListener(this);
        panelPseudoSelection.add(fieldPseudo4);
        
        

        mainPanel.add(panelPseudoSelection);



        /* create the play button */
        this.playButton = new JButton("PLAY !");
        playButton.addActionListener(this);
        mainPanel.add(playButton);

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
            this.pseudos[0] = this.fieldPseudo1.getText();
            this.pseudos[1] = this.fieldPseudo2.getText();
            this.pseudos[2] = this.fieldPseudo1.getText();
            this.pseudos[3] = this.fieldPseudo4.getText();

            switch (mode){
                case oneHumanVersusTreeArtificialIntelligence -> this.gameEngine = new OneHumanVersusThreeAIEngine(this.pseudos);
                case fourArtificialIntelligence -> this.gameEngine = new FourAIEngine(this.pseudos);
                case fourHumans -> this.gameEngine = new FourHumansEngine(this.pseudos);
            }
            this.dispose();
        }

        if (source == this.oneHumanVersusThreeArtificialIntelligence){
            this.mode = GameMode.oneHumanVersusTreeArtificialIntelligence;
        }

        if (source == this.fourHumans){
            this.mode = GameMode.fourHumans;
        }

        if (source == this.fourArtificialIntelligence){
            this.mode = GameMode.fourArtificialIntelligence;
        }





    }

    public String[] getPseudos() {
        return pseudos;
    }

    public GameMode getMode() {
        return mode;
    }


}
