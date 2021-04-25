package fr.utbm.lp2a.cloarec_durr.ludo.game.utils;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;

import java.util.Comparator;

/**
 * class that used to compare the move of two movable pieces
 */
public class SortByBestMove implements Comparator<Piece> {
    /**
     * determine witch move of the two piece is the best one
     * @param piece1 : the first piece to move
     * @param piece2 : the second piece to move
     * @return : a positive int iff 1 is better 0 iff equal and a negative else
     */
    @Override
    public int compare(Piece piece1, Piece piece2) {

        if (piece1 == null){
            return -1;
        }
        else if (piece2 == null){
            return 1;
        }

        else if (piece2.isAtStable() && !piece1.isAtStable()){
            return -1;
        }
        else if (piece1.isAtStable() && !piece2.isAtStable()){
            return 1;
        }

        else if (!piece1.isAtImmuneSquare() && piece2.isAtImmuneSquare()){
            return 1;
        }
        else if (!piece2.isAtImmuneSquare() && piece1.isAtImmuneSquare()){
            return -1;
        }
        else {
            return piece1.getPosition().getProgress() - piece2.getPosition().getProgress();
        }
    }
}
