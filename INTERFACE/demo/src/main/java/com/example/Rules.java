package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Rules{


    public static String placeRules() throws FileNotFoundException{
        InputStream regle = new FileInputStream("../../regle.txt");
        Scanner obj = new Scanner(regle);
        var res = "";
        while (obj.hasNextLine()) {
            return ("\n"+obj.nextLine()+"\n");
        }
        return res;
    }
}