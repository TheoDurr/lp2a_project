package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.AbsolutePosition;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

/**
 * class for making the conversion from the relative position of each piece and the coordinate that we have to print on screen
 *
 * @author Florian CLOAREC
 */
public class CaseMapping {

    private final AbsolutePosition[][] colorMapping;

    /**
     * basic constructor of the class, create a table with all the Absolute position corresponding to each progress in each color
     */
    public CaseMapping() {
        this.colorMapping = new AbsolutePosition[4][];
        for (int i = 0; i < 4; i++) {
            this.colorMapping[i] = new AbsolutePosition[58];

            // 0
            this.colorMapping[i][0] = new AbsolutePosition(1.5, 1.5,i);

            // 1 to 5
            for (int j = 1; j < 6; j++) {
                this.colorMapping[i][j] = new AbsolutePosition(j, 6, i);
            }

            // 6 to 11
            for (int j = 0; j < 6; j++) {
                this.colorMapping[i][j + 6] = new AbsolutePosition(6,5-j, i);
            }

            //12
            this.colorMapping[i][12] = new AbsolutePosition(7, 0, i);

            //13 to 18
            for (int j = 0; j < 6; j++) {
                this.colorMapping[i][j + 13] = new AbsolutePosition(8, j, i);
            }

            //19 to 24
            for (int j = 0; j < 6; j++) {
                this.colorMapping[i][j + 19] = new AbsolutePosition(j + 9, 6, i);
            }

            //25
            this.colorMapping[i][25] = new AbsolutePosition(14, 7, i);

            //26 to 31
            int gridSize = 15;
            for (int j = 0; j < 6; j++) {
                this.colorMapping[i][j + 26] = new AbsolutePosition(gridSize - j - 1, 8, i);
            }

            // 32 to 37
            for (int j = 0; j < 6; j++) {
                this.colorMapping[i][j + 32] = new AbsolutePosition(8, j + 9, i);
            }

            // 38
            this.colorMapping[i][38] = new AbsolutePosition(7, 14, i);

            //39 to 44
            for (int j = 0; j < 6; j++) {
                this.colorMapping[i][j + 39] = new AbsolutePosition(6, gridSize - j - 1, i);
            }

            //45 to 50
            for (int j = 0; j < 6; j++) {
                this.colorMapping[i][j + 45] = new AbsolutePosition(5- j, 8, i);
            }

            //51 to 57
            for (int j = 0; j < 7; j++) {
                this.colorMapping[i][j + 51] = new AbsolutePosition(j, 7, i);
            }
        }
    }

    /**
     * read the table to get the value of this position
     * @param color : the color of the piece that we want to print
     * @param progress : the progress of the piece that we want to print
     * @return : the absolute position of the piece for printing it on the screen
     */
    public AbsolutePosition getMapping(Color color, int progress){
        return this.colorMapping[color.toInt() - 1][progress + 1];
    }
}
