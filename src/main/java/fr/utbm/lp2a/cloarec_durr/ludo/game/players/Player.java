package fr.utbm.lp2a.cloarec_durr.ludo.game.players;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Dice;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Player {

    private final String name;
    private final Color color;
    private final Dice dice;
    private final Piece[] pieces;
    private Player nextPlayer = null;

    public Player(String name, Color color, Dice dice) {
        this.name = name;
        this.color = color;
        this.pieces = new Piece[4];
        for (int i = 0; i < this.pieces.length; i++) {
            pieces[i] = new Piece(color, i + 1);
        }
        this.dice = dice;
    }

    //
    //********* GETTER & SETTERS *********
    //

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public void setNextPlayer(Player nextPlayer){
        this.nextPlayer = nextPlayer;
    }

    public Dice getDice() {
        return dice;
    }

    //
    //********* METHODS *********
    //
    public abstract Piece choosePiece();

    /**
     * Get the number of pieces at home
     *
     * @return int : the number of pieces at home
     */
    public int getNumberOfPieceAtHome() {
        int i = 0;
        for (Piece piece :
                this.getPieces()) {
            if (piece.isAtHome()) {
                i++;
            }
        }
        return i;
    }

    /**
     * Get the list of the movable pieces
     *
     * @return the list of the movable pieces
     */
    public List<Piece> getMovablePieces() {
        List<Piece> movablePieces = new ArrayList<>();

        for (Piece piece :
                this.getPieces()) {
            if (piece.isLegalMove(this.dice.getValue())) {
                movablePieces.add(piece);
            }
        }
        return movablePieces;
    }

    /**
     * Throws the player's dice
     *
     * @return the dice value
     */
    public int throwDice() {
        return this.dice.Throw();
    }

    @Override
    public String toString() {
        return "DEBUG : Player{" +
                "name='" + getName() + '\'' +
                ", color=" + getColor() +
                ", pieces=" + Arrays.toString(getPieces()) +
                '}';
    }

    public Player getNextPlayer(){
        return this.nextPlayer;
    }

    public abstract boolean isHumanPlayer();
}
