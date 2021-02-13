package OOP.Klassen;

import java.util.EventObject;

public class TemperaturEvent extends EventObject {


    TemperaturExtrema newValue;


    public TemperaturEvent(Object source, TemperaturExtrema temperaturExtrema) {
        super(source); //source muss an Superkonstruktor weitergegeben werden, da dieser den Parameter verlangt.
        this.newValue = temperaturExtrema;
    }

    public TemperaturExtrema getNewValue() {
        return this.newValue;
    }
}
