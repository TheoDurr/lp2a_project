package fr.utbm.lp2a.cloarec_durr.ludo.game.utils;

/**
 * enum where the different color that the player can take are defined
 */
public enum Color {
    Green, Yellow, Blue, Red;

    /**
     * create a string of the color in english starting with a CAPITAL letter
     * @return : the string of the color
     */
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

    /**
     * give the number of the position of this color on the board, start at 1 by the top left corner and turn in anti trigonometric sens
     * @return : the int value of the color
     */
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

    /**
     * reverse fontion as toInt(), take an int in parameter and return the corresponding color
     * @param i : the number of the color on the grind
     * @return : the corresponding color
     */

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
