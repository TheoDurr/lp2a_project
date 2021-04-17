package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

public class ArtificialIntelligence extends Player{

    public ArtificialIntelligence(String name, Color color) {
        super(name, color);
    }

    @Override
    public int throwDice() {
        return 0;
    }

    @Override
    public Piece choosePiece() {
        int choice = this.iaChoosePiece();
        if (choice <= 0 || choice < 4){
            return null;
        }
        else {
            return this.getPieces()[choice - 1];
        }

    }

    public int iaChoosePiece(){
        return 0;
    }
}
