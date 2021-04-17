package fr.utbm.lp2a.cloarec_durr.ludo.game.items;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.PositionConstants;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;


public class Piece {

    private Position position;
    private Color color;
    private int number;

    public Piece(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Piece(Color color, int number){
        this.position = new Position(PositionConstants.STABLE, color);
        this.color = color;
        this.number = number;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isAtStable(){
        return this.getPosition().getProgress() == PositionConstants.STABLE;
    }

    public boolean isAtHome(){
        return this.getPosition().getProgress() == PositionConstants.HOME;
    }

    public boolean isAtStar(){
        return this.getPosition().getProgress()%PositionConstants.DELTA == PositionConstants.STAR;
    }

    public boolean isAtColoredSquare(){
        int progress = this.getPosition().getProgress();
        return progress % PositionConstants.DELTA == PositionConstants.START || progress < PositionConstants.ARROW;
    }

    public void moveForward(int progress){
        this.setPosition(this.getPosition().getForwardPosition(progress));
    }

    public void moveAtStable(){
        this.setPosition(this.getPosition().getStablePosition());
    }

    public boolean isAtImmuneSquare(){
        return this.isAtStar() || this.isAtColoredSquare();
    }

}
