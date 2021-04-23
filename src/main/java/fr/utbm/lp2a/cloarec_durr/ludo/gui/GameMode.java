package fr.utbm.lp2a.cloarec_durr.ludo.gui;

/**
 * enum for storing all the available game mode
 * @author Florian CLOAREC
 */
public enum GameMode {
    /**
     * onHumanVersusTreeArtificialIntelligence : game with a only one human player
     * fourHumans : game with four human player
     * fourArtificialIntelligence : game with four intelligences artificial player, no gui in this mode
     * debug : game in the debug mode, the piece go forward for juste one case each turn
     */
    oneHumanVersusTreeArtificialIntelligence, fourHumans, fourArtificialIntelligence, debug;

    /**
     * convert this object in a string that represent the object, here the name in the enum
     * @return a string with the name of the enum
     */
    @Override
    public String toString() {
        switch (this){
            case fourHumans -> {return "Four Humans";}
            case oneHumanVersusTreeArtificialIntelligence -> {return "One Human Versus Tree Artificial Intelligences";}
            case fourArtificialIntelligence -> {return "Four Artificial Intelligences";}
            case debug -> {return "Debug";}
        }
        return "";
    }
}
