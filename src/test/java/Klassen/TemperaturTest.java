package Klassen;

import OOP.Klassen.Temperatur;
import OOP.Klassen.TemperaturEinheiten;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperaturTest {

    Temperatur temp1;
    Temperatur temp2;
    Temperatur temp3;
    Temperatur temp4;

    @BeforeEach
    void setUp() {
        temp1 = Temperatur.createFromCelsius(0);
        temp2 = Temperatur.createFromCelsius(20);
        temp3 = Temperatur.createFromCelsius(30);
        temp4 = Temperatur.createFromCelsius(0);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testEquals() {
        assertEquals(temp1, temp1);
    }

    @Test
    void testHashCode() {
        assertEquals(temp1.hashCode(), temp4.hashCode());
    }

    @Test
    void testCompareToSmallerThan() {
        assertTrue(temp1.compareTo(temp2) == -1);
    }

    @Test
    void testCompareToBiggerThan() {
        assertTrue(temp3.compareTo(temp2) == 1);
    }

    @Test
    void testCompareToAsBigAs() {
        assertTrue(temp1.compareTo(temp4) == 0);
    }

    @Test
    void testUmrechnenInKelvinMinTemp() {
        assertEquals(0, Temperatur.umrechnenInKelvin(-273.15d));
    }

    @Test
    void testUmrechnenInKelvin0() {
        assertEquals(273.15d, Temperatur.umrechnenInKelvin(0.0d));
    }

    @Test
    void testUmrechnenInFahrenheitMinTemp() {
        assertEquals(-459.67d,
                Math.round(Temperatur.umrechnenInFahrenheit(-273.15d) * 100) / 100.0);
    }

    @Test
    void testCreateFromCelsius0() {
        Temperatur temp5 = Temperatur.createFromCelsius(0);
        Temperatur temp6 = Temperatur.createFromCelsius(20);
        assertEquals(0, temp5.getTemperaturCelsius());
        assertEquals(20, temp6.getTemperaturCelsius());
    }

    @Test
    void testCreateFromKelvin() {
        Temperatur temp5 = Temperatur.createFromKelvin(Temperatur.UMRECHNUNGSKONSTANTE_CELSIUS_IN_KELVIN);
        assertEquals(0, temp5.getTemperaturCelsius(),0.001);
        Temperatur temp6 = Temperatur.createFromKelvin(400);
        assertEquals(126.85, temp6.getTemperaturCelsius(), 0.001);
    }

    @Test
    void testFactoryMethodeFromCelsiusUnerlaubteTempJUnit5() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Temperatur.createFromCelsius(-274);
        });
        assertEquals(Temperatur.UNERLAUBTE_TEMPERATUR, e.getMessage());
    }

    @Test
    void testFactoryMethodeFromKelvinUnerlaubteTempJUnit5() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Temperatur.createFromKelvin(-1);
        });
        assertEquals(Temperatur.UNERLAUBTE_TEMPERATUR, e.getMessage());
    }

    @Test
    void testFactoryMethodeFromKelvinUnerlaubteTempFalscheMessageJUnit5() {
        final Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Temperatur.createFromKelvin(-1);
        });
        assertNotEquals(Temperatur.UNERLAUBTE_TEMPERATUR + "falscheMessageErgänzung", e.getMessage());
    }

    @Test
    @Deprecated
    void testKonstruktorParameternDoubleParameterTemperaturEinheitKelvin() {
        Temperatur temperatur5 = new Temperatur(10, TemperaturEinheiten.KELVIN);
        assertEquals(10, Temperatur.umrechnenInKelvin(temperatur5.getTemperaturCelsius()));
    }
}