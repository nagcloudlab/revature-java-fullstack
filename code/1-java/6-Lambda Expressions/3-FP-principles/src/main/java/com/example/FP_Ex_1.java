package com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.function.Consumer;

public class FP_Ex_1 {

    public static void main(String[] args) throws FileNotFoundException {


        Consumer<String> hiFn=name-> System.out.println("hi "+name);
        Consumer<String> helloFn=name-> System.out.println("hello "+name);

        String name="Nag";

//        hiFn.accept(name);
//        helloFn.accept(name);

        Consumer hiAndHelloFunc=hiFn.andThen(helloFn);
        hiAndHelloFunc.accept(name);


    }

}
