package fr.utbm.lp2a.cloarec_durr.game;

import java.awt.*;

public class Position {
    private int progress;
    private Color playerColor;
    //Square value;


    public Position(int progress, Color playerColor) {
        this.progress = progress;
        this.playerColor = playerColor;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Color getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(Color playerColor) {
        this.playerColor = playerColor;
    }

    public Position getHomePosition(){
        return new Position(PositionConstants.HOME, this.playerColor);
    }

    public Position getStartPosition(){
        return new Position(PositionConstants.START, this.playerColor);
    }

    public Position getForwardPosition(int n){
        if (this.progress + n <= PositionConstants.HOME){
            return new Position(this.progress + n, this.playerColor);
        }
        else{
            return this;
        }
    }

    public static int playerOrder(Color color){ //move it in the right class
        if (color == Color.RED){
            return 1;
        }
        else if (color == Color.green){
            return 2;
        }
        else if (color == Color.yellow){
            return 3;
        }
        else if (color == Color.blue){
            return 4;
        }
        else {
            return 0;
        }
    }

    public Position convertPositionColor(Position source, Color destination){
        return new Position(((playerOrder(source.getPlayerColor()) - playerOrder(destination)%4)*PositionConstants.DELTA)%PositionConstants.ONE_TURN, destination);

    }


}
