package Klassen;

import OOP.Klassen.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    Point point1;
    Point point2;


    @BeforeEach
    void setUp() {
        point1 = new Point(0, 0);
        point2 = new Point(1,1);
    }


    @Test
    void bestimmeQuadrant() {
    }

    @Test
    void moveRelative() {
    }

    @Test
    void moveRelative1() {
    }

    @Test
    void moveRelative2() {
        point1.moveRelative(90d, 100);
        assertEquals(0, point1.getX());
        assertEquals(100, point1.getY());
        point1.setX(0);
        point1.setY(0);
        point1.moveRelative(0d, 100);
        assertEquals(100, point1.getX());
        assertEquals(0, point1.getY());
    }

    @Test
    void equalsTrue(){
        assertEquals(point1, point1);
    }

    @Test
    void equalsFalse(){
        assertNotEquals(point1, point2);
    }

    @Test
    void hashCodeSame(){
        assertEquals(point1.hashCode(), point1.hashCode());
    }

    @Test
    void hashCodeOther(){
        assertNotEquals(point1.hashCode(), point2.hashCode());
    }

}