package OOP.Klassen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.Charset;

public class DataCharStream {

    private static final Logger LOG = LogManager.getLogger(DataCharStream.class);

    public void writeTextFileWithCharStream(final String file) {
        try (PrintWriter pw =
                     new PrintWriter(new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(file), Charset.forName("UTF-8"))));
        ) {
            pw.println("Euro € und Umlaute äöü-alles da!");
            pw.println("Plattformunabhängig fix mit UTF-8 encodiert!");
            pw.flush();
        } catch (IOException ioe) {
            LOG.error(ioe.getMessage(), ioe);
        }
    }

    public void readTextFileCharStream(final String file) {
        String line;
        if (new File(file).exists()) {
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(
                            new FileInputStream(file), Charset.forName("UTF-8")))) {
                while ((line = br.readLine()) != null) { //prüft, ob in der Linie Zeichen vorhanden sind. Falls ja, wird die Linie auf Konsole ausgegeben.
                    System.out.println(line);
                }
                System.out.println(line);
            } catch (IOException ioe) {
                LOG.error(ioe.getMessage(), ioe.getCause(), ioe.getStackTrace());
            }
        }
    }
}
