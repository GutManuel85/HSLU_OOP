package OOP.Klassen;

public enum TemperaturEinheiten {

    CELSIUS("Grad Celsius"), KELVIN("Kelvin"), FAHRENHEIT("Fahrenheit");

    private String masseinheit;

    private TemperaturEinheiten(String masseinheit) {
        this.masseinheit = masseinheit;
    }

    public String getMasseinheit() {
        return masseinheit;
    }

    @Override
    public String toString() {
        return masseinheit;
    }
}
