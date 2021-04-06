package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MySwing extends JFrame {

    public MySwing(){
        super("LUDO GAME");

        ImageIcon icon = new ImageIcon("src/main/resources/ludo_game_board.png");
        this.setIconImage(icon.getImage());

        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        JLabel titre = new JLabel("LUDO GAME", JLabel.CENTER);
        titre.setBackground(Color.yellow);
        titre.setOpaque(true);
        panel.add(titre);

        JLabel consign = new JLabel("Welcome in our LUDO game, please choose a nick name and a game mode, then click on play !", JLabel.LEFT);
        panel.add(consign);

        ButtonGroup modeSelection = new ButtonGroup();
        JRadioButton oneHumanVersusThreeArtificialIntelligence = new JRadioButton("One Human Versus Three Artificial Intelligence");
        modeSelection.add(oneHumanVersusThreeArtificialIntelligence);
        panel.add(oneHumanVersusThreeArtificialIntelligence);
        JRadioButton fourHumans = new JRadioButton("Four Humans");
        modeSelection.add(fourHumans);
        panel.add(fourHumans);
        JRadioButton fourArtificialIntelligence = new JRadioButton("Four Artificial Intelligence");
        modeSelection.add(fourArtificialIntelligence);
        panel.add(fourArtificialIntelligence);



        JButton playButton = new JButton("PLAY !");
        playButton.addActionListener( new ActionListener() {
                                       public void actionPerformed(ActionEvent e) {
                                           System.out.println("The party start");
                                       }
                                   });
        panel.add(playButton);

        this.getContentPane().add(panel);
        setContentPane(panel);







        /*this.setLayout(new GridLayout(4, 2));
        setContentPane(panel);
        pack();*/





        this.setVisible(true);


    }
}
