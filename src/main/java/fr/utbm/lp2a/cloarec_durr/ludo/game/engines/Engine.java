package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

public abstract class Engine {
    protected Board gameBoard;
    private GameGui gui;

    public Engine(GameMode gameMode, String[] pseudo) {
        // TODO REMOVE NULL AT NEXT COMMIT
        this.gui = new GameGui(gameMode, pseudo);
        this.gameBoard = new Board(gameMode, pseudo);
    }

    /**
     * Determines if there's a winner
     *
     * @return the winner (null otherwise)
     */
    private Player getWinner() {
        for (Player player : gameBoard.getPlayers()) {
            if (player.getNumberOfPieceAtHome() == 4) {
                return player;
            }
        }
        return null;
    }

    //@ TODO: 13/04/2021 add the case when the player pass
    /**
     * Play the next turn
     */
    private void playTurn() {
        for (Player player : gameBoard.getPlayers()) {
            int value = 6; int i = 0;
            // Check if the player has a six and has played less than three times
            while (value == 6 && i < 3) {
                value = player.throwDice();
                Piece pieceToMove = player.choosePiece();
                player.movePiece(pieceToMove);
                i++;
            }
        }
    }

    public int start() {
        return 0;
    }
}