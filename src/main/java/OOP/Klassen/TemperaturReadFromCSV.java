package OOP.Klassen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TemperaturReadFromCSV {

    private static final Logger LOG = LogManager.getLogger(TemperaturReadFromCSV.class);


    public void read(String filename) {
        if (new File(filename).exists()) {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), Charset.forName("UTF-8")))) {
                String line;
                MesspunkteVerlauf messpunkteVerlauf = new MesspunkteVerlauf();
                TemperaturVerlauf temperaturVerlauf = new TemperaturVerlauf();
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(";"); //Splittet String auf mit Trennzeichen ; und weist die einzelnen Strings dem Array zu
                    int id = Integer.parseInt(parts[0]);
                    LocalDateTime timestamp = LocalDateTime.parse(parts[1], DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"));
                    double tempValue  = Double.parseDouble(parts[2]);
                    int humidity = Integer.parseInt(parts[3]);
                    System.out.print(timestamp + " / ");
                    System.out.println(tempValue);
                    Temperatur temperatur = Temperatur.createFromCelsius(tempValue);
                    messpunkteVerlauf.addMesspunkt(timestamp, temperatur);
                    temperaturVerlauf.add(temperatur);
                }
                System.out.println("Die höchste gemessene Temperatur war " + messpunkteVerlauf.getMaxTemperaturCelsius().getValue());
                System.out.println("Die tiefste gemessene Temperatur war " + messpunkteVerlauf.getMinTemperaturCelsius().getValue());
                System.out.println("Die durchschnittstemperatur ist " + temperaturVerlauf.average());
                System.out.println("Die höchste Temperatur wurde am "+ messpunkteVerlauf.getMaxTemperaturCelsius().getKey()+ " gemessen.");
                System.out.println("Die tiefeste Temperatur wurde am "+ messpunkteVerlauf.getMinTemperaturCelsius().getKey() + "gemessen.");
            } catch (IOException ioe) {
                LOG.error("Fehler beim Einlesen aus CSV-Datei", ioe.getMessage(),
                        ioe.getCause(), ioe.getStackTrace());

            }
        }

    }

}
