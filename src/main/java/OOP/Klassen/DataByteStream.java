package OOP.Klassen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class DataByteStream {

    private static Logger LOG = LogManager.getLogger(DataByteStream.class);


    public void writeByteStreamDouble(double doubleValue, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeDouble(doubleValue);
        } catch (IOException ioe) {
            LOG.error("Es ist ein Fehler aufgetreten!", ioe);
        }
    }

    public void writeByteStreamDoubleNotOverwriting(double doubleValue, String filename) {
        if (!(new File(filename).exists())) {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
                dos.writeDouble(doubleValue);
            } catch (IOException ioe) {
                LOG.error("Es ist ein Fehler aufgetreten!", ioe);
            }
        } else {
            System.out.println("File existiert bereits und kann nicht überschrieben werden");
        }
    }


    public void writeByteStreamInt(int intValue, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.write(intValue);
        } catch (IOException ioe) {
            LOG.error("Es ist ein Fehler augetreten!", ioe);
        }
    }

    public void writeByteStreamString(String stringValue, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeUTF(stringValue);
        } catch (IOException ioe) {
            LOG.error("Es ist ein Fehler augetreten!", ioe);
        }
    }

    public void writeByteStreamMixed(String stringValue, int intvalue, double doubleValue, String filename) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(filename))) {
            dos.writeUTF(stringValue);
            dos.write(intvalue);
            dos.writeDouble(doubleValue);
        } catch (IOException ioe) {
            LOG.error("Es ist ein Fehler augetreten!", ioe);
        }
    }


    public double readByteStreamDouble(String filename) throws FileNotFoundException {
        if (new File(filename).exists()) {
            try (final DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                final double value = dis.readDouble();
                System.out.println(value);
                return value;
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
                return 0.0;
            }
        } else {
            throw new FileNotFoundException("Kein entsprechendes File vorhanden");
        }
    }

    public int readByteStreamInt(String filename) throws FileNotFoundException {
        if (new File(filename).exists()) {
            try (final DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                final int value = dis.read();
                System.out.println(value);
                return value;
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
                return 0;
            }
        } else {
            throw new FileNotFoundException("Kein entsprechendes File vorhanden");
        }
    }

    public String readByteStreamString(String filename) throws FileNotFoundException {
        if (new File(filename).exists()) {
            try (final DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                final String value = dis.readUTF();
                System.out.println(value);
                return value;
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
                return null;
            }
        } else {
            throw new FileNotFoundException("Kein entsprechendes File vorhanden");
        }
    }

    public void readByteStreamMixed(String filename) throws FileNotFoundException {
        if (new File(filename).exists()) {
            try (final DataInputStream dis = new DataInputStream(new FileInputStream(filename))) {
                final String stringValue = dis.readUTF();
                final int intValue = dis.read();
                final double doubleValue = dis.readDouble();

                System.out.println(stringValue);
                System.out.println(intValue);
                System.out.println(doubleValue);
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe);
            }
        } else {
            throw new FileNotFoundException("Kein entsprechendes File vorhanden");
        }
    }
}

