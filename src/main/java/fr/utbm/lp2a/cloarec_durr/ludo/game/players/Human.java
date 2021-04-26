package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.SortByBestMove;

import javax.swing.*;

import java.util.Collections;
import java.util.List;

/**
 * class that represent a player that is a Human, so the user of the program
 * @author Florian CLOAREC
 * @author Théo DURR
 */
public class Human extends Player{
    /**
     * basic constructor of the class, just call the super constructor
     * @param name : name of the player
     * @param color : color of the player
     * @param dice : value of the dice of the party
     */
    public Human(String name, Color color, Dice dice) {
        super(name, color, dice);
    }

    /**
     * throw the dice of the player by sending to him a popup for requesting the throw and on for the result of the dice
     * @return : a random int between 1 and 6
     */
    @Override
    public int throwDice() {

        JOptionPane.showMessageDialog(null, this.getName() + " : Click on the button to trow the dice");
        int value = this.getDice().Throw();
        JOptionPane.showMessageDialog(null, this.getName() + " : You get a " + value);
        return value;
    }

    /**
     * Let the user choose the piece that he can move, send to him a popup where he can choose the piece that he prefer
     * only print the movable piece and in the order of croissant best play
     * @return : the piece that the user choose
     */
    @Override
    public Piece choosePiece() {
        List<Piece> movablePiece = this.getMovablePieces();
        if (movablePiece.size() == 0){
            JOptionPane.showMessageDialog(null, this.getName() + " : You can't move any piece, you have to pass");
            return null;
        }
        else {
            movablePiece.sort(new SortByBestMove());
            Collections.reverse(movablePiece);
            String[] stringMovablePiece = new String[movablePiece.size()+1];

            for (int i = 0; i < movablePiece.size(); i++){
                stringMovablePiece[i] = "" + movablePiece.get(i).getNumber();

            }
            stringMovablePiece[movablePiece.size()] = "pass";
            String result =  (String)JOptionPane.showInputDialog(null, this.getName() + " : Choose the piece that you want move " + this.getDice().getValue() + " cases forward" , this.getName() + " : Choose Piece", JOptionPane.QUESTION_MESSAGE, null, stringMovablePiece, stringMovablePiece[0]);

            if(result == null){
                System.exit(1);
            }

            int intResult;
            try {
                intResult = Integer.parseInt(result);
            } catch (NumberFormatException e) {
                return null;
            }
            return this.getPieces()[intResult - 1];

        }

    }
    /**
     * check if the player is human in this case yes
     * @return true if it is a human
     */
    @Override
    public boolean isHumanPlayer() {
        return true;
    }
}
