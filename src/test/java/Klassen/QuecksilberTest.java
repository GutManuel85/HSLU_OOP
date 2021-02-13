package Klassen;

import OOP.Klassen.Quecksilber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuecksilberTest {

    Quecksilber quecksilber1;
    Quecksilber quecksilber2;
    Quecksilber quecksilber3;

    @BeforeEach
    void setUp() {
        quecksilber1 = new Quecksilber(0);
        quecksilber2 = new Quecksilber(-100);
        quecksilber3 = new Quecksilber(1);
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
        assertEquals(quecksilber1, quecksilber3);
    }

    @Test
    void testEqualsDifferent() {
        assertNotEquals(quecksilber1, quecksilber2);
    }

    @Test
    void testHashCodeSame() {
        assertEquals(quecksilber1, quecksilber3);
    }

    @Test
    void testHashCodeDifferent() {
        assertNotEquals(quecksilber1.hashCode(), quecksilber2.hashCode());
    }
}