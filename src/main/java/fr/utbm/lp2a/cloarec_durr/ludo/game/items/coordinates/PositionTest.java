package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @org.junit.jupiter.api.Test
    void getHomePosition() {
        Position pos = new Position(0, Color.BLUE);
        assertEquals(56, pos.getHomePosition().getProgress());
    }

    @org.junit.jupiter.api.Test
    void getStartPosition() {
        Position pos = new Position(0, Color.BLUE);
        assertEquals(0, pos.getStablePosition().getProgress());
    }

    @org.junit.jupiter.api.Test
    void getForwardPosition() {
        Position pos = new Position(0, Color.BLUE);
        assertEquals(6, pos.getForwardPosition(6).getProgress());
        pos = new Position(51, Color.BLUE);
        assertNull(pos.getForwardPosition(6));
    }

    @org.junit.jupiter.api.Test
    void convertPositionColor() {
        Position pos = new Position(0, Color.BLUE);
        assertEquals(0, pos.convertPositionColor(Color.BLUE).getProgress());
        assertEquals(39, pos.convertPositionColor(Color.RED).getProgress());
        assertEquals(26, pos.convertPositionColor(Color.GREEN).getProgress());
        assertEquals(13, pos.convertPositionColor(Color.YELLOW).getProgress());

        pos = new Position(55, Color.BLUE);
        assertNull(pos.convertPositionColor(Color.RED));

        pos = new Position(-1, Color.BLUE);
        assertNull(pos.convertPositionColor(Color.RED));

        pos = new Position(12, Color.YELLOW);
        assertNull(pos.convertPositionColor(Color.BLUE));

        pos = new Position(25, Color.GREEN);
        assertNull(pos.convertPositionColor(Color.BLUE));

        pos = new Position(38, Color.RED);
        assertNull(pos.convertPositionColor(Color.BLUE));

        pos = new Position(8, Color.BLUE);
        assertEquals(8, pos.convertPositionColor(Color.BLUE).getProgress());
        assertEquals(21, pos.convertPositionColor(Color.YELLOW).getProgress());
        assertEquals(34, pos.convertPositionColor(Color.GREEN).getProgress());
        assertEquals(47, pos.convertPositionColor(Color.RED).getProgress());

    }
}