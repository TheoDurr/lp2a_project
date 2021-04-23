package fr.utbm.lp2a.cloarec_durr.ludo.game.items.coordinates;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbsolutePositionTest {
    @Test
    void getAbsolutePosition(){
        assertEquals(("(0.0, 0.0)"), AbsolutePosition.getAbsolutePosition(0, 0, 0).toString());
        assertEquals(("(1.0, 1.0)"), AbsolutePosition.getAbsolutePosition(1, 1, 0).toString());
        assertEquals(("(1.0, 0.0)"), AbsolutePosition.getAbsolutePosition(1, 0, 0).toString());
        assertEquals(("(0.0, 1.0)"), AbsolutePosition.getAbsolutePosition(0, 1, 0).toString());
        assertEquals(("(2.0, 1.0)"), AbsolutePosition.getAbsolutePosition(2, 1, 0).toString());

        /*assertEquals(("(0.0, 14.0)"), AbsolutePosition.getAbsolutePosition(0, 0, 1).toString());
        assertEquals(("(1.0, -1.0)"), AbsolutePosition.getAbsolutePosition(1, 1, 1).toString());
        assertEquals(("(0.0, -1.0)"), AbsolutePosition.getAbsolutePosition(1, 0, 1).toString());
        assertEquals(("(1.0, 0.0)"), AbsolutePosition.getAbsolutePosition(0, 1, 1).toString());
        assertEquals(("(1.0, -2.0)"), AbsolutePosition.getAbsolutePosition(2, 1, 1).toString());*/

    }

}