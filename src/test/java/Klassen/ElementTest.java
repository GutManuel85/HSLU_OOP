package Klassen;

import OOP.Klassen.Aggregatszustand;
import OOP.Klassen.Blei;
import OOP.Klassen.Quecksilber;
import OOP.Klassen.Stickstoff;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElementTest {

    @Test
    void testErmittleAggregatszustandBleiSolid() {
        Blei blei = new Blei(0.00d);
        assertEquals(Aggregatszustand.SOLID, blei.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggregatszustandBleiLiquid() {
        Blei blei = new Blei(400.00d);
        assertEquals(Aggregatszustand.LIQUID, blei.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggragatszustandBleiGas() {
        Blei blei = new Blei(2000.00d);
        assertEquals(Aggregatszustand.GAS, blei.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggregatszustandQuecksilberSolid() {
        Quecksilber quecksilber = new Quecksilber(-40.00d);
        assertEquals(Aggregatszustand.SOLID, quecksilber.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggregatszustandQuecksilberLiquid() {
        Quecksilber quecksilber = new Quecksilber(0.00d);
        assertEquals(Aggregatszustand.LIQUID, quecksilber.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggragatszustandQuecksilberGas() {
        Quecksilber quecksilber = new Quecksilber(500.00d);
        assertEquals(Aggregatszustand.GAS, quecksilber.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggregatszustandStickstoffSolid() {
        Stickstoff stickstoff = new Stickstoff(-220.00d);
        assertEquals(Aggregatszustand.SOLID, stickstoff.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggregatszustandStickstoffLiquid() {
        Stickstoff stickstoff = new Stickstoff(-200.00d);
        assertEquals(Aggregatszustand.LIQUID, stickstoff.ermittleAggregatszustand());
    }

    @Test
    void testErmittleAggragatszustandStickstoffGas() {
        Stickstoff stickstoff = new Stickstoff(0.00d);
        assertEquals(Aggregatszustand.GAS, stickstoff.ermittleAggregatszustand());
    }

}

