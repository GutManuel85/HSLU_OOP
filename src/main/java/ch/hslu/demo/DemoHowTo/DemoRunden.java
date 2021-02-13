package ch.hslu.demo.DemoHowTo;

public class DemoRunden {


    static double input = 1.1923456d;
    static double output;


    public static double rundenAufGanzeZahl(){
        output = Math.round(input);
        return output;
    }

    public static double rundenAufEineStelle() {
        output = Math.round(input*10)/10.0;
        return output;
    }

    public static double rundenAufZweiStellen() {
        output = Math.round(input * 100) / 100.0;
        return output;

    }

    public static double rundenAufDreiStellen() {
        output = Math.round(input * 1000) / 1000.0;
        return output;
    }

    public static void main(String[] args) {

        System.out.println(rundenAufGanzeZahl());
        System.out.println(rundenAufEineStelle());
        System.out.println(rundenAufZweiStellen());
        System.out.println(rundenAufDreiStellen());
    }
}

