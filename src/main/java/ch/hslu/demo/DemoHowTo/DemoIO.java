package ch.hslu.demo.DemoHowTo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class DemoIO {

    private static final Logger LOG = LogManager.getLogger(DemoIO.class);

    public static void main(String[] args) {

        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("DemoIOFile"))) {
            for (int i = 0; i < intArray.length; i++) {
                dos.write(intArray[i]);
            }
        } catch (IOException ioe) {
            LOG.error("Fehler bei der Ausgabe.");
        }

        try (DataInputStream dis = new DataInputStream(new FileInputStream("DemoIOFile"))) {
            double intValue;
            while((intValue = dis.read()) !=-1){
                System.out.println(intValue);
            }
        } catch (IOException ioe) {
            LOG.error("Fehler bei der Eingabe");
        }
    }
}
