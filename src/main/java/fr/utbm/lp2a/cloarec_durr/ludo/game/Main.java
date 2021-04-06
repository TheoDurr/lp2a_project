package fr.utbm.lp2a.cloarec_durr.ludo.game;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello World");



        JLabel label = new JLabel("LUDO GAME", JLabel.CENTER);
        frame.add(label);

        JPanel panel = new JPanel();

        JButton de1 = new JButton("Lancer le dé 1");
        JButton de2 = new JButton("Lancer le dé 2");
        panel.add(de1);
        panel.add(de2);

        frame.setLayout(new GridLayout(2, 1));
        frame.add(label);
        frame.add(panel);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250, 250);
        frame.setVisible(true);

    }
}
