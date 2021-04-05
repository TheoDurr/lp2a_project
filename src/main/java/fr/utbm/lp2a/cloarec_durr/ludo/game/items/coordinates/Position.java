package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;

import java.awt.*;

public class Position {
    private int progress;
    private Color playerColor;

    public static void main(String[] args) {
        Position pos = new Position(25, Color.GREEN);
        System.out.println(pos);
        System.out.println(pos.convertPositionColor(Color.BLUE));

    }

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

    public Position getStablePosition(){
        return new Position(PositionConstants.START, this.playerColor);
    }

    public Position getForwardPosition(int n){
        if (this.progress + n <= PositionConstants.HOME){
            return new Position(this.progress + n, this.playerColor);
        }
        else{
            return null;
        }
    }

    @Override
    public String toString() {
        return "Position{" +
                "progress=" + progress +
                ", playerColor=" + playerColor +
                '}';
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

    public Position convertPositionColor(Color destination){
        int sourceNumber = playerOrder(this.getPlayerColor());
        int destinationNumber = playerOrder(destination);
        int sourcePosition = this.getProgress();
        if (sourcePosition >=0 && sourcePosition <= PositionConstants.ONE_TURN - 2){
            int progress = (((sourceNumber -destinationNumber)%4)*PositionConstants.DELTA + sourcePosition)%PositionConstants.ONE_TURN;
            if (progress == PositionConstants.STABLE){
                return null;
            }
            else{
                return new Position(progress, destination);
            }

        }
        else {
            return null;
        }


    }


}
