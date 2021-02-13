package ch.hslu.demo.DemoHowTo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DemoExceptionHandling {

    private static int int1;
    private static int int2;
    private static int result;
    private static Scanner scanner1 = new Scanner(System.in);


    public static void addieren() {
        try {
            int1 = scanner1.nextInt();
            int2 = scanner1.nextInt();
            result = int1 + int2;
            System.out.println(result);
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
            System.out.println(e.getStackTrace());
            System.out.println("Geben Sie einen korrekten Zahlenwert ein");
            scanner1 = new Scanner(System.in);
            addieren();
        }
    }

    public static void subtrahieren() {
        try {
            int1 = Integer.parseInt(scanner1.next());
            int2 = Integer.parseInt(scanner1.next());
            result = int1 - int2;
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Geben Sie einen korrekten Zahlenwert ein");
            scanner1 = new Scanner(System.in);
            subtrahieren();
        }
    }
    public static void dividieren(int int1, int int2){
        try {
            if (int2 != 0) {
                result = int1 / int2;
                System.out.println(result);
            } else {
                throw new IllegalArgumentException();
            }
        }catch(AssertionError e){
            e.getMessage();
            e.getCause();
            e.getStackTrace();
            System.out.println("Division durch 0 ist nicht erlaubt. " +
                    "Bitte korrekten Zahlenwert eingeben");
        }
    }

    public static void main(String[] args) {
        dividieren(10,10);
        addieren();
        subtrahieren();

    }

}
