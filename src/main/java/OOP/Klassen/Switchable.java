package OOP.Klassen;

/**
 * @author Manuel Gut
 * @version 1.0
 */

/**
 * Interface Switchable enthaelt Methoden zum An- und Ausschalten von Objekten und zum Ueberpruefen,
 * ob etwas an- oder ausgeschaltet ist.
 */


public interface Switchable {

    /**
     * Methode, um Objekt einzuschalten.
     *
     */
    void switchOn();

    /**
     * Methode, um Objekt auszuschalten.
     */
    void switchOff();

    /**
     * Methode, um zu überprüfen, ob ein Objekt eingeschaltet ist.
     *
     * @return boolean isSwitchedOn;
     *
     */
    boolean isSwitchedOn();

    /**
     * Methode, um zu überprüfen, ob ein Objekt ausgeschaltet ist.
     *
     * @return boolean !isSwitchedOn;
     *
     */
    boolean isSwitchedOff();
}
