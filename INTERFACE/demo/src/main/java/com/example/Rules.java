package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Rules{
    public static ArrayList placeRules() throws FileNotFoundException{
        InputStream regle = new FileInputStream("../../regle.txt");
        Scanner obj = new Scanner(regle);
        ArrayList<String> res = new ArrayList<>() ;
        while (obj.hasNextLine()) {
            res.add("\n"+obj.nextLine()+"\n");
        }
        return res;
    }
}