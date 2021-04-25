package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;

/**
 * class for managing the position that are use to now were to print the piece in the screen
 * it is just a cartesian coordinate basis in 2 dimensions
 */
public class AbsolutePosition {
    private double x;
    private double y;

    /**
     * simple constructor where the two parameter are the two coordinate of the point
     * @param x : value of the coordinate on the x axis
     * @param y : value of the coordinate on the y axis
     */
    public AbsolutePosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * same has the previous constructor but the third parameter is the number of 90° rotation in the anti trigonometric sens that we want to apply on our point
     * this method is very specific and is used only to create the mapping of all the case of the game board
     * @param x : value of the coordinate on the x axis
     * @param y : value of the coordinate on the y axis
     * @param pos : number of 90° rotation in the anti trigonometric sens that we want to apply to the point
     */
    public AbsolutePosition(double x, double y, int pos) {
        x = x - 7;
        y = 7 - y;
        int cos, sin;
        switch (pos) {
            case 0 -> {
                cos = 1;
                sin = 0;
                break;
            }
            case 1 -> {
                cos = 0;
                sin = -1;
                break;
            }
            case 2 -> {
                cos = -1;
                sin = 0;
                break;
            }
            case 3 -> {
                cos = 0;
                sin = 1;
                break;
            }
            default -> {
                cos = 1;
                sin = 0;
            }
        }
        this.x = x * cos - y * sin;
        this.y = y * cos + x * sin;
        this.x = this.x + 7;
        this.y = 7 - this.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /**
     * same as the constructor but used for testing
     * @param x : value of the coordinate on the x axis
     * @param y : value of the coordinate on the y axis
     * @param pos : number of 90° rotation in the anti trigonometric sens that we want to apply to the point
     * @return : return the object that as been created
     */
    public static AbsolutePosition getAbsolutePosition(double x, double y, int pos){
        return  new AbsolutePosition(x, y, pos);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
