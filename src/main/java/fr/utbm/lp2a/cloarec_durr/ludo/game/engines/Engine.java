package fr.utbm.lp2a.cloarec_durr.ludo.game.engines;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.board.Board;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * class that is the game engine who perform all the action to make the party working and who contain the board
 *
 * @author Florian CLOAREC
 * @author Théo DURR
 */

public abstract class Engine {
    protected Board gameBoard;
    private int diceValue = 6;

    /**
     * simple constructor that just coll the constructor of the board
     */
    public Engine(GameMode gameMode, String[] pseudo) {
        this.gameBoard = new Board(gameMode, pseudo);
    }

    /**
     * Determines if there's a winner
     *
     * @return the winner player (null otherwise)
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
     *
     * @param playingPlayer: the player that is the turn to play
     */
    protected void playTurn(Player playingPlayer) {
        if (playingPlayer.isHumanPlayer()){
            updateBoard();
        }
        this.diceValue = 6;
        int i = 0;
        // Check if the player has a six and has played less than three times
        while (this.diceValue == 6 && i < 3) {
            this.diceValue = playingPlayer.throwDice();
            Piece pieceToMove = playingPlayer.choosePiece();
            if (pieceToMove != null){
                movePiece(pieceToMove, this.diceValue);
                if (playingPlayer.isHumanPlayer()){
                    updateBoard();
                }
            }
            i++;
        }
    }

    /**
     * Move a piece
     * @param pieceToMove The piece to move
     * @param progress The number of squares to move
     */
    protected void movePiece(Piece pieceToMove, int progress) {
        // Check if we can move the piece
        if (pieceToMove.isLegalMove(progress)){
            //process all the conflict, it mean that the other piece could go back to stable
            processConflict(pieceToMove, progress);
            //then move really the piece
            pieceToMove.moveForward(progress);
        }
    }

    /**
     * Check if there some other piece in the case where the piece that we want to move go, if it is the case decide if it go back to the stable or if it do nothing
     * @param pieceToMove The piece to move
     * @param progress The number of squares to move
     */
    protected void processConflict(Piece pieceToMove, int progress){
        Position futurePosition = new Position(pieceToMove.getPosition().getProgress() + progress, pieceToMove.getColor());
        // create a list whit all the piece at the future position
        List<Piece> potentialConflicts = gameBoard.getPiecesAtCoordinates(futurePosition);
        if (potentialConflicts != null && potentialConflicts.size() == 1){
            Piece conflictPiece = potentialConflicts.get(0);
            if (pieceToMove.getColor() != conflictPiece.getColor() && !conflictPiece.isAtImmuneSquare()){
                conflictPiece.moveAtStable();
                printMessage("The " + conflictPiece.getColor().toString() + " go back to the stable because the " + pieceToMove.getColor().toString() + " eat it !");
                this.diceValue = 6;

            }
        }



    }

    /**
     * update the board on the gui if there exist
     */
    protected abstract void updateBoard();

    /**
     * when this method is call the party start really
     */
    public void start() {
        List<Player> playerList = new ArrayList<>(Arrays.asList(this.gameBoard.getPlayers()));
        Player playingPlayer = getFirstPlayingPlayer(playerList);
        while (getWinner() == null){
            playTurn(playingPlayer);
            playingPlayer = playingPlayer.getNextPlayer();

        }

        Player winner = getWinner();
        printMessage("Congratulation " + winner.getName() + " win the game");
    }

    /**
     * look for the first player who will start the party recursively
     * @param playerList : list of the player that try to play first (not all the player if there is a tie and a second recursive call)
     * @return the player that "win" the dice turn
     */
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

    /**
     * print a message to the user on a different way depending of the child engine
     * @param message : message that we want to print to user
     */
    protected abstract void printMessage(String message);

    /**
     * clean close of the party and close the gui if exist
     */
    public abstract void close();
}