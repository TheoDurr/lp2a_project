package fr.utbm.lp2a.cloarec_durr.ludo;

import javax.swing.*;

/**
 * Main class where the program begin
 */
public class Main {

    /**
     * main function where the program begin, create a LudoParty and start it
     * @param args : no argument needed
     */
    public static void main(String[] args) {
        boolean continuePlay = true;
        while (continuePlay) {

            LudoParty party = new LudoParty();
            party.start();

            String[] option = new String[]{"Yes", "No"};
            String result =  (String) JOptionPane.showInputDialog(null, "Do you want to play again?" , "Play again?", JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
            continuePlay = result.equals(option[0]);
        }
    }
}
