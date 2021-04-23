package fr.utbm.lp2a.cloarec_durr.ludo.game.utils;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;

import java.util.Comparator;

public class SortByBestMove implements Comparator<Piece> {
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
