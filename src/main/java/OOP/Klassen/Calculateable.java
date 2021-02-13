package OOP.Klassen;

/**
 * Interface zum Berechnen von Werten.
 */

public interface Calculateable {

    int addition(final int i, final int j);

    int subtraction(final int i, final int j);

    double division(final int i, final int j);

    double multiplication(final int i, final int j);

    int modulo (final int i, final int j);
}
