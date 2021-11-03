package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ex1 {

    public static void main(String[] args) throws IOException {

        //way-1
//
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        System.out.println("enter name?");
//        String name = br.readLine();
//        System.out.println(name);
//
//        System.out.println("enter age?");
//        String ageString = br.readLine();
//        int age = Integer.parseInt(ageString);
//
        //------------------------------------------------------------
        // Way-2 : from JDK 1.5
        //------------------------------------------------------------

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name?");
        String name = scanner.nextLine();

        System.out.println("enter age");
        int age = scanner.nextInt();

        System.out.println(name);
        System.out.println(age);


        //----------------------------------------------------------------
    }

}
