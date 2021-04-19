package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;


import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

public class Position {
    private int progress;
    private Color playerColor;

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


    public Position convertPositionColor(Color destination){
        int sourceNumber = this.getPlayerColor().toInt();
        int destinationNumber = destination.toInt();
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

    public boolean equals(Position compareTo){
        return compareTo.convertPositionColor(this.getPlayerColor()).getProgress() == this.getProgress();
    }


}
