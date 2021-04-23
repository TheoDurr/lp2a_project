package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

public class FourHumansEngine extends Engine {
    private GameGui gui;


    public FourHumansEngine(String[] pseudos) {
        super(GameMode.fourHumans, pseudos);
        Piece[] pieces = new Piece[16];
        for (int i = 0; i < 16; i++) {
            pieces[i] = this.gameBoard.getPlayers()[i/4].getPieces()[i%4];
        }
        this.gui = new GameGui(GameMode.fourHumans, pseudos, pieces);

    }


    protected void updateBoard() {
        gui.updatePositions();
    }
}
