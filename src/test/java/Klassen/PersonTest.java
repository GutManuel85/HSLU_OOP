package Klassen;

import OOP.Klassen.Person;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest{

    Person person1;
    Person person2;
    Person person3;

    @BeforeEach
    void setUp() {
        this.person1 = new Person(100, "Alpha", "Alfred", 180);
        this.person2 = new Person(101, "Mustermann", "Bob", 170);
        this.person3 = new Person(101, "Mustermann", "Bob", 170);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void konstruktorId() {
        System.out.println(person1.getId());
        assertEquals(100, person1.getId());
    }

    @Test
    void konstruktorNachname() {
        assertEquals("Alpha", person1.getNachname());
    }

    @Test
    void konstruktorVorname() {
        assertEquals("Alfred", person1.getVorname());
    }

    @Test
    void konstruktorGroesse() {
        assertEquals(180, person1.getGroesse());
    }

    @Test
    void testToString() {
        assertEquals("Die Person heisst: Alpha / Alfred", person1.toString());
    }

    @Test
    void testMethodeMitEqualsVerifier() { // mit suppress werden die Warnungen unterdrückt: siehe hier https://jqno.nl/equalsverifier/errormessages/
        EqualsVerifier.forClass(Person.class).suppress(Warning.NULL_FIELDS, Warning.NONFINAL_FIELDS).verify();
    }

    @Test
    void testGleichheitSameObject() {
        assertEquals(person1, person1);
    }

    @Test
    void testGleichheitOtherObject() {
        assertNotEquals(person1, person2);
    }

    @Test
    void testGleichheitSameAttributs() {
        assertEquals(person2, person3);
    }

    @Test
    void testHashCodeSameObject() {
        assertEquals(person1.hashCode(), person1.hashCode());
    }

    @Test
    void testHashCodeSameAttributs() {
        assertEquals(person2.hashCode(), person3.hashCode());
    }

    @Test
    void testHashCodeOtherObject() {
        assertNotEquals(person1.hashCode(), person2.hashCode());
    }

    @Test
    void testCompareTo() {
        assertTrue(person1.compareTo(person2)==-1);
    }
 }
