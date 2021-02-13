package Klassen;

import OOP.Klassen.Stickstoff;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StickstoffTest {

    Stickstoff stickstoff1;
    Stickstoff stickstoff2;
    Stickstoff stickstoff3;

    @BeforeEach
    void setUp() {

        stickstoff1 = new Stickstoff(0);
        stickstoff2 = new Stickstoff(-200);
        stickstoff3 = new Stickstoff(1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testErmittleAggregatszustand() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEqualsSame() {
        assertEquals(stickstoff1,stickstoff3);
    }

    @Test
    void testEqualsDifferent() {
        assertNotEquals(stickstoff1, stickstoff2);
    }

    @Test
    void testHashCodeSame() {
        assertEquals(stickstoff1.hashCode(), stickstoff3.hashCode());
    }

    @Test
    void testHashCodeDifferent(){
        assertNotEquals(stickstoff1.hashCode(), stickstoff2.hashCode());
    }

    @Test
    void testGetInfoElement(){}
}