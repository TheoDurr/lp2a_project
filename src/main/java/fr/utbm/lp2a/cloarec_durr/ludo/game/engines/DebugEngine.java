package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import javax.swing.*;

public class DebugEngine extends Engine{

    private GameGui gui;

    public DebugEngine(String[] pseudo) {
        super(GameMode.debug, pseudo);
        Piece[] pieces = new Piece[16];
        for (int i = 0; i < 16; i++) {
            pieces[i] = this.gameBoard.getPlayers()[i/4].getPieces()[i%4];
        }
        this.gui = new GameGui(GameMode.oneHumanVersusTreeArtificialIntelligence, pseudo, pieces);
    }

    @Override
    public int start() {
        String[] option =  new String[]{"Continuer", "Quitter"};
        for (int i = 0; i < 57; i++) {
            String result =  (String) JOptionPane.showInputDialog(null, "turn" + i, "test", JOptionPane.QUESTION_MESSAGE, null, option, option[0]);
            if (result.equals(option[0])){
                for(Player player : gameBoard.getPlayers()){
                    this.movePiece(player.getPieces()[0], 1);

                }
                this.gui.updatePositions();
            }
            else {
                i = 57;
            }

        }

        return 0;
    }

    @Override
    protected void updateBoard() {
        this.gui.updatePositions();
    }

    @Override
    protected void printMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void close() {
        gui.setVisible(false);
        gui.dispose();
    }
}
