package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameGui;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Engine {
    protected Board gameBoard;


    public Engine(GameMode gameMode, String[] pseudo) {
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

    /**
     * Play the turn of one player
     */
    protected void playTurn(Player playingPlayer) {
            int value = 6;
            int i = 0;
            // Check if the player has a six and has played less than three times
            while (value == 6 && i < 3) {
                value = playingPlayer.throwDice();
                Piece pieceToMove = playingPlayer.choosePiece();
                if (pieceToMove != null){
                    movePiece(pieceToMove, value);
                }
                updateBoard();
                i++;
            }
            updateBoard();
    }

    /**
     * Move a piece
     * @param pieceToMove The piece to move
     * @param progress The number of squares to move
     */
    protected void movePiece(Piece pieceToMove, int progress) {
        // Check if we can move the piece
        // @TODO understand why the pieces don't move when we want and implement processConflict !! Good night my self
        if (pieceToMove.isLegalMove(progress)){
            //process all the conflict, it mean that the other piece could go back to stable
            //processConflict(pieceToMove, progress);
            //then move really the piece
            pieceToMove.moveForward(progress);
        }


    }

    protected void processConflict(Piece pieceToMove, int progress){
        Position futurePosition = new Position(pieceToMove.getPosition().getProgress() + progress, pieceToMove.getColor());
        // Check conflicts
        List<Piece> potentialConflicts = gameBoard.getPiecesAtCoordinates(futurePosition);
        if (potentialConflicts != null) {
            boolean pieceWithSameColor = false;
            for (Piece piece : potentialConflicts) {
                // FIXME : OVERRIDE EQUALS FUNCTION
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

    protected abstract void updateBoard();

    /**
     * when this method is call the party start really
     * @return 0 iff all is ok
     */
    public int start() {
        List<Player> playerList = new ArrayList<>();
        playerList.addAll(Arrays.asList(this.gameBoard.getPlayers()));
        Player playingPlayer = getFirstPlayingPlayer(playerList);
        while (getWinner() == null){
            playTurn(playingPlayer);
            playingPlayer = playingPlayer.getNextPlayer();

        }

        Player winner = getWinner();
        printMessage("Congratulation " + winner.getName() + " win the game");
        return 0;
    }

    protected Player getFirstPlayingPlayer(List<Player> playerList){
        if (playerList.size() == 1){
            return playerList.get(0);
        }
        else {
            int max = 0;
            List<Player> bestPlayerList = new ArrayList<>();
            for (Player player :
                    playerList) {
                int diceValue = player.throwDice();
                if (diceValue > max) {
                    max = diceValue;
                    bestPlayerList.removeAll(bestPlayerList);
                    bestPlayerList.add(player);
                } else if (diceValue == max) {
                    bestPlayerList.add(player);
                }
            }
            return getFirstPlayingPlayer(bestPlayerList);
        }
    }

    protected abstract void printMessage(String message);
    public abstract void close();
}