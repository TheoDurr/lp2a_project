package fr.utbm.lp2a.cloarec_durr.ludo.game.items.board;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.ArtificialIntelligence;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Human;
import fr.utbm.lp2a.cloarec_durr.ludo.game.players.Player;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.GameMode;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Player[] players;

    public Board(GameMode mode, String[] pseudo) {
        this.players = new Player[4];
        switch (mode) {
            case fourArtificialIntelligence -> {
                for (int i = 0; i < 4; i++) {
                    this.players[i] = new ArtificialIntelligence(pseudo[i], Color.intToColor(i + 1));
                }
            }
            case fourHumans -> {
                for (int i = 0; i < 4; i++) {
                    this.players[i] = new Human(pseudo[i], Color.intToColor(i + 1));
                }
            }
            case oneHumanVersusTreeArtificialIntelligence -> {
                for (int i = 0; i < 3; i++) {
                    this.players[i] = new ArtificialIntelligence(pseudo[i], Color.intToColor(i + 1));
                }
                this.players[3] = new Human(pseudo[3], Color.intToColor(4));
            }
        }
    }

    public Player[] getPlayers() {
        return players;
    }

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

    public Player newPlayer(int playingPlayer) {
        return this.players[(playingPlayer + 1) % 4];
    }

    public void update() {

    }
}
