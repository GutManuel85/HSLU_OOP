package OOP.Klassen;

import java.util.Objects;

public class Quecksilber extends Element {

    public static final String ELEMENTNAME = "Quecksilber";
    public static final String CHEMISCHESSYMBOL = "Hg";
    public static final double SCHMELZPUNKT = -38.83d;
    public static final double SIEDEPUNKT = 356.7d;

    public Quecksilber(final double temperaturCelsisus) {
        super(temperaturCelsisus,SCHMELZPUNKT,SIEDEPUNKT, ELEMENTNAME, CHEMISCHESSYMBOL );
    }

    @Override
    public String toString() {
        return super.toString() + "Warnhinweis: GIFTIG";
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Quecksilber)) {
            return false;
        }
        Quecksilber other = (Quecksilber) object;
        return (other.ermittleAggregatszustand()).equals(this.ermittleAggregatszustand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ermittleAggregatszustand());
    }
}
