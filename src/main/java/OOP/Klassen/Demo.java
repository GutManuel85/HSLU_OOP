package OOP.Klassen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

    private static final Logger LOG = LogManager.getLogger(Demo.class);

    public Demo() {
    }

    public int max1(final int a, final int b) {
        if (a >= b) {
            System.out.println(a);
            return a;
        } else {
            System.out.println(b);
            return b;
        }
    }

    public int max2(final int a, final int b, final int c) {
        if (a >= b && a >= c) {
            System.out.println(a);
            return a;
        } else if (b >= c) {
            System.out.println(b);
            return b;
        } else {
            System.out.println(c);
            return c;
        }
    }

    public int max3(final int a, final int b, final int c) { //mit Wiederverwendung der Methode max1
        if (c >= max1(a, b)) {
            System.out.println(c);
            return c;
        } else {
            System.out.println(max1(a, b));
            return (max1(a, b));

        }
    }

    public int max4(final int a, final int b, final int c) {
        return Integer.max(Integer.max(a, b), Integer.max(a, c));
    }

    public int min(final int a, final int b) {
        if (a <= b) {
            System.out.println(a);
            return a;
        } else {
            System.out.println(b);
            return b;
        }
    }

    public void zaehlen1Bis10ForSchleife() {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public void zaehlen1Bis10WhileSchleife() {
        int i = 0;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    public void zaehlen1Bis10DoWhileSchleife() {
        int i = 0;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);
    }

    public void hochAddieren() {
        float f = 0.9f;
        int counter = 0;
        while (f < 1f) {
            f += 0.000025f;
            counter++;
            System.out.println(f);
        }
        LOG.info("Es wurde " + counter + " mal addiert");
    }

    public void hochAddieren4000Mal() {
        float f = 0.9f;
        for (int i = 0; i != 4000; i++) {
            f += 0.000025f;
        }
        System.out.println("Der Wert nach 4000 Additionen ist " + f);
    }

    public void printBox(final int height, final int width) {
        char zeichen = '#';
        char leerzeichen = ' ';
        for (int i = 0; i < width; i++) {
            System.out.print(zeichen);
        }
        System.out.println();
        for (int j = 1; j < height - 1; j++) {
            System.out.print(zeichen);
            for (int k = 1; k < width - 1; k++) {
                System.out.print(leerzeichen);
            }
            System.out.println(zeichen);
        }
        for (int i = 0; i < width; i++) {
            System.out.print(zeichen);
        }
    }

    public void printSchweizerkreuz(int oberkantenbreite) {
        char zeichen = '#';
        char leerzeichen = ' ';
        for (int h = 0; h < oberkantenbreite; h++) { //generiert oberes Drittel
            for (int i = 0; i < oberkantenbreite; i++) {
                System.out.print(leerzeichen);
            }
            for (int j = 0; j < oberkantenbreite; j++) {
                System.out.print(zeichen);
            }
            for (int i = 0; i < oberkantenbreite; i++) {
                System.out.print(leerzeichen);
            }
            System.out.println();
        }
        for (int h = 0; h < oberkantenbreite; h++) { //generiert mittleres Drittel

            for (int j = 0; j < 3 * oberkantenbreite; j++) {
                System.out.print(zeichen);
            }
            System.out.println();
        }
        for (int h = 0; h < oberkantenbreite; h++) { //generiert unteres Drittel
            for (int i = 0; i < oberkantenbreite; i++) {
                System.out.print(leerzeichen);
            }
            for (int j = 0; j < oberkantenbreite; j++) {
                System.out.print(zeichen);
            }
            for (int i = 0; i < oberkantenbreite; i++) {
                System.out.print(leerzeichen);
            }
            System.out.println();
        }
    }
}
