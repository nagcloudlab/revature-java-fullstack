package com.example;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class FP_Principles_Ex2_2 {

    public static void main(String[] args) {

//        #1 - A function can be stored in a variable
        Consumer<String> helloFunction = name -> {
            System.out.println("Hello " + name);
        };
        Consumer<String> hiFunction = name -> {
            System.out.println("Hi " + name);
        };
        // Higher-Order-Function
        /*
            why we need HOF?
            by composing small functions,
            we can build complex algorithms with code tangling & scattering
         */
        //#-2   - A parameter of a function can be a function
        Function<Consumer<String>, Consumer<String>> emojiWrapper = greetFn -> {
            // #3   - The return value of a function can be a function
            return name -> {
                System.out.println("\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31");
                greetFn.accept(name);
                System.out.println("\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31\uD83C\uDF31");
            };
        };
        //helloFunction.accept("Nag");
        Consumer<String> helloFunctionWithEmoji = emojiWrapper.apply(helloFunction);
        helloFunctionWithEmoji.accept("Nag");


        //---------------------------------------------------------------------------------------------

//
//        List<Integer> integers= Arrays.asList(1,3,2,4,5,9,6,3);
//
//        System.out.println(
//        integers
//                .stream()
//                .filter(n->n%2!=0)
//                .limit(3)
//                .mapToInt(n->n)
//                .sum()
//        );

        //---------------------------------------------------------------------------------------------

    }
}
