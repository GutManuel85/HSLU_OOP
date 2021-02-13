package OOP.Klassen;

public enum Aggregatszustand {

    SOLID("fest"), LIQUID("fluessig"), GAS("gasfoermig");

    private final String text;

    /* Konstruktor fügt den finalen statischen Klassenattributen den Text String hinzu.*/

 private Aggregatszustand(final String text){
     this.text = text;
 }

    @Override
    public String toString() {

    return this.text;
    }

    public static String getInfotextToAggregatszustand(Element element){
        switch (element.ermittleAggregatszustand()){
            case SOLID: return SOLID.text;
            case LIQUID: return LIQUID.text;
            case GAS: return GAS.text;
            default: return null;
        }
    }

    public String getText() {
        return text;
    }
}
