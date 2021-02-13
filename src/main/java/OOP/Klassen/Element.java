package OOP.Klassen;

public abstract class Element implements Comparable<Element> {

    private double siedepunkt; // Da die Klasse abstrakt ist, müssen die Attribute noch nicht instanziert werden. Die Werte werden dann dank Polymorphie von der Unterklasse an den Konstruktor der Superklasse weitergereicht und somit initialisiert.
    private double schmelzpunkt;
    private double temperaturCelsius;
    private String elementname;
    private String chemischessymbol;


    public Element(double temperaturCelsius, double schmelzpunkt, double siedepunkt, String elementname,
                   String chemischesSymbol) {
        this.temperaturCelsius = temperaturCelsius;
        this.schmelzpunkt = schmelzpunkt;
        this.siedepunkt = siedepunkt;
        this.elementname = elementname;
        this.chemischessymbol = chemischesSymbol;
    }

    public Aggregatszustand ermittleAggregatszustand() { {
            if (this.getTemperaturCelsius() >= this.siedepunkt) {
                return Aggregatszustand.GAS;
            } else if (this.getTemperaturCelsius() < this.schmelzpunkt) {
                return Aggregatszustand.SOLID;
            } else {
                return Aggregatszustand.LIQUID;
            }
        }
    }

    public double getTemperaturCelsius() {
        return temperaturCelsius;
    }

    @Override
    public String toString() {
        return "Temperatur: " + temperaturCelsius + " Grad Celsius / " +
                "Schmelzpunkt: " + schmelzpunkt + " / " +
                "Siedepunkt: " + siedepunkt + " / " +
                "Elementname: " + elementname + " / " +
                "Chemische Symbol: " + chemischessymbol + " / ";
    }

    @Override
    public int compareTo(Element ohter) {
        return Double.compare(this.temperaturCelsius, ohter.temperaturCelsius);
    }

    public double getSiedepunkt() {
        return siedepunkt;
    }

    public void setSiedepunkt(double siedepunkt) {
        this.siedepunkt = siedepunkt;
    }

    public double getSchmelzpunkt() {
        return schmelzpunkt;
    }

    public void setSchmelzpunkt(double schmelzpunkt) {
        this.schmelzpunkt = schmelzpunkt;
    }

    public void setTemperaturCelsius(double temperaturCelsius) {
        this.temperaturCelsius = temperaturCelsius;
    }
}