package ISF;

public class DiffieHellmann {

    public static void main(String []args){
        double n = 2833;
        double g = 641;
        double a = 13;
        double grossA = (Math.pow(g,a));
        System.out.println(grossA);

        double b = 20;
        double grossB = (Math.pow(g,b));
        System.out.println(grossB);

    }
}
