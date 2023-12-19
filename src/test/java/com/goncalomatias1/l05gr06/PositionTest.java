package com.goncalomatias1.l05gr06;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testConstructorAndGetters() {
        int x = 5;
        int y = 10;
        Position position = new Position(x, y);

        assertNotNull(position, "Position object should not be null");
        assertEquals(x, position.getX(), "X value should be equal to the one passed in constructor");
        assertEquals(y, position.getY(), "Y value should be equal to the one passed in constructor");
    }

    @Test
    void testSetters() {
        Position position = new Position(0, 0);
        position.setX(15);
        position.setY(20);

        assertEquals(15, position.getX(), "X value should be updated by setter");
        assertEquals(20, position.getY(), "Y value should be updated by setter");
    }

    @Test
    void testEquals() {
        Position position1 = new Position(5, 10);
        Position position2 = new Position(5, 10);
        Position position3 = new Position(10, 5);

        assertEquals(position1, position2, "Two positions with the same coordinates should be equal");
        assertNotEquals(position1, position3, "Two positions with different coordinates should not be equal");
        assertNotEquals(position1, null, "Position should not be equal to null");
        assertNotEquals(position1, new Object(), "Position should not be equal to a different type of object");
    }
}
