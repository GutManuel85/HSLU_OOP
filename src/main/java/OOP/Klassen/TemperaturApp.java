package OOP.Klassen;

import OOP.Programm.ExceptionHandlingProgramm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TemperaturApp implements TemperaturEventListener {

    private static final Logger LOG = LogManager.getLogger(ExceptionHandlingProgramm.class);
    public static int tempCounter = 0;

    public TemperaturApp() {
        Temperatur.temperaturVerlauf.addTemperaturEventListener(this);
    }


    public void eingebenTemperatur() {
        ArrayList<Temperatur> temperatursammlung = new ArrayList<>();
        tempCounter = 0;
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben ('exit' zum Beenden): ");
            input = scanner.next();
            try {
                double value = Double.valueOf(input);
                temperatursammlung.
                        add(tempCounter, Temperatur.createFromCelsius(value));
                tempCounter++;
            } catch (NumberFormatException e) {
                LOG.error(e.getMessage(), e.getCause(), e.getStackTrace());
                if (!input.equals("exit"))
                    System.out.println("Keine korrekte Temperatur eingegeben.");
            }
        } while (!input.equals("exit"));
        System.out.println("Programm beendet. Siehe Statistik");
        System.out.println("Die Maximaltemperatur ist: " + (Temperatur.temperaturVerlauf.getTempMax()));
        System.out.println("Die Minimaltemperatur ist: " + Temperatur.temperaturVerlauf.getTempMin());
        System.out.println("Die Durchschnittstemperatur ist: " + Temperatur.temperaturVerlauf.average());
        writeTemperaturenInFile(temperatursammlung, "Temps.dat");
        System.out.println("Unten die eingelesenen Temperaturwerte, die zuvor in File exportiert wurden:");
        try {
            readTemperaturenAusFile("Temps.dat");
        } catch (FileNotFoundException fnfe) {
            LOG.error("File wurde nicht gefunden", fnfe);
        }
        System.out.println();
    }

    public void writeTemperaturenInFile(ArrayList<Temperatur> arrayList, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeInt(tempCounter); //dieser Wert muss ganz am Anfang in die Datei geschrieben werden, damit man beim Lesen weiss, wie viele Doublewerte ausgelesen werden müssen. Den die readDouble-Methode gibt keinen -1 Wert zurück, wenn das File am Ende ist.
            for (int i = 0; i < arrayList.size(); i++) {
                dos.writeDouble(arrayList.get(i).getTemperaturCelsius());
                System.out.println("Eingegebene Temperatur: " + arrayList.get(i).getTemperaturCelsius());
            }
        } catch (IOException ioe) {
            LOG.error("Es ist ein Fehler augetreten!", ioe);
        }
    }

    public void readTemperaturenAusFile(String filename) throws FileNotFoundException {
        if (new File(filename).exists()) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                int tempCounterFile = dis.readInt();
                for(int i = tempCounterFile; i > 0; i--) {
                    double doubleValue = dis.readDouble();
                    System.out.println(doubleValue);
                }
            } catch (IOException ioe) {
                LOG.error("Es ist ein Fehler aufgetreten", ioe);
            }
        } else {
            throw new FileNotFoundException("Kein entsprechendes File vorhanden");
        }
    }


    @Override
    public void listenTemperaturEvent(TemperaturEvent temperaturEvent) {
        if (temperaturEvent.getNewValue().equals(TemperaturExtrema.MAXIMUM)) {
            handleTempChangeMaximum();
        }
        if (temperaturEvent.getNewValue().equals(TemperaturExtrema.MINIMUM)) {
            handleTempChangeMinimum();
        }
    }

    public void handleTempChangeMaximum() {
        System.out.println("Dies ist die neue Maximaltemperatur");
    }

    public void handleTempChangeMinimum() {
        System.out.println("Dies ist die neue Mimimaltemperatur");
    }


}






