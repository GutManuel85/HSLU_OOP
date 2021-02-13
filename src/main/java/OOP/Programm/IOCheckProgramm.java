package OOP.Programm;

import java.io.File;

public class IOCheckProgramm {

    public static void main(String[] args){

        File file = new File("C:\\Users\\Manuel Gut\\Documents\\IOFiles");
        System.out.println(file.exists());
    }
}
