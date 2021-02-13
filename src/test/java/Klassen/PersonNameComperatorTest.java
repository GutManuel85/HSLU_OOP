package Klassen;

import OOP.Klassen.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonNameComperatorTest {

    Person person1;
    Person person2;
    Person person3;
    Person person4;

    @BeforeEach
    void setUp() {
        this.person1 = new Person(100, "Meier", "Hans", 180);
        this.person2 = new Person(101, "Mustermann", "Bob", 170);
        this.person3 = new Person(101, "Mustermann", "Sepp", 170);
        this.person4 = new Person(101, "Mustermann", "Sepp", 170);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCompareFrueherInAlphabet() {
        assertTrue(person1.compareTo(person2)==-1);
    }

    @Test
    void testCompareSpaeterInAlphabet(){
        assertTrue(person2.compareTo(person1)==1);
    }

    @Test
    void testCompareVornameFrueherInAlphabet(){
        assertTrue(person2.compareTo(person3)<0);
    }

    @Test
    void testCompareGleicherNachnameUndVorname(){
        assertTrue(person3.compareTo(person4)==0);
    }
}