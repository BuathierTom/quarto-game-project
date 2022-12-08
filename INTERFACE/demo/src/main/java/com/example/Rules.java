package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class Rules{


    public Rules() throws FileNotFoundException{
        InputStream regle = new FileInputStream("regle.txt");
        Scanner obj = new Scanner(regle);
        while (obj.hasNextLine()) {
            System.out.println("\n"+obj.nextLine()+"\n");
        }
    }
}