package OOP.Klassen;

import java.util.Objects;

public class Blei extends Element {

    public static final String ELEMENTNAME = "Blei";
    public static final String CHEMISCHESSYMBOL = "Pb";
    public static final double SCHMELZPUNKT = 327.4d;
    public static final double SIEDPUNKT = 1744.0d;

    public Blei(final double temperaturCelsisus) {
        super(temperaturCelsisus, SCHMELZPUNKT, SIEDPUNKT, ELEMENTNAME, CHEMISCHESSYMBOL);
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Blei)) {
            return false;
        }
        final Blei other = (Blei) object;
        return (this.ermittleAggregatszustand().equals(other.ermittleAggregatszustand()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(ermittleAggregatszustand());
    }
}
