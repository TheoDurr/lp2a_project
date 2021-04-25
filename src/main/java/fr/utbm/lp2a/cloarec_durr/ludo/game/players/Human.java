package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.SortByBestMove;

import javax.swing.*;

import java.util.Collections;
import java.util.List;


public class Human extends Player{

    public Human(String name, Color color, Dice dice) {
        super(name, color, dice);
    }

    @Override
    public int throwDice() {

        JOptionPane.showMessageDialog(null, this.getName() + " : Click on the button to trow the dice");
        int value = this.getDice().Throw();
        JOptionPane.showMessageDialog(null,  this.getName() + " : You get a " + value);
        return value;
    }

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
            return this.getPieces()[intResult-1];

        }

    }

    @Override
    public boolean isHumanPlayer() {
        return true;
    }
}
