package OOP.Programm;

import OOP.Klassen.TemperaturReadFromCSV;

public class TemperaturReadFromCSVMain {

    public static void main(String[] args){

        TemperaturReadFromCSV temperaturReadFromCSV = new TemperaturReadFromCSV();
        temperaturReadFromCSV.read("C:\\JavaProjects\\java_oop_HS19\\netatmo-export-201801-201804.csv");

    }
}
