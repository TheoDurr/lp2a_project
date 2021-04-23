package fr.utbm.lp2a.cloarec_durr.ludo.game.items;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.AbsolutePosition;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.Position;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.PositionConstants;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;
import fr.utbm.lp2a.cloarec_durr.ludo.gui.CaseMapping;


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
        if(isAtStable()){
            this.setPosition(this.getPosition().getForwardPosition(1));
        }
        else {
            this.setPosition(this.getPosition().getForwardPosition(progress));
        }

    }

    public void moveAtStable(){
        this.setPosition(this.getPosition().getStablePosition());
    }

    public boolean isAtImmuneSquare(){
        return this.isAtStar() || this.isAtColoredSquare();
    }

    public boolean isLegalMove(int diceProgress){
       return  (this.position.getProgress() == PositionConstants.STABLE && diceProgress == 6) || (this.position.getProgress() >= PositionConstants.START && this.position.getProgress() + diceProgress <= PositionConstants.HOME);
    }

    public AbsolutePosition getAbsolutePosition(CaseMapping mapping){

        if (this.isAtStable()){
            AbsolutePosition piecePosition = mapping.getMapping(this.color, this.position.getProgress());
            switch (this.color) {
                case Green -> {
                    switch (this.number) {
                        case 2 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX() + 2, piecePosition.getY());
                            break;
                        }
                        case 3 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY() + 2);
                            break;
                        }
                        case 4 -> {
                            piecePosition = new AbsolutePosition((piecePosition.getX() + 2), piecePosition.getY() + 2);
                            break;
                        }
                    }
                    break;
                }
                case Yellow -> {
                    switch (this.number) {
                        case 1 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY());
                            break;
                        }
                        case 2 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY());
                            break;
                        }
                        case 3 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY() + 2);
                            break;
                        }
                        case 4 -> {
                            piecePosition = new AbsolutePosition((piecePosition.getX()), piecePosition.getY() + 2);
                            break;
                        }
                    }
                    break;
                }
                case Blue -> {
                    switch (this.number) {
                        case 1 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY() - 2);
                            break;
                        }
                        case 2 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY() - 2);
                            break;
                        }
                        case 3 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX() - 2, piecePosition.getY());
                            break;
                        }
                        case 4 -> {
                            piecePosition = new AbsolutePosition((piecePosition.getX()), piecePosition.getY());
                            break;
                        }
                    }

                    break;
                }
                case Red -> {
                    switch (this.number) {
                        case 1 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY() - 2);
                            break;
                        }
                        case 2 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX() + 2, piecePosition.getY() - 2);
                            break;
                        }
                        case 3 -> {
                            piecePosition = new AbsolutePosition(piecePosition.getX(), piecePosition.getY());
                            break;
                        }
                        case 4 -> {
                            piecePosition = new AbsolutePosition((piecePosition.getX() + 2), piecePosition.getY());
                            break;
                        }
                    }
                    break;
                }
            }

            return piecePosition;
        }
        else {
            return  mapping.getMapping(this.color, this.position.getProgress());
        }


    }

    public boolean isBetterPlay( Piece reference){
        if (reference == null){
            return true;
        }
        else if (reference.isAtStable()){
            return false;
        }
        else if (!this.isAtImmuneSquare() && reference.isAtImmuneSquare()){
            return true;
        }
        else if (reference.getPosition().getProgress() < this.getPosition().getProgress()){
            return true;
        }
        else{
            return false;
        }

    }

}
