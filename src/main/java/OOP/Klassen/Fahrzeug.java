package OOP.Klassen;
/**
 * @author Manuel Gut
 * @version 1.0
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Klasse Fahzeug mit implementiertem Interface Switchable.
 */

public class Fahrzeug implements CountingSwitchable, PropertyChangeListener {

    /**
     * Klassenkonstante LOG vom Datentyp Logger.
     */
    private static final Logger LOG = LogManager.getLogger(Fahrzeug.class);

    /**
     * @attribut motor vom Datentyp Motor.
     */
    private Motor motor;

    /**
     * @attribut licht vom Datentyp Licht.
     */
    private Licht licht;

    /**
     * @attribut isSwitchedOn vom Datentyp boolean.
     */

    private StatusAnzeigeLampen statusAnzeigeLampen;

    private boolean isSwitchedOn;

    private long switchCount;

    private class MotorPropertyEvent implements PropertyChangeListener{
        @Override
        public void propertyChange(PropertyChangeEvent propertyChangeEvent){
            handleMotorEvent(propertyChangeEvent);
        }
    }


    /**
     * Konstruktor fuer die Fahrzeugklasse.
     *
     * @param anzahlGaenge beschreibt die Anzahl Gaenge.
     * @param anzahlPS     beschreibt die Anzahl PS.
     */

    public Fahrzeug(int anzahlGaenge, int anzahlPS) {

        this.motor = new Motor(anzahlGaenge, anzahlPS);
        this.licht = new Licht();
        this.isSwitchedOn = false;
        this.switchCount = 0;
        this.statusAnzeigeLampen = new StatusAnzeigeLampen();

        try {
            this.motor.addPropertyChangeListener(new Fahrzeug.MotorPropertyEvent()); //Hierdurch wird Fahrzeugobjekt zu den PropertyChangeListener hinzugefügt.Hier kann mit this ein Fahrzeugobjekt mitgegeben werden, obwohl die Methode einen formalen Parameter mit dem Datentyp PropertyChangeListener verlangt -> Grund: Fahrzeug implementiert das Interface PropertyChangeListener, wodurch sich Fahrzeug den Datentyp des Interfaces aneignet ("als Rolle") und darüber angesprochen werden kann.
            this.licht.addPropertyChangeListener(this);
        } catch (NullPointerException e) {
            LOG.error("ChangeListener war null - Fehler", e.getMessage(), e.getCause(), e.getStackTrace());
        }
    }

    /**
     * Methode um Fahrzeug und somit auch Motor und Licht einzuschalten.
     */

    @Override
    public void switchOn() {
        motor.switchOn();
        licht.switchOn();
        isSwitchedOn = true;
        switchCount++;
    }


    /**
     * Methode um Fahrzeug und somit auch Motor und Licht auszuschalten.
     */
    @Override
    public void switchOff() {
        motor.switchOff();
        motor.switchOff();
        isSwitchedOn = false;
    }

    /**
     * Methode um zu ueberpruefen, ob Fahrzeug eingeschaltet ist.
     *
     * @return boolean isSwichtchedOn.
     */
    @Override
    public boolean isSwitchedOn() {
        return isSwitchedOn;
    }

    /**
     * Methode um zu ueberpruefen, ob Fahrzeug ausgeschaltet ist.
     *
     * @return boolean !isSwitchedOn.
     */
    @Override
    public boolean isSwitchedOff() {
        return !isSwitchedOn;
    }

    /**
     * Methode um zu zaehlen, wie oft Fahrzeug schon eingeschaltet wurde.
     *
     * @return long switchCount.
     */
    @Override
    public long getSwitchCount() {
        return switchCount;
    }


    /**
     * Ueberschriebene Methode aus Interface PropertyChangeListener,
     * die je nach Quelle eine entsprechende Eventbehandlungsmethode aufruft.
     *
     * @param event vom Datentyp PropertyChangeEvent
     */
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getSource() == this.motor) { // hier soll == verwendet werden, da ja explizit auf Identität verglichen werden soll.
            this.handleMotorEvent(event);
        }
        if (event.getSource() == this.licht) {
            this.handleLichtEvent(event);
        }
    }

    public Motor getMotor() {
        return motor;
    }

    public Licht getLicht() {
        return licht;
    }

    public StatusAnzeigeLampen statusAnzeigeLampen(){
        return statusAnzeigeLampen;
    }

    private void handleMotorEvent(PropertyChangeEvent event) {
        if(event.getSource() == this.motor && event.getNewValue().equals(SwitchState.ON)){
            this.licht.switchOn();
            this.statusAnzeigeLampen.switchOnMotorAnzeige();
        }
    }

    private void handleLichtEvent(PropertyChangeEvent event) {
        if(event.getSource() == this.licht && event.getNewValue().equals(SwitchState.ON)){
            this.statusAnzeigeLampen.switchOnLichtAnzeige();
        }
    }
}
