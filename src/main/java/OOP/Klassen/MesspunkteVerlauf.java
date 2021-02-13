package OOP.Klassen;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

public class MesspunkteVerlauf {
    private TreeMap<LocalDateTime, Temperatur> messpunkteMap = new TreeMap<>();

    public void addMesspunkt(LocalDateTime timestamp, Temperatur Temperatur) {
        messpunkteMap.put(timestamp, Temperatur);
    }

    public Map.Entry<LocalDateTime, Temperatur> getMaxTemperaturCelsius() {
        Map.Entry<LocalDateTime, Temperatur> maxTempEntry = null;

        for(Map.Entry<LocalDateTime, Temperatur> entry : messpunkteMap.entrySet()) {
            if (maxTempEntry == null || maxTempEntry.getValue().compareTo(entry.getValue()) < 0) {
                maxTempEntry = entry;
            }
        }
        return maxTempEntry;
    }

    public Map.Entry<LocalDateTime, Temperatur> getMinTemperaturCelsius() {
        Map.Entry<LocalDateTime, Temperatur> minTempEntry = null;
        for(Map.Entry<LocalDateTime, Temperatur> entry : messpunkteMap.entrySet()) {
            if (minTempEntry == null || minTempEntry.getValue().compareTo(entry.getValue()) > 0) {
                minTempEntry = entry;
            }
        }
        return minTempEntry;
    }

    private double createIllegalStateException() {
        throw new IllegalStateException("Der Messpunkteverlauf ist leer!");
    }

}