package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;

public class AbsolutePosition {
    private double x;
    private double y;

    public AbsolutePosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public
    AbsolutePosition(double x, double y, int pos) {
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

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static AbsolutePosition getAbsolutePosition(double x, double y, int pos){
        return  new AbsolutePosition(x, y, pos);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
