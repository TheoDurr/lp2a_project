package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

public class GameBoardGui extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L;
    private Image gameBoardImage;
    private Image[] piecesImage;
    private String[] pseudos;

    public GameBoardGui(){
        this.piecesImage = new Image[16];
        try {
            gameBoardImage = ImageIO.read(new File("src/main/resources/ludo_game_board.png"));
            for (int i = 0; i < 16; i++) {
                piecesImage[i] = ImageIO.read(new File("src/main/resources/piece/piece" + Color.intToColor((i / 4) +1).toString() + ((i%4)+1) + ".png"));
            }
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        setPreferredSize(new Dimension(600, 600));
    }

    public void paint(Graphics g){
        g.drawImage(gameBoardImage, 0, 0, getWidth(), getHeight(), this);
        for (int i = 0; i < 16; i++) {
            g.drawImage(piecesImage[i], (i%2)*40, (i/2)*40, 40, 40, this);
        }
    }
}
