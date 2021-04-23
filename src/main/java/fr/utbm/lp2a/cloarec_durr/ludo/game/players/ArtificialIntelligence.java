package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.SortByBestMove;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;

public class ArtificialIntelligence extends Player{

    public ArtificialIntelligence(String name, Color color, Dice dice) {
        super(name, color, dice);
    }

    @Override
    public int throwDice() {
        return this.getDice().Throw();
    }

    @Override
    public Piece choosePiece() {
        List<Piece> movablePiece = getMovablePieces();
        if (movablePiece.size() == 0){
            return null;
        }else {
            sort(movablePiece, new SortByBestMove());
            return movablePiece.get(0);
        }




    }




}
