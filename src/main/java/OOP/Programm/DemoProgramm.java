package OOP.Programm;

import OOP.Klassen.*;

public class DemoProgramm {

    public static void main(String[] args) {

        Demo demo1 = new Demo();

        demo1.max1(10, 20);

        demo1.min(30, 40);

        Point point0 = new Point(0, 0);
        System.out.println(point0);
        System.out.println(point0.hashCode());

        Point point1 = new Point(1, 0);
        Point point2 = new Point(-1, 0);
        Point point3 = new Point(-1, -1);
        Point point4 = new Point(0, -1);

        System.out.println(point0 + " = " + point0.bestimmeQuadrant());
        System.out.println(point1 + " = " + point1.bestimmeQuadrant());
        System.out.println(point2 + " = " + point2.bestimmeQuadrant());
        System.out.println(point3 + " = " + point3.bestimmeQuadrant());
        System.out.println(point4 + " = " + point4.bestimmeQuadrant());

        demo1.zaehlen1Bis10ForSchleife();
        System.out.println();
        demo1.zaehlen1Bis10WhileSchleife();
        System.out.println();
        demo1.zaehlen1Bis10DoWhileSchleife();
        ;

        demo1.hochAddieren();
        demo1.hochAddieren4000Mal();
        demo1.printBox(4, 10);
        System.out.println();
        System.out.println();
        demo1.printBox(8, 8);
        System.out.println();
        System.out.println();

        demo1.printSchweizerkreuz(2);

        Line line1 = new Line(4, 3, 9, 8);
        System.out.println(line1.getPoint1());
        System.out.println(line1.getPoint2());
        System.out.println(line1.getPoint1().getX());
        System.out.println(line1.getPoint1().getY());
        System.out.println(line1.getPoint2().getX());
        System.out.println(line1.getPoint2().getY());

        line1.setPoint1(new Point(0, 0));
        line1.setPoint2(new Point(2, 2));

        System.out.println(line1.getPoint1());
        System.out.println(line1.getPoint2());

        line1.getPoint1().setX(1);
        line1.getPoint1().setY(1);
        line1.getPoint2().setX(3);
        line1.getPoint2().setY(3);

        System.out.println(line1.getPoint1());
        System.out.println(line1.getPoint2());
        Point point5 = new Point(point4);
        System.out.println(point4);
        System.out.println(point5);

        Quecksilber quecksilber1 = new Quecksilber(0.00d);
        System.out.println(quecksilber1.toString());
        Stickstoff stickstoff1 = new Stickstoff(0.00d);
        System.out.println(stickstoff1.toString());
        Blei blei1 = new Blei(0.00d);
        System.out.println(blei1.toString());

        Fahrzeug fahrzeug1 = new Fahrzeug(6, 200);
        fahrzeug1.switchOn();
        fahrzeug1.switchOff();
        fahrzeug1.switchOn();
        System.out.println(fahrzeug1.getSwitchCount());

        Shape shape1 = new Circle(0,0,1);
        Shape shape2 = new Rectangle(0,0,2,3);
        ((Circle) shape1).getDiameter();

        Element element1 = new Stickstoff(0);
        System.out.println();
        System.out.println(element1);

        Person person1 = new Person(0, "Bobson", "Bob", 190);
        Person person2 = new Person(1, "Xavierson", "Xavier", 180);
        Person person3 = new Person(2, "Xavierson", "Zoran", 200);
        Person person4 = new Person(3, "Bobson", "Bob", 190);


        person1.compareTo(person2);

        person3.compareTo(person1);

        TemperaturVerlauf verlauf1 = new TemperaturVerlauf();
        verlauf1.add(Temperatur.createFromCelsius(35));
        verlauf1.add(Temperatur.createFromCelsius(30));
        verlauf1.add(Temperatur.createFromCelsius(40));
        System.out.println(verlauf1.average());

        Element element = new Stickstoff(-200);
        System.out.println(element.toString());

        Stickstoff stickstoff = new Stickstoff(400);
        System.out.println(stickstoff);
        Blei blei = new Blei(200);
        System.out.println(blei);

        try{Temperatur temp1 = Temperatur.createFromCelsius(-300);}
        catch(IllegalArgumentException e){
            System.out.println("Exception wurde in der Mainmethode gefangen");
        }

        TemperaturVerlauf temperaturVerlauf1 = new TemperaturVerlauf();
        temperaturVerlauf1.max1();
        TemperaturVerlauf temperaturVerlauf2 = new TemperaturVerlauf();
        Temperatur temperatur = Temperatur.createFromCelsius(50);






    }


}
