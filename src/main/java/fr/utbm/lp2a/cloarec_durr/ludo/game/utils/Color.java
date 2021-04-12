package fr.utbm.lp2a.cloarec_durr.ludo.game.utils;

public enum Color {
    Green, Yellow, Blue, Red;

    @Override
    public String toString() {
        switch (this){
            case Green -> {
                return "Green";
            }
            case Yellow -> {
                return "Yellow";
            }
            case Blue -> {
                return "Blue";
            }
            case Red -> {
                return "Red";
            }

        }
        return "";
    }

    public int toInt(){
        switch (this){
            case Green -> {
                return 1;
            }
            case Yellow -> {
                return 2;
            }
            case Blue -> {
                return  3;
            }
            case Red -> {
                return 4;
            }

        }
        return 0;
    }

    public static Color intToColor(int i){
        switch (i){
            case 1 -> {
                return Green;
            }
            case 2 -> {
                return Yellow;
            }
            case 3 -> {
                return Blue;
            }
            case 4 -> {
                return Red;
            }
        }
        return null;
    }
}
