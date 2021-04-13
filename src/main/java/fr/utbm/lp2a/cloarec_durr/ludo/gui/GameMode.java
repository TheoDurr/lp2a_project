package fr.utbm.lp2a.cloarec_durr.ludo.gui;

public enum GameMode {
    oneHumanVersusTreeArtificialIntelligence, fourHumans, fourArtificialIntelligence;

    @Override
    public String toString() {
        switch (this){
            case fourHumans -> {return "Four Humans";}
            case oneHumanVersusTreeArtificialIntelligence -> {return "One Human Versus Tree Artificial Intelligences";}
            case fourArtificialIntelligence -> {return "Four Artificial Intelligences";}
        }
        return "";
    }
}
