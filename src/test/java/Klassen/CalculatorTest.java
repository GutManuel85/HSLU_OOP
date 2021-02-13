package Klassen;

import OOP.Klassen.Calculateable;
import OOP.Klassen.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculateable calculator1;


    @BeforeEach
    void setUp() {
        calculator1 = new Calculator(); //Das hier ist Polymorphie. Calculator-Objekt wird in Calculatabele Typ gespeichert.
    }

    @Test
    void addition1() {
        int result = calculator1.addition(0, 0);
        assertEquals(0, result);
        System.out.println(result);
    }

    @Test
    void addition2() {
        int result = calculator1.addition(5, 5);
        assertEquals(10, result);
        System.out.println(result);
    }

    @Test
    void addition3() {
        int result = calculator1.addition(-5, -5);
        assertEquals(-10, result);
        System.out.println(result);
    }

    @Test
    void addition4() {
        int result = calculator1.addition(2, -5);
        assertEquals(-3, result);
        System.out.println(result
        );
    }
}
