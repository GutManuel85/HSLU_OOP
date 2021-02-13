package OOP.Klassen;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class Licht implements Switchable {

    public static final int ABLENDLICHT_LUMEN = 1000;

    private boolean isSwitchedOn;
    private int lumen;

    private List<PropertyChangeListener> changeListeners = new ArrayList<>();


    public Licht() {
        this.isSwitchedOn = false;
        this.lumen = 0;
    }

    @Override
    public void switchOn() {
        isSwitchedOn = true;
        lumen = ABLENDLICHT_LUMEN;
        PropertyChangeEvent propertyChangeEvent = new PropertyChangeEvent
                (this,"Licht",SwitchState.OFF, SwitchState.ON);
        firePropertyChangeEvent(propertyChangeEvent);
    }

    @Override
    public void switchOff() {
        isSwitchedOn = false;
        lumen = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return !isSwitchedOn;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeListeners.add(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeListeners.remove(listener);
    }

    private void firePropertyChangeEvent(PropertyChangeEvent propertyChangeEvent){
        for(PropertyChangeListener listener : this.changeListeners){
            listener.propertyChange(propertyChangeEvent);
        }
    }
}
