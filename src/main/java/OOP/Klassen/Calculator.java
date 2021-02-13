package OOP.Klassen;

public class Calculator implements Calculateable {


    public Calculator() {
    }


    @Override
    public int addition(final int i, final int j) {
        int k = i + j;
        return k;
    }

    @Override
    public int subtraction(int i, int j) {
        int k = i - j;
        return k;
    }

    @Override
    public double division(int i, int j) {
        double k = i / j;
        return k;
    }

    @Override
    public double multiplication(int i, int j) {
        double k = i * j;
        return k;
    }

    @Override
    public int modulo(int i, int j) {
        int k = i % j;
        return k;
    }
}
