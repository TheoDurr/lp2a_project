package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;


import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

/**
 * class for managing and storing the position of each piece in a relative base for each color
 * in this system, a Position is a couple of a Color and a progress. The progress is the amount of case ran since the start and the stable has the value -1
 * @author Florian CLOAREC
 */

public class Position {
    private int progress;
    private final Color playerColor;

    /**
     * create a new Position with the value given in parameter
     * @param progress : the value that we want to give at the progress, for initialization of a piece put : PositionConstant.Stable
     * @param playerColor : the color of the place who own the piece
     */
    public Position(int progress, Color playerColor) {
        this.progress = progress;
        this.playerColor = playerColor;
    }

    public int getProgress() {
        return progress;
    }


    public Color getPlayerColor() {
        return playerColor;
    }

    /**
     * get an object that is the position of the home of the player
     * @return a new Position object witch is the Home of the player
     */
    public Position getHomePosition(){
        return new Position(PositionConstants.HOME, this.playerColor);
    }

    /**
     * get an objet that is the position of the stable of the player
     * @return a new Position object witch is the Stable of the player
     */
    public Position getStablePosition(){
        return new Position(PositionConstants.START, this.playerColor);
    }

    /**
     * get the position of the case that is n case forward for this piece
     * @param n : the amount of case that we want to see forward
     * @return a new Position object which is the position of the case n case forward
     */
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

    /**
     * convert this position in the position in the basis of the destination color player
     * @param destination : the color of the player that we want to convert the position
     * @return : a new Position object that is the same position as this but in the destination base
     */
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

    /**
     * test if two position are equal even if they are not both in the same basis
     * @param compareTo : the position that we want to compare to this
     * @return true if it is equal false else
     */
    public boolean equals(Position compareTo){
        Position convertPos = compareTo.convertPositionColor(this.getPlayerColor());
        return convertPos != null && convertPos.getProgress() == this.getProgress();
    }


}
