package Klassen;

import OOP.Klassen.Temperatur;
import OOP.Klassen.TemperaturVerlauf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturVerlaufTest {

    TemperaturVerlauf temperaturVerlauf1;

    @BeforeEach
    void setUp() {

        temperaturVerlauf1 = new TemperaturVerlauf();
    }

    @Test
    void testAdd() {
        temperaturVerlauf1.add(Temperatur.createFromCelsius(0));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(20));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(40));
        assertEquals(0, temperaturVerlauf1.getVerlaufArray().get(0).getTemperaturCelsius());
        assertEquals(20, temperaturVerlauf1.getVerlaufArray().get(1).getTemperaturCelsius());
        assertEquals(40, temperaturVerlauf1.getVerlaufArray().get(2).getTemperaturCelsius());
    }

    @Test
    void testClear() {
        temperaturVerlauf1.add(Temperatur.createFromCelsius(0));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(20));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(40));
        assertEquals(3, temperaturVerlauf1.getVerlaufArray().size());
        temperaturVerlauf1.clear();
        assertEquals(0, temperaturVerlauf1.getVerlaufArray().size());

    }

    @Test
    void testGetCount() {
        temperaturVerlauf1.add(Temperatur.createFromCelsius(0));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(20));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(40));
        assertEquals(3, temperaturVerlauf1.getCount());
    }

    @Test
    void testMax1() throws Exception {
        temperaturVerlauf1.add(Temperatur.createFromCelsius(10));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(40));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(20));
        assertEquals(40, temperaturVerlauf1.max1().getTemperaturCelsius());
    }

    @Test
    void testMax2() throws Exception {
        temperaturVerlauf1.add(Temperatur.createFromCelsius(10));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(40));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(20));
        assertEquals(40, temperaturVerlauf1.max2().getTemperaturCelsius());
    }

    @Test
    @Disabled
    void testMax2NPE() throws Exception {
        final Exception e = assertThrows(NoSuchElementException.class, () -> {
            temperaturVerlauf1.max1();
        });
    }

    @Test
    void testMin() {
        temperaturVerlauf1.add(Temperatur.createFromCelsius(10));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(-40));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(-20));
        assertEquals(-40, temperaturVerlauf1.min().getTemperaturCelsius());
    }

    @Test
    void testMinNull() {
        temperaturVerlauf1.min();
    }

    @Test
    void testAverage() {
        temperaturVerlauf1.add(Temperatur.createFromCelsius(120));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(40));
        temperaturVerlauf1.add(Temperatur.createFromCelsius(20));
        assertEquals(60, temperaturVerlauf1.average().getTemperaturCelsius());
    }

    @Test
    void testAverageNull() {
        temperaturVerlauf1.average();
    }
}