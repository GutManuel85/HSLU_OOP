package OOP.Programm;

import OOP.Klassen.Temperatur;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;

public class ExceptionHandlingProgramm {

    private static final Logger LOG = LogManager.getLogger(ExceptionHandlingProgramm.class);

    public static void main(String[] args) {
        eingebenTemperatur();
    }

    public static void eingebenTemperatur() {
        String input = null;
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
                input = scanner.next();
                float value = Float.valueOf(input);
                System.out.println(value);
            } while (!input.equals("exit"));
        } catch (NumberFormatException e) {
            if (input.equals("exit")) {
                System.out.println("Programm beendet.");
            } else {
                System.out.println("Keine korrekte Temperatur eingegeben.");
                eingebenTemperatur();
            }
        }
    }

    public static void uebermittelnTemperatur(Temperatur temperatur) {
        Temperatur input = temperatur;
    }
}
