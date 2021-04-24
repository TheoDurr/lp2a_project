package fr.utbm.lp2a.cloarec_durr.ludo.game.items.board;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.ArtificialIntelligence;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Human;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import java.util.ArrayList;
import java.util.List;

/**
 * class that represent the board of the game
 *
 * @author Florian CLOAREC
 * @author Théo DURR
 */
public class Board {

    private final Player[] players;

    /**
     * constructor of the class, create the player on the right class (Human or ArtificialIntelligence) depending on the gameMode
     * @param mode : mode of the party useful to know what are the players
     * @param pseudo : all the pseudos of the players
     */
    public Board(GameMode mode, String[] pseudo) {
        Dice dice = new Dice();
        this.players = new Player[4];
        switch (mode) {
            case fourArtificialIntelligence, debug -> {
                for (int i = 0; i < 4; i++) {
                    this.players[i] = new ArtificialIntelligence(pseudo[i],Color.intToColor(i + 1), dice);
                }
            }
            case fourHumans -> {
                for (int i = 0; i < 4; i++) {
                    this.players[i] = new Human(pseudo[i], Color.intToColor(i + 1), dice);
                }
            }
            case oneHumanVersusTreeArtificialIntelligence -> {
                for (int i = 0; i < 3; i++) {
                    this.players[i] = new ArtificialIntelligence(pseudo[i], Color.intToColor(i + 1), dice);
                }
                this.players[3] = new Human(pseudo[3], Color.intToColor(4), dice);
            }
        }
        for (int i = 0; i < 4; i++) {
            if (i == 3){
                this.players[i].setNextPlayer(this.players[0]);
            }
            else{
                this.players[i].setNextPlayer(this.players[i+1]);
            }

        }
    }

    /**
     * get the players of the game
     * @return the table with the players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * get the list of all the pieces that are on a specified position/case of the game board
     * @param position : the position of the case that we want to check
     * @return a list of piece with all the piece of the case
     */
    public List<Piece> getPiecesAtCoordinates(Position position){
        List<Piece> result = new ArrayList<>();
        for (Player player : getPlayers()) {
            for (Piece piece : player.getPieces()) {
                if (piece.getPosition().equals(position)) {
                    result.add(piece);
                }
            }
        }
        if (result.isEmpty()) {
            return null;
        } else {
            return result;
        }
    }
}
