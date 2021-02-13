package Klassen;

import OOP.Klassen.Blei;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BleiTest {

    Blei blei1;
    Blei blei2;
    Blei blei3;
    Blei blei4;

    @BeforeEach
    void setUp() {

        blei1 = new Blei(0);
        blei2 = new Blei(3000);
        blei3 = new Blei(0);
        blei4 = new Blei(1);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void ermittleAggregatszustand() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testEqualsSame() {
        assertEquals(blei1, blei3);
    }

    @Test
    void testEqualsDifferent() {
        assertNotEquals(blei1, blei2);
    }

    @Test
    void testHashCode() {
        assertEquals(blei1.hashCode(), blei4.hashCode());
    }

    @Test
    void testHashCodeNotEquals(){
        assertNotEquals(blei1.ermittleAggregatszustand(), blei2.ermittleAggregatszustand());
    }
}
