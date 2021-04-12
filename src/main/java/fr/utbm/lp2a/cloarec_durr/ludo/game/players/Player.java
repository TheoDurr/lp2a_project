package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.PositionConstants;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player {

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

    public int throwDice(){
        return this.dice.Throw();
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

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", pieces=" + Arrays.toString(pieces) +
                '}';
    }

    public abstract int trowDice();
    public abstract int choosePiece();
}
