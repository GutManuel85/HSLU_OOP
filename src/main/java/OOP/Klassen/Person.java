package OOP.Klassen;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private final long id;
    private String nachname;
    private String vorname;
    private int groesse;

    public Person(final long id, final String nachname, final String vorname, int groesse) {
        this.id = id;
        this.nachname = nachname;
        this.vorname = vorname;
        this.groesse = groesse;
    }

    @Override
    public String toString() {
        return "Die Person heisst: " + this.getNachname() + " / " + this.getVorname();
    }

    @Override
    public final boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        final Person other = (Person) object;
        return (this.id == other.id) &&
                (this.nachname.equals(other.nachname)) &&
                (this.vorname.equals(other.vorname)) &&
                (this.groesse == other.groesse);
    }

    @Override
    public final int hashCode() { //Die Methode hashCode() der Klasse Objects liefert den Hashcode aller mitgegebenen Attribute.
        return Objects.hash(this.id, this.nachname, this.vorname, this.groesse);
    }

//    @Override
//    public int compareTo(Person other){
//        return Long.compare(this.id, other.id);
//    }

    public int compareTo(Person other) { /*Überschreibt Methode compareTo aus Interface Comparable indem sie die Methode
        compare() der Klasse PersoneNameComperator benutzt, welche Personen alphabetisch nach Nachname und Vorname
        vergleicht und negative, positive oder 0 Werte zuweist.*/
        PersonNameComperator pnc = new PersonNameComperator();
        if (pnc.compare(this, other) > 0) {
            return 1;
        } else if (pnc.compare(this, other) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public long getId() {
        return id;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }
}
