package fr.utbm.lp2a.cloarec_durr.ludo.gui;

import fr.utbm.lp2a.cloarec_durr.ludo.game.items.Piece;
import fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates.AbsolutePosition;
import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

import java.io.File;
import java.io.IOException;
import java.io.Serial;

public class GameBoardGui extends JPanel {

    @Serial
    private static final long serialVersionUID = 1L;
    private Image gameBoardImage;
    private final Image[] piecesImage;
    private final String[] pseudos;
    private final Piece[] pieces;
    private final CaseMapping mapping;

    private final int caseSize = 40; //pixels
    private final int boardSize = 15; // cases

    public GameBoardGui(Piece[] pieces, String[] pseudos){
        this.pieces = pieces;
        this.mapping = new CaseMapping();
        this.pseudos = pseudos;
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
        setPreferredSize(new Dimension(caseSize*boardSize, caseSize*boardSize));
    }

    public void paint(Graphics g){
        g.drawImage(gameBoardImage, 0, 0, getWidth(), getHeight(), this);
        for (int i = 0; i < 16; i++) {
            AbsolutePosition piecePosition = this.pieces[i].getAbsolutePosition(this.mapping);
            g.drawImage(piecesImage[i], (int) (piecePosition.getX()*caseSize), (int) (piecePosition.getY()*caseSize), caseSize, caseSize, this);
        }
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.setColor(java.awt.Color.BLACK);
        g.drawString(pseudos[0], (2 * caseSize), (int) (5.7 * caseSize));
        g.drawString(pseudos[1], (11 * caseSize), (int) (5.7 * caseSize));
        g.drawString(pseudos[2], (11 * caseSize), (int) (9.7 * caseSize));
        g.drawString(pseudos[3], (2 * caseSize), (int) (9.7 * caseSize));
    }

    public void updatePieces(){
        paint(this.getGraphics());
    }
}
