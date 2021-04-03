package fr.utbm.lp2a.cloarec_durr.game.items;

import fr.utbm.lp2a.cloarec_durr.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.game.items.coordinates.PositionConstants;

import java.awt.*;

public class Piece {

    private Position position;
    private Color color;

    public Piece(Position position, Color color) {
        this.position = position;
        this.color = color;
    }

    public Piece(Color color){
        this.position = new Position(PositionConstants.STABLE, color);
        this.color = color;
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

    boolean isAtStable(){
        return this.getPosition().getProgress() == PositionConstants.STABLE;
    }

    boolean isAtHome(){
        return this.getPosition().getProgress() == PositionConstants.HOME;
    }

    boolean isAtStar(){
        return this.getPosition().getProgress()%PositionConstants.DELTA == PositionConstants.STAR;
    }

    boolean isAtColoredSquare(){
        int progress = this.getPosition().getProgress();
        return progress % PositionConstants.DELTA == PositionConstants.START || progress < PositionConstants.ARROW;
    }

    void moveForward(int progress){
        this.setPosition(this.getPosition().getForwardPosition(progress));
    }

    void moveAtStable(){
        this.setPosition(this.getPosition().getStablePosition());
    }

    boolean isImmune(){
        return this.isAtStar() || this.isAtColoredSquare();
    }





}
