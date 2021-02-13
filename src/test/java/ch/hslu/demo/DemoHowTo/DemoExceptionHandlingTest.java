package ch.hslu.demo.DemoHowTo;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DemoExceptionHandlingTest {

    private int int1;
    private int int2;
    private int result;
    private Scanner scan1 = new Scanner(System.in);

    @org.junit.Test
    public void addieren() {
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testSubtrahieren() {
    }

    @org.junit.Test(expected = IllegalArgumentException.class)
    public void testDividieren() {
        DemoExceptionHandling.dividieren(10,0);
    }
}