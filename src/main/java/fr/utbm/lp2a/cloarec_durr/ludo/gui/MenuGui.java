package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class MenuGui extends JFrame implements ActionListener{

    private String pseudo;
    private GameMode mode;

    private JRadioButton oneHumanVersusThreeArtificialIntelligence;
    private JRadioButton fourHumans;
    private JRadioButton fourArtificialIntelligence;
    private JTextField fieldPseudo;
    private JButton playButton;



    public MenuGui(){
        super("LUDO GAME");

        this.pseudo = "Player 1";
        this.mode = GameMode.oneHumanVersusTreeArtificialIntelligence;

        /* import the icon*/
        ImageIcon icon = new ImageIcon("src/main/resources/ludo_game_board.png");
        this.setIconImage(icon.getImage());


        /* set the property of the windows */
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* set the mainPanel*/
        JPanel mainPanel = new JPanel(new GridLayout(5,1));

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

        this.fieldPseudo = new JTextField();
        fieldPseudo.addActionListener(this);

        panelPseudoSelection.add(fieldPseudo);

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

        if (source == this.fieldPseudo){
            assert this.fieldPseudo != null;
            this.pseudo = this.fieldPseudo.getText();
        }





    }

    public String getPseudo() {
        return pseudo;
    }

    public GameMode getMode() {
        return mode;
    }


}
