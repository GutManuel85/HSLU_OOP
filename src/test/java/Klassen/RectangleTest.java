package Klassen;

import OOP.Klassen.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    Rectangle rectangleTest1;
    Rectangle rectangleTest2;


    @BeforeEach
    void setUp() {
        rectangleTest1 = new Rectangle(0, 0, 4, 3);
        rectangleTest2 = new Rectangle(1, 1, 5, 4);
    }

    @Test
    void Rectangle(){
        assertNotEquals(rectangleTest1,rectangleTest2);
    }

    @Test
    void getPerimeter() {
        assertEquals(14, rectangleTest1.getPerimeter());
    }

    @Test
    void getX() {
        assertEquals(0, rectangleTest1.getX());
    }

    @Test
    void getY() {
        assertEquals(0, rectangleTest1.getY());
    }

    @Test
    void getWidth() {
        assertEquals(4, rectangleTest1.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(3, rectangleTest1.getHeight());
    }

}