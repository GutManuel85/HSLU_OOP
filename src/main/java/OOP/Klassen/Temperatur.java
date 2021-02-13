package OOP.Klassen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;
import java.util.Scanner;

public final class Temperatur implements Comparable<Temperatur> {

    public static final double UMRECHNUNGSKONSTANTE_CELSIUS_IN_KELVIN = 273.15d;
    public static final String UNERLAUBTE_TEMPERATUR = "Temperatureingabe ist tiefer als der absolute Nullpunkt.";
    private static final Logger LOG = LogManager.getLogger(Temperatur.class); //Logger ist privat
    public static Scanner scanner = new Scanner(System.in);
    public static TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();

    private double temperaturCelsius; //durch das final wird Objekt nun zum immutable Object.

    /**
     * Privater Konstruktor für Klasse Temperatur. Privat, da es öffentliche, statische Factory-Methoden gibt,
     * über die auf Konstruktor zugegriffen wird.
     */
    private Temperatur(double temperaturCelsius) //"throws IllegalArgumentException" muss hier nicht geschrieben werden, da IllegalArgumentException eine unchecked Exception ist
    {
        if (temperaturCelsius >= -273.15d) {
            this.temperaturCelsius = temperaturCelsius;
            temperaturVerlauf.add(this);
        } else throw new IllegalArgumentException(UNERLAUBTE_TEMPERATUR);
    }

    @Deprecated
    public Temperatur(double temperatur, TemperaturEinheiten temperaturEinheiten) {
        switch (temperaturEinheiten) {
            case CELSIUS:
                if (temperatur >= -273.15d) {
                    this.temperaturCelsius = temperatur;
                    break;
                } else {
                    throw new IllegalArgumentException(UNERLAUBTE_TEMPERATUR);
                }
            case KELVIN:
                if (temperatur >= 0.00d) {
                    this.temperaturCelsius = temperatur - UMRECHNUNGSKONSTANTE_CELSIUS_IN_KELVIN;
                    break;
                } else {
                    throw new IllegalArgumentException(UNERLAUBTE_TEMPERATUR);
                }
            case FAHRENHEIT:
                if (temperatur >= -459.67) {
                    this.temperaturCelsius = temperatur * 1.8d + 32d;
                    break;
                } else {
                    throw new IllegalArgumentException(UNERLAUBTE_TEMPERATUR);
                }
        }
    }

    public double getTemperaturCelsius() {
        return temperaturCelsius;
    }

    public double changeTempCelsius(final double changeCelsius) {
        return temperaturCelsius + changeCelsius;
    }

    public double changeTempKelvin(final double changeKelvin) {
        return temperaturCelsius + UMRECHNUNGSKONSTANTE_CELSIUS_IN_KELVIN + changeKelvin;
    }

    public double changeTempFahrenheit(final double changeFahrenheit) {
        return temperaturCelsius * 1.8d + 32d - changeFahrenheit;
    }

    @Deprecated
    public Aggregatszustand ermittleAggregatszustand(String element) { //hier braucht es kein "break;", da dies automatisch durch"return" ausgelöst wird. Brauchts nur bei Methode vom Datentyp "void"
        switch (element) {
            case "N":
                if (temperaturCelsius >= -195.8d) {
                    return Aggregatszustand.GAS;
                } else if (temperaturCelsius < -210d) {
                    return Aggregatszustand.SOLID;
                } else {
                    return Aggregatszustand.LIQUID;
                }
            case "Hg":
                if (temperaturCelsius >= 356.7d) {
                    return Aggregatszustand.GAS;
                } else if (temperaturCelsius < -38.83d) {
                    return Aggregatszustand.SOLID;
                } else {
                    return Aggregatszustand.LIQUID;
                }
            case "Pb":
                if (temperaturCelsius >= 1744.0d) {
                    return Aggregatszustand.GAS;
                } else if (temperaturCelsius < 327.4d) {
                    return Aggregatszustand.SOLID;
                } else {
                    return Aggregatszustand.LIQUID;
                }
            default:
                System.out.println("Element ist nicht bekannt: -> unbekannt");
                return null;
        }

    }

    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Temperatur)) {
            return false;
        }
        final Temperatur other = (Temperatur) object;
        return (this.temperaturCelsius == other.temperaturCelsius);
    }

    @Override
    public final String toString() {
        return String.valueOf(temperaturCelsius);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.temperaturCelsius);
    }

    @Override
    public int compareTo(Temperatur other) {
        return Double.compare(this.getTemperaturCelsius(), other.getTemperaturCelsius());
    }

    public static final double umrechnenInKelvin(double temperaturCelsius) {
        return temperaturCelsius + UMRECHNUNGSKONSTANTE_CELSIUS_IN_KELVIN;
    }

    public static final double umrechnenInFahrenheit(double temperaturCelsius) {
        return temperaturCelsius * 1.8d + 32d;
    }

    public static final Temperatur createFromCelsius(final double celsius) { //Factory-Methoden sind ein Entwurfsmuster der GoF. Mehr dazu im Modul VSK im 3. Semester.
        try {
            return new Temperatur(celsius);
        } catch (IllegalArgumentException e) { //Exception aus Konstruktor der Temperaturklasse wurde geworfen und in Methode createFromCelsius() wieder gefangen.
            LOG.error(e.getMessage(), e.getCause(), e.getStackTrace());
            throw e;
        }
    }

    public static final Temperatur createFromKelvin(final double kelvin) { //Factory-Methoden sind ein Entwurfsmuster der GoF. Mehr dazu im Modul VSK im 3. Semester.
            return createFromCelsius((
                    (kelvin - UMRECHNUNGSKONSTANTE_CELSIUS_IN_KELVIN) * 100) / 100.0); //muss gerundet werden, da ansonsten aufgrund vom Rechnen im Binärsystem nur eine Approximation gemacht werden kann und der errechnete Wert nicht mit dem genauen Sollwert übereinstimmt.

    }

}



