package OOP.Programm;

public class ElementareDatentypenProgramm {

    public static void main(String[] args){

        int maxInteger = Integer.MAX_VALUE;
        int minInteger = Integer.MIN_VALUE;
        System.out.println("Der grösste Wert von Integer ist " + maxInteger);
        System.out.println("Der kleinste Wert von Integer ist " + minInteger);
        System.out.println(" Maximal-Überlauf von Integer bei 2147483647 + 1 ergibt " + (maxInteger + 1)); //direkt der Wert 2147483648 kann nicht zugewiesen werden da ein Compiler-Error
        System.out.println(" Minimal-Überlauf von Integer bei -2147483647 + 1 ergibt " + (minInteger - 1)); //direkt der Wert -2147483649 kann nicht zugewiesen werden da ein Compiler-Error

        System.out.println();

        float maxFloat = Float.MAX_VALUE;
        float minFloat = Float.MIN_VALUE;
        System.out.println("Der grösste Wert von Float ist " + maxFloat);
        System.out.println("Der kleinste Wert von Float" + minFloat);
        System.out.println("Maximal-Überlauf von Float ist bei 3.4028235E38 + 1.0E+32 ergibt " + (maxFloat + 100000000000000000000000000000000f)); //die zu addierende Zahl lässt sich so errechnen: E38 - 7 relevante Stellen der Genauigkeit > E31

        System.out.println();

        System.out.println("Was ergibt 2 + 5/2 ?");
        System.out.println(2 + 5 / 2 + " nicht korrekt");
        System.out.println(2 + 5 / 2d + " korrekt") ;
        System.out.println(2 + 5d / 2 + " korrekt");
        System.out.println(2d + 5 / 2 + " nicht korrekt");
    }
}
