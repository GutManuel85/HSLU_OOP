package OOP.Programm;

import OOP.Klassen.DataByteStream;

import java.io.FileNotFoundException;

public class DataByteStreamDemo {

    public static void main(String[] args) {

        DataByteStream dataByteStream = new DataByteStream();

        dataByteStream.writeByteStreamMixed("Hallo Welt", 1, 2.0, "ByteStream");
        try {
            dataByteStream.readByteStreamMixed("ByteStream");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
