package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

public class ArtificialIntelligence extends Player{

    public ArtificialIntelligence(String name, Color color) {
        super(name, color);
    }

    @Override
    public int trowDice() {
        return 0;
    }

    @Override
    public int choosePiece() {
        return 0;
    }
}
