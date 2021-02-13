package OOP.Klassen;

import java.util.Objects;

public class Stickstoff extends Element {

    public static final String ELEMENTNAME = "Stickstoff";
    public static final String CHEMISCHESSYMBOL = "N";
    public static final double SCHMELZPUNKT = -210d;
    public static final double SIEDEPUNKT = -195.8d;

    public Stickstoff(final double temperaturCelsisus) {
        super(temperaturCelsisus, SCHMELZPUNKT, SIEDEPUNKT, ELEMENTNAME, CHEMISCHESSYMBOL);
    }

    @Override
    public Aggregatszustand ermittleAggregatszustand() {
        if (super.getTemperaturCelsius() >= SIEDEPUNKT) {
            return Aggregatszustand.GAS;
        } else if (super.getTemperaturCelsius() < SCHMELZPUNKT) {
            return Aggregatszustand.SOLID;
        } else {
            return Aggregatszustand.LIQUID;
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Stickstoff)) {
            return false;
        }
        Stickstoff other = (Stickstoff) object;
        return (other.ermittleAggregatszustand().equals(this.ermittleAggregatszustand()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(ermittleAggregatszustand());
    }

    public String getInfoElement() {
        return null;
    }
}
