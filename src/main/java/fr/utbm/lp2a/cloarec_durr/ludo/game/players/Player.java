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
    private final Dice dice;
    private final Piece[] pieces;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        this.pieces = new Piece[4];
        for (int i = 0; i < this.pieces.length; i++) {
            pieces[i] = new Piece(color, i);
        }
        this.dice = new Dice();
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

    /**
     * Get the piece index
     *
     * @param p the piece the index to get
     * @return int : the index of the piece (-1 if not found)
     */
    public int getPieceIndex(Piece p) {
        for (int i = 0; i < pieces.length; i++) {
            if (pieces[i] == p) {
                return i;
            }
        }
        // No piece Found
        // Should never happen
        return -1;
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
            int pieceProgress = piece.getPosition().getProgress();
            if ((pieceProgress == PositionConstants.STABLE && dice.getValue() == 6) || (pieceProgress >= PositionConstants.START && pieceProgress + dice.getValue() <= PositionConstants.HOME)) {
                movablePieces.add(piece);
            }
        }
        return movablePieces;
    }

    /**
     * Ask the user the piece to move and moves it of N squares
     *
     * @param pieceToMove The piece to move
     */
    public void movePiece(Piece pieceToMove) {
        int pieceIndex = getPieceIndex(pieceToMove);
        if (pieceIndex != -1) {
            pieces[pieceIndex].moveForward(dice.getValue());
        } else {
            System.out.println("ERROR : Piece not found");
        }
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
}
