package OOP.Programm;

import OOP.Klassen.DataCharStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DataCharStreamDemo {

    private static final Logger LOG = LogManager.getLogger(DataCharStream.class);

    public static void main(String[] args) {

        DataCharStream dataCharStream = new DataCharStream();
        dataCharStream.writeTextFileWithCharStream("CharStream");
        dataCharStream.readTextFileCharStream("CharStream");
    }
}
