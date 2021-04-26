package fr.utbm.lp2a.cloarec_durr.ludo.game.items;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.AbsolutePosition;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.PositionConstants;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.CaseMapping;

/**
 * class that represent a piece on the game board
 */
public class Piece {

    private Position position;
    private final Color color;
    private final int number;

    /**
     * simple constructor create a new piece, by default the position of the piece is the stable of the player color
     * @param color : the color of the piece, the same as the color of the player
     * @param number : the number of the piece paint on it
     */

    public Piece(Color color, int number){
        this.position = new Position(PositionConstants.STABLE, color);
        this.color = color;
        this.number = number;
    }

    /**
     * get the position of the piece
     * @return the position attribute of this object
     */
    public Position getPosition() {
        return position;
    }

    /**
     * set the position of this object
     * @param position : the position that we want to give to our object
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * get the color of the pieces
     * @return the color of the piece
     */
    public Color getColor() {
        return color;
    }


    /**
     * get the number of the piece
     * @return the value of the number of the piece
     */
    public int getNumber() {
        return number;
    }


    /**
     * check if the piece is on its stable
     * @return true iff the piece is at stable
     */
    public boolean isAtStable(){
        return this.getPosition().getProgress() == PositionConstants.STABLE;
    }

    /**
     * check if the piece is on its home
     * @return true iff the piece is at home
     */
    public boolean isAtHome(){
        return this.getPosition().getProgress() == PositionConstants.HOME;
    }

    /**
     * check if the piece is on a star case
     * @return true iff the piece is on a star case
     */
    public boolean isAtStar(){
        return this.getPosition().getProgress()%PositionConstants.DELTA == PositionConstants.STAR;
    }

    /**
     * check if the piece is on a colored case
     * @return true iff the piece is on a colored case
     */
    public boolean isAtColoredSquare(){
        int progress = this.getPosition().getProgress();
        return progress % PositionConstants.DELTA == PositionConstants.START || progress < PositionConstants.ARROW;
    }

    /**
     * change the position of the piece to the case "progress" case forward
     * @param progress : the amount of the case that we want move the piece forward
     */
    public void moveForward(int progress){
        if(isAtStable()){
            this.setPosition(this.getPosition().getForwardPosition(1));
        }
        else {
            this.setPosition(this.getPosition().getForwardPosition(progress));
        }

    }

    /**
     * change the position of the piece to the stable
     */
    public void moveAtStable(){
        this.setPosition(this.getPosition().getStablePosition());
    }

    /**
     * check if the piece is on a Immune case
     * @return true iff the piece is on a immune case
     */
    public boolean isAtImmuneSquare(){
        return this.isAtStar() || this.isAtColoredSquare();
    }

    /**
     * check that if the move of this piece "diceProgress" forward is a legal move according to the rule, don't change the position of the piece, just try
     * @param diceProgress : the value given by the dice to know how many case that we are able to move
     * @return true iff the move is legal according to the rules
     */
    public boolean isLegalMove(int diceProgress){
       return  (this.position.getProgress() == PositionConstants.STABLE && diceProgress == 6) || (this.position.getProgress() >= PositionConstants.START && this.position.getProgress() + diceProgress <= PositionConstants.HOME);
    }

    /**
     * get the absolutePosition of the piece in the coordinate system to be printed on the screen
     * @param mapping : the object that contain a big table with the coordinate of all the case on the screen, makes the link between relative and absolute position
     * @return the AbsolutePosition of the piece
     */
    public AbsolutePosition getAbsolutePosition(CaseMapping mapping){

        if (this.isAtStable()){
            AbsolutePosition piecePosition = mapping.getMapping(this.color, this.position.getProgress());
            switch (this.color) {
                case Green -> {
                    switch (this.number) {
                        case 2 -> piecePosition = new AbsolutePosition(piecePosition.getX() + 2, piecePosition.getY());
                        case 3 -> piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY() + 2);
                        case 4 -> piecePosition = new AbsolutePosition((piecePosition.getX() + 2), piecePosition.getY() + 2);
                    }
                }
                case Yellow -> {
                    switch (this.number) {
                        case 1 -> piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY());
                        case 2 -> piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY());
                        case 3 -> piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY() + 2);
                        case 4 -> piecePosition = new AbsolutePosition((piecePosition.getX()), piecePosition.getY() + 2);
                    }
                }
                case Blue -> {
                    switch (this.number) {
                        case 1 -> piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY() - 2);
                        case 2 -> piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY() - 2);
                        case 3 -> piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY());
                        case 4 -> piecePosition = new AbsolutePosition((piecePosition.getX()), piecePosition.getY());
                    }
                }
                case Red -> {
                    switch (this.number) {
                        case 1 -> piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY() - 2);
                        case 2 -> piecePosition = new AbsolutePosition(piecePosition.getX() + 2, piecePosition.getY() - 2);
                        case 3 -> piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY());
                        case 4 -> piecePosition = new AbsolutePosition((piecePosition.getX() + 2), piecePosition.getY());
                    }
                }
            }

            return piecePosition;
        }
        else {
            return  mapping.getMapping(this.color, this.position.getProgress());
        }
    }

}
