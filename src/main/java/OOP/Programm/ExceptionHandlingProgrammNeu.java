package OOP.Programm;

import OOP.Klassen.Temperatur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ExceptionHandlingProgrammNeu {

    private static final Logger LOG = LogManager.getLogger(ExceptionHandlingProgramm.class);

    public static void main(String[] args) {
        eingebenTemperatur();
    }

    public static void eingebenTemperatur() {
        String input;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            try {
                double value = Double.valueOf(input);
                Temperatur.createFromCelsius(value);
            } catch (NumberFormatException e) {
                LOG.error(e.getMessage(), e.getCause(), e.getStackTrace());
                if (!input.equals("exit"))
                    System.out.println("Keine korrekte Temperatur eingegeben.");
            }
        } while (!input.equals("exit"));
        System.out.println("Programm beendet. Siehe Statistik");
        System.out.println("Die Maximaltemperatur ist: " + Temperatur.temperaturVerlauf.max1());
        System.out.println("Die Minimaltemperatur ist: " + Temperatur.temperaturVerlauf.min());
        System.out.println("Die Durchschnittstemperatur ist: " + Temperatur.temperaturVerlauf.average());
    }

}




