package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.SortByBestMove;

import javax.swing.*;
import java.util.Collection;
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
        int choice = this.humanChoosePiece();
        if (choice <= 0 || choice < 4){
            return null;
        }
        else {
            return this.getPieces()[choice - 1];
        }
    }

    private int humanChoosePiece(){
        List<Piece> movablePiece = this.getMovablePieces();
        if (movablePiece.size() == 0){
            JOptionPane.showMessageDialog(null, this.getName() + " : You can't move any piece, you have to pass");
            return 0;
        }
        else {
            Collections.sort(movablePiece, new SortByBestMove());
            String[] stringMovablePiece = new String[movablePiece.size()+1];

            for (int i = 0; i < movablePiece.size(); i++){
                stringMovablePiece[i] = "" + movablePiece.get(i).getNumber();

            }
            stringMovablePiece[movablePiece.size()] = "pass";
            String result =  (String)JOptionPane.showInputDialog(null, this.getName() + " : Choose the piece that you want move " + this.getDice().getValue() + " cases forward" , this.getName() + " : Choose Piece", JOptionPane.QUESTION_MESSAGE, null, stringMovablePiece, stringMovablePiece[0]);

            if(result == null){
                System.exit(1);
            }

            int intResult = 0;
            try {
                intResult = Integer.parseInt(result);
            } catch (NumberFormatException e) {
                intResult = 0;
            }

            if (intResult > 0 || intResult <= 4){
                return intResult;
            }
            else{
                return 0;
            }
        }
    }
}
