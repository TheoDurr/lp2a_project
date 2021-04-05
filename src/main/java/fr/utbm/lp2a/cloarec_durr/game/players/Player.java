package fr.utbm.lp2a.cloarec_durr.game.players;

import fr.utbm.lp2a.cloarec_durr.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.game.items.coordinates.PositionConstants;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final String name;
    private final Color color;
    private Piece[] pieces;
    private final Dice dice;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.pieces = new Piece[4];
        for (int i = 0; i < this.pieces.length; i ++){
            pieces[i] = new Piece(color);
        }
        this.dice = new Dice();
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public int getNumberOfPieceAtHome(){
        int i = 0;
        for (Piece piece :
                this.pieces) {
            if (piece.isAtHome()){
                i ++;
            }
        }
        return i;
    }

    public List<Piece> getMovablePieces(int diceValue){
        List<Piece> movablePieces = new ArrayList<>();

        for (Piece piece :
                this.pieces) {
            int pieceProgress = piece.getPosition().getProgress();
            if ((pieceProgress == PositionConstants.STABLE && diceValue == 6) || (pieceProgress >= PositionConstants.START && pieceProgress + diceValue <= PositionConstants.HOME )){
                movablePieces.add(piece);
            }
        }
        return movablePieces;
    }
}