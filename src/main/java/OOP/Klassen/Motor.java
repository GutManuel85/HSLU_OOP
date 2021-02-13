package OOP.Klassen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Motor implements Switchable {

    public static final int STANDARD_GANG_ZAHL = 6;
    private static final Logger LOG = LogManager.getLogger(Motor.class); //Logger ist privat

    private int anzahlGaenge;
    private int anzahlPs;
    private int rpm;
    private int aktuellerGang;
    private boolean isSwitchedOn;
    private SwitchState state;

    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    public Motor(final int anzahlGaenge, final int anzahlPs) {
        this.anzahlGaenge = anzahlGaenge;
        this.anzahlPs = anzahlGaenge;
        this.rpm = 0;
        this.aktuellerGang = 1;
        this.isSwitchedOn = false;
        this.state = SwitchState.OFF;
    }

    /*Schaltet Motor ein.*/
    @Override
    public void switchOn() {
        if(isSwitchedOff()) {
            this.isSwitchedOn = true;
            this.rpm = 1000;
            this.state = SwitchState.ON;
            final PropertyChangeEvent pcEvent = new PropertyChangeEvent(this, "state", SwitchState.OFF,
                    SwitchState.ON);
            this.firePropertyChangeEvent(pcEvent);
        }
    }

    /*Schaltet Motor aus.*/
    @Override
    public void switchOff() {
        isSwitchedOn = false;
        rpm = 0;
    }

    /*Prüft, ob Motor eingeschaltet ist.*/
    @Override
    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    /*Prüft, ob Motor ausgeschaltet ist.*/
    @Override
    public boolean isSwitchedOff() {
        return !isSwitchedOn;
    }

    /*Verändert die Anzahl Ps um den Tunewert.*/
    public void tunen(int tunewert) {
        anzahlPs += tunewert;
    }

    /*Baut Motor in Automatenmotor um, der standardmässig 6 Gänge hat.*/
    public void umbauAutomat() {
        anzahlGaenge = STANDARD_GANG_ZAHL;
    }

    /*Schaltet in den nächst höheren Gang:*/
    public int gangHochSchalten() {
        aktuellerGang++;
        return aktuellerGang;
    }

    /*Schaltet in den nächst tieferen Gang:*/
    public int gangRunterSchalten() {
        aktuellerGang--;
        return aktuellerGang;
    }

    /**
     * Registrierung von Listener-Objekten. Fuegt Listener zu den changeListeners hinzu.
     *
     * @param listener
     */
    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        if (listener != null) {
            this.changeListeners.add(listener);
        } else {
            LOG.error("NullpointerException geworfen.");
            throw new NullPointerException();
        }
    }

        /**
         * Deregistrierung von Listener-Objekten. Entfernt Listener aus changeListeners.
         *
         * @param listener
         */
        public void removePropertyChangeListener ( final PropertyChangeListener listener){
            this.changeListeners.remove(listener);
        }

        /**
         * Prüft Gleichheit der Attribute.
         */
        @Override
        public boolean equals (Object object){
            if (this == object) {
                return true;
            }
            if (!(object instanceof Motor)) {
                return false;
            }
            final Motor other = (Motor) object;
            return (other.anzahlGaenge == this.anzahlGaenge) && (other.anzahlPs == this.anzahlPs);
        }

        /**
         * Errechnet Hashwert der Attribute anzahlGange und anzahlPS.
         */
        @Override
        public int hashCode () {
            return Objects.hash(this.anzahlGaenge, this.anzahlPs);
        }

        /**
         * Gibt einen Text mit Infos zu anzahlPs und anzahlGaenge zurück.
         *
         * @return String.
         */
        @Override
        public String toString () {
            return "Motor hat " + anzahlPs + " PS und " + anzahlGaenge + " " + this.getTextGang();
        }

        public boolean getIsSwitchedOn () {
            return isSwitchedOn;
        }

        public int getAnzahlGaenge () {
            return anzahlGaenge;
        }

        public int getAnzahlPs () {
            return anzahlPs;
        }

        public int getRpm () {
            return rpm;
        }

        public int getAktuellerGang () {
            return aktuellerGang;
        }

    public SwitchState getState() {
        return state;
    }

    private String getTextGang () {
            if (anzahlGaenge == 1) {
                return "Gang";
            } else {
                return "Gaenge";
            }
        }
/** Informiert alle PorperyChangeListener der ArrayList changeListeners über PropertyChangeEvent.
 *
 * @param propertyChangeEvent
 *
 * */
        private void firePropertyChangeEvent ( final PropertyChangeEvent propertyChangeEvent){
            for (PropertyChangeListener listener : this.changeListeners) { // Diese foreach-Schleife geht über alle listener (Datentyp PropertyChangeListener) der ArrayList changeListeners.
                listener.propertyChange(propertyChangeEvent);
            }
        }
    }
