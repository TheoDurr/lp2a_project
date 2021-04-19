package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

import javax.swing.*;
import java.util.List;


public class Human extends Player{

    public Human(String name, Color color) {
        super(name, color);
    }

    @Override
    public int throwDice() {
        JOptionPane.showMessageDialog(null, "Click on the button to trow the dice");
        int value = this.getDice().Throw();
        JOptionPane.showMessageDialog(null, "You get a " + value);
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
        String[] stringMovablePiece = new String[movablePiece.size()+1];
        stringMovablePiece[0] = "pass";
        for (int i = 0; i < movablePiece.size(); i++){
            stringMovablePiece[i+1] = "" + movablePiece.get(i).getNumber();

        }
        String result =  (String)JOptionPane.showInputDialog(null, "Choose the piece that you want move", "Piece", JOptionPane.QUESTION_MESSAGE, null, stringMovablePiece, stringMovablePiece[0]);
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
