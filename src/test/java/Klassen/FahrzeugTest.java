package Klassen;

import OOP.Klassen.Fahrzeug;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FahrzeugTest {

    @Test
    /** Testet, ob Licht eingeschaltet wird, sobald Motor eingeschaltet wird. */
    public void testSwitchOnMotorEvent(){
        Fahrzeug fahrzeug = new Fahrzeug(6,200);
        fahrzeug.getLicht().switchOff();
        fahrzeug.getMotor().switchOn();
        assertEquals(true, fahrzeug.getLicht().isSwitchedOn());
    }

    @Test
    /** Testet, ob Meldung erscheint, dass Lichte eingeschaltet ist. */
    public void testSwichtOnLichtEvent(){
    Fahrzeug fahrzeug = new Fahrzeug(5, 100);
    fahrzeug.getLicht().switchOff();
    fahrzeug.getLicht().switchOn();
    assertEquals(true, fahrzeug.statusAnzeigeLampen().getIsSwitchedOnLichtAnzeige());
    }

}