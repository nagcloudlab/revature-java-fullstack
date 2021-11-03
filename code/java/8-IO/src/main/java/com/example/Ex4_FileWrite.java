package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex4_FileWrite {
    public static void main(String[] args) {

        try {

//            FileWriter fileWriter = new FileWriter("Menu.txt",false);
//            fileWriter.write("Veg-1 \n");
//            fileWriter.write("Veg-2 \n");
//            fileWriter.flush();
//            fileWriter.write("Veg-3 \n");
//            fileWriter.write("Veg-4 \n");
//            fileWriter.close();
//            fileWriter.write("Veg-5 \n");  // error , stream closed

            // -or-

            PrintWriter printWriter = new PrintWriter("Menu.txt");
            printWriter.println("veg-1");
            printWriter.println("veg-2");
            printWriter.println("veg-3");
            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
