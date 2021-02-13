package Klassen;

import OOP.Klassen.Motor;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class MotorTest {

    Motor motor1;

    @BeforeEach
    public void setUp(){
    }

    @AfterEach
    public void tearDown(){
    }

    @Test
    public void testKonstruktorState(){
        this.motor1 = new Motor(6,100);
        assertEquals(this.motor1.getState().getStatusbezeichnung(), "off");
    }

    @Test
    public void testSwitchOn() {
        this.motor1 = new Motor(6, 200);
        this.motor1.switchOn();
        assertEquals(motor1.getIsSwitchedOn(), true);
        assertEquals(motor1.getRpm(), 1000);
    }

    @Test
    public void testSwitchOff() {
        this.motor1 = new Motor(6,100);
        this.motor1.switchOff();
        assertEquals(motor1.getIsSwitchedOn(), false);
        assertEquals(motor1.getRpm(),0);
    }

    @Test
    public void isSwitchedOn() {

    }

    @Test
    public void isSwitchedOff() {
    }

    @Test
    public void tunen() {
    }

    @Test
    public void umbauAutomat() {
    }

    @Test
    public void gangHochSchalten() {
    }

    @Test
    public void gangRunterSchalten() {
    }
}