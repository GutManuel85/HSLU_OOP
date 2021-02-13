package Klassen;

import OOP.Klassen.Demo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

 private Demo demo1;

    @BeforeEach // wird vor jeder Methode ausgeführt. Die Initialisierung der Variabel muss aber vor der Methode geschehen, da sonst nur lokale Variabel
    void setUp() {
        demo1 = new Demo();
    }

    @AfterEach // wird nach jeder Methode ausgeführt.
    void tearDown() {
    }

    @Test
    void max1AGroesserB() {
        int max = demo1.max1(2,1);
        assertEquals(2, max );
    }

    @Test
    void max1AKleinerB(){
        int max = demo1.max1(1,2);
        assertEquals(2,max);
    }

    @Test
    void max1AGleichB(){
        int max = demo1.max1(0,0);
        assertEquals(0,max);
    }


    @Test
    void max2() {
        int max = demo1.max2(1,2,3);
        assertEquals(3, max);
    }

    @Test
    void max3() {
        int max = demo1.max3(1,2,3);
        assertEquals(3,max);
    }

    @Test
    void max4() {
        int max = demo1.max4(10,20,30);
        assertEquals(30, max);
    }

    @Test
    void min() {
        int min = demo1.min(-5, -10);
        assertEquals(-10, min);
    }
}