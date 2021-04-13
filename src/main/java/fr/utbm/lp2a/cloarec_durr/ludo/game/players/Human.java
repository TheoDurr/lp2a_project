package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;



public class Human extends Player{

    public Human(String name, Color color) {
        super(name, color);
    }

    @Override
    public int throwDice() {
        return 0;
    }

    @Override
    public Piece choosePiece() {
        return new Piece(getColor());
    }
}
