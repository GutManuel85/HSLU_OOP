package OOP.Klassen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


public class TemperaturVerlauf {


    private ArrayList<Temperatur> verlaufArray; //hier besser als statischen Typ Collection oder List verwenden, denn das sind Interfaces und somit flexibler
    private int verlaufArrayCounter;
    private double tempMax;
    private double tempMin;

    private static final Logger LOG = LogManager.getLogger(TemperaturVerlauf.class);

    private final List<TemperaturEventListener> changeListeners = new ArrayList<>();


    public TemperaturVerlauf() {
        this.verlaufArray = new ArrayList<>();
        this.verlaufArrayCounter = 0;
    }

    public ArrayList<Temperatur> getVerlaufArray() {
        return verlaufArray;
    }

    public void setVerlaufArray(ArrayList<Temperatur> verlaufArray) {
        this.verlaufArray = verlaufArray;
    }

    public void add(Temperatur temperaturCelsius) {
        verlaufArray.add(verlaufArrayCounter, temperaturCelsius);
        verlaufArrayCounter++;
        TemperaturEvent temperaturEventMax = new TemperaturEvent(this, TemperaturExtrema.MAXIMUM);
        TemperaturEvent temperaturEventMin = new TemperaturEvent(this, TemperaturExtrema.MINIMUM);
        if (verlaufArrayCounter == 1) {
            tempMax = temperaturCelsius.getTemperaturCelsius();
            fireTemperaturEvent(temperaturEventMax);
            tempMin = temperaturCelsius.getTemperaturCelsius();
            fireTemperaturEvent(temperaturEventMin);
        } else if (temperaturCelsius.getTemperaturCelsius() > tempMax) {
            tempMax = temperaturCelsius.getTemperaturCelsius();
            fireTemperaturEvent(temperaturEventMax);
        } else if (temperaturCelsius.getTemperaturCelsius() < tempMin) {
            tempMin = temperaturCelsius.getTemperaturCelsius();
            fireTemperaturEvent(temperaturEventMin);
        }
    }

    public void clear() {
        verlaufArray.clear();
    }

    public int getCount() {
        return verlaufArray.size();
    }

    public Temperatur average() {
        if (verlaufArray.size() > 0) {
            double gesamtSumme = 0;
            for (Iterator<Temperatur> iterator = verlaufArray.iterator(); iterator.hasNext(); ) {
                gesamtSumme += iterator.next().getTemperaturCelsius();
            }
            return Temperatur.createFromCelsius(gesamtSumme / verlaufArray.size());
        } else {
            System.out.println("Im Temperaturverlauf ist noch keine Temperatur vorhanden");
            return null;
        }
    }

    public int getVerlaufArrayCounter() {
        return verlaufArrayCounter;
    }

    public void addTemperaturEventListener(TemperaturEventListener temperaturEventListener) {
        if (temperaturEventListener != null) {
            changeListeners.add(temperaturEventListener);
        } else {
            LOG.error("NullPointer Exception geworfen, da Listener null nicht hinzugefügt werden kann.");
            throw new NullPointerException("Listener null kann nicht hinzugefügt werden");
        }
    }

    public void removeTemperaturEventListener(TemperaturEventListener temperaturEventListener) {
        changeListeners.remove(temperaturEventListener);
    }

    private void fireTemperaturEvent(TemperaturEvent temperaturEvent) {
        for (TemperaturEventListener temperaturEventListener : this.changeListeners) {
            temperaturEventListener.listenTemperaturEvent(temperaturEvent);
        }
    }

    public double getTempMax() {
        return tempMax;
    }

    public double getTempMin() {
        return tempMin;
    }

    @Deprecated
    public Temperatur max1() throws NoSuchElementException { //Methode mit ForEachschleife
        Iterator<Temperatur> iterator = verlaufArray.iterator();
        try {
            Temperatur maxTemp = iterator.next();
            for (Temperatur temperatur : verlaufArray) {
                if (temperatur.getTemperaturCelsius() > maxTemp.getTemperaturCelsius()) {
                    maxTemp = temperatur;
                }
            }
            return maxTemp;
        } catch (NoSuchElementException e) {
            System.out.println("Im Temperaturverlauf ist noch keine Temperatur vorhanden");
            LOG.error(e.getMessage(), e.getCause(), e.getStackTrace());
            return null;

        }
    }

    @Deprecated
    public Temperatur max2() throws NoSuchElementException { //Methode mit Iterator
        Iterator<Temperatur> iterator = verlaufArray.iterator();
        Temperatur maxTemp = null;
        Temperatur cursorTemp;
        try {
            cursorTemp = iterator.next(); //zeigt die aktuell gewählte Temperatur in Collection
            maxTemp = cursorTemp; //zeigt die aktuell grösste Temperatur aller bereits durchiterierten Temperaturen
        } catch (NoSuchElementException e) {
            System.out.println("Im Temperaturverlauf ist noch keine Temperatur vorhanden");
        }
        while (iterator.hasNext()) {
            cursorTemp = iterator.next();
            if (cursorTemp.getTemperaturCelsius() > maxTemp.getTemperaturCelsius()) {
                maxTemp = cursorTemp;
            }
        }
        return maxTemp;
    }


    @Deprecated
    public Temperatur min() { //Methode ohne Iterator und direktem Verweis auf Index des Arrays. Nachteil hier: Der Collectiontyp kann nicht frei angepasst werden, ohne dass Methode angepasst werden muss.

        Temperatur minTemp;
        if (verlaufArray.size() > 0) {
            minTemp = verlaufArray.get(0);
            for (int i = 0; i < verlaufArray.size(); i++) {
                if (verlaufArray.get(i).getTemperaturCelsius() < minTemp.getTemperaturCelsius()) {
                    minTemp = verlaufArray.get(i);
                }
            }
        } else {
            System.out.println("Im Temperaturverlauf ist noch keine Temperatur vorhanden");
            minTemp = null;
        }
        return minTemp;

    }


}


