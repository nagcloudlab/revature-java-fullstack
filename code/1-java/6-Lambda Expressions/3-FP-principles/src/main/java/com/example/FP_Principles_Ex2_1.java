package com.example;


import java.util.function.Consumer;

public class FP_Principles_Ex2_1 {

    public static void main(String[] args) {


        Consumer<String> helloFunction = name -> {
            System.out.println("\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31");
            System.out.println("Hello " + name);
            System.out.println("\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31");
        };

        helloFunction.accept("Nag");

        Consumer<String> hiFunction = name -> {
            System.out.println("\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31");
            System.out.println("Hi " + name);
            System.out.println("\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31");
        };

        hiFunction.accept("Nag");

        /*

            design issues
            ----------------

            => code scattering / duplication
            => code tangling   / tight-coupling

            solution:

                => use higher-order functions


         */


    }
}
