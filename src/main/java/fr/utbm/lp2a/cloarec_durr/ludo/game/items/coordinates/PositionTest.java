package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;





import fr.utbm.lp2a.cloarec_durr.ludo.game.utils.Color;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @org.junit.jupiter.api.Test
    void getHomePosition() {
        Position pos = new Position(0, Color.Blue);
        assertEquals(56, pos.getHomePosition().getProgress());
    }

    @org.junit.jupiter.api.Test
    void getStartPosition() {
        Position pos = new Position(0, Color.Blue);
        assertEquals(0, pos.getStablePosition().getProgress());
    }

    @org.junit.jupiter.api.Test
    void getForwardPosition() {
        Position pos = new Position(0, Color.Blue);
        assertEquals(6, pos.getForwardPosition(6).getProgress());
        pos = new Position(51, Color.Blue);
        assertNull(pos.getForwardPosition(6));
    }

    @org.junit.jupiter.api.Test
    void convertPositionColor() {
        Position pos = new Position(0, Color.Blue);
        assertEquals(0, pos.convertPositionColor(Color.Blue).getProgress());
        assertEquals(39, pos.convertPositionColor(Color.Red).getProgress());
        assertEquals(26, pos.convertPositionColor(Color.Green).getProgress());
        assertEquals(13, pos.convertPositionColor(Color.Yellow).getProgress());

        pos = new Position(55, Color.Blue);
        assertNull(pos.convertPositionColor(Color.Red));

        pos = new Position(-1, Color.Blue);
        assertNull(pos.convertPositionColor(Color.Red));

        pos = new Position(12, Color.Yellow);
        assertNull(pos.convertPositionColor(Color.Blue));

        pos = new Position(25, Color.Green);
        assertNull(pos.convertPositionColor(Color.Blue));

        pos = new Position(38, Color.Red);
        assertNull(pos.convertPositionColor(Color.Blue));

        pos = new Position(8, Color.Blue);
        assertEquals(8, pos.convertPositionColor(Color.Blue).getProgress());
        assertEquals(21, pos.convertPositionColor(Color.Yellow).getProgress());
        assertEquals(34, pos.convertPositionColor(Color.Green).getProgress());
        assertEquals(47, pos.convertPositionColor(Color.Red).getProgress());

    }
}