package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import javax.swing.*;
import java.util.List;

public abstract class Engine {
    protected Board gameBoard;
    protected GameGui gui;

    public Engine(GameMode gameMode, String[] pseudo) {
        // TODO REMOVE NULL AT NEXT COMMIT

        this.gameBoard = new Board(gameMode, pseudo);
        Piece[] pieces = new Piece[16];
        for (int i = 0; i < 16; i++) {
            pieces[i] = this.gameBoard.getPlayers()[i/4].getPieces()[i%4];
        }

        this.gui = new GameGui(gameMode, pseudo, pieces);
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
    protected void playTurn() {
        for (Player player : gameBoard.getPlayers()) {
            int value = 6;
            int i = 0;
            // Check if the player has a six and has played less than three times
            while (value == 6 && i < 3) {
                value = player.throwDice();
                Piece pieceToMove = player.choosePiece();
                if (pieceToMove != null){
                    movePiece(pieceToMove, value);
                }
                gui.updatePositions();
                i++;
            }
        }
        this.gui.updatePositions();
    }

    protected void movePiece(Piece pieceToMove, int progress) {
        // Check conflicts
        List<Piece> potentialConflicts = gameBoard.getPiecesAtCoordinates(new Position(pieceToMove.getPosition().getProgress() + progress, pieceToMove.getColor()));
        if (potentialConflicts != null) {
            boolean pieceWithSameColor = false;
            for (Piece piece : potentialConflicts) {
                if (piece.getColor().equals(pieceToMove.getColor())) {
                    pieceWithSameColor = true;
                }
            }
            // TODO : ADD CASE WHERE THERE IS MULTIPLE PIECES OF ANOTHER COLOR
            if (pieceWithSameColor) { // There is a piece with the same color, the piece can move without moving any other piece
                pieceToMove.moveForward(progress);
            }
        } else { // There are no piece at the destination square
            pieceToMove.moveForward(progress);
        }
        // Move piece
    }

    private void updateBoard() {
        gameBoard.update();
    }

    public int start() {

        return 0;
    }
}