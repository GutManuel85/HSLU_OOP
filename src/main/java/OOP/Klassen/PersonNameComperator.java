package OOP.Klassen;

import java.util.Comparator;

public class PersonNameComperator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int compare = person1.getNachname().compareTo(person2.getNachname());
        if (compare == 0) {
            compare = person1.getVorname().compareTo(person2.getVorname());
        }
        System.out.println("Der Comparewert ist: " + compare);
        return compare;
    }
}
