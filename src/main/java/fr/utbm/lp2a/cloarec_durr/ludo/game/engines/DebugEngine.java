package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import javax.swing.*;

public class DebugEngine extends Engine{
    public DebugEngine(String[] pseudo) {
        super(GameMode.debug, pseudo);
    }

    @Override
    public int start() {
        String[] option =  new String[]{"Continuer", "Quitter"};
        for (int i = 0; i < 57; i++) {
            String result =  (String) JOptionPane.showInputDialog(null, "turn" + i, "test", JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
            if (result.equals(option[0])){
                this.playTurn();
            }
            else {
                i = 57;
            }

        }

        return 0;
    }

    @Override
    protected void playTurn(){
        for(Player player : gameBoard.getPlayers()){
            this.movePiece(player.getPieces()[0], 1);

        }
        this.gui.updatePositions();
    }


}
