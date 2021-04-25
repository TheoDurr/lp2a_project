package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.SortByBestMove;

import java.util.Collections;
import java.util.List;

/**
 * class that represent a player that is an IA
 * @author Florian CLOAREC
 * @author Théo DURR
 */
public class ArtificialIntelligence extends Player{

    /**
     * basic constructor of the class
     * @param name : name of the player
     * @param color : color of the player
     * @param dice : value of the dice of the party
     */
    public ArtificialIntelligence(String name, Color color, Dice dice) {
        super(name, color, dice);
    }

    /**
     * throw the dice and get the value of it
     * @return : a random int between 1 and 6
     */
    @Override
    public int throwDice() {
        return this.getDice().Throw();
    }

    /**
     * choose the piece that the player will move
     * @return : the piece chosen by the ia
     */
    @Override
    public Piece choosePiece() {
        List<Piece> movablePiece = getMovablePieces();
        if (movablePiece.size() == 0){
            return null;
        }else {
            movablePiece.sort(new SortByBestMove());
            Collections.reverse(movablePiece);
            return movablePiece.get(0);
        }




    }

    /**
     * check if the player is human in this case no
     * @return true if it is a human
     */
    @Override
    public boolean isHumanPlayer() {
        return false;
    }
}
