package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class Why_We_Nedd_FP {
    public static void main(String[] args) {

        List<String> menu=new ArrayList<>();
        menu.add("veg");
        menu.add("nveg");
        menu.add("nveg");
        menu.add("veg");
        menu.add("veg");
        menu.add("nveg");

        //------------------------------------------------------------
        // imperative style style
        //------------------------------------------------------------

//        Iterator<String> iterator=menu.iterator();
//        while (iterator.hasNext()){
//            String stringItem=iterator.next();
//            if(stringItem.equals("nveg")){
//                iterator.remove();
//            }
//        }

        //------------------------------------------------------------
        // declarative style  , Local Named Inner Class
        //------------------------------------------------------------

//        class NonVegPredicate implements Predicate<String> {
//            @Override
//            public boolean test(String item) {
//                return item.equals("nveg");
//            }
//        }
//
//        menu.removeIf(new NonVegPredicate()); // Object are first-class citizens


        //------------------------------------------------------------
        // declarative style  , Local Anonymous Inner Class
        //------------------------------------------------------------

//        Predicate<String> nonVegPredicate=new Predicate<String>(){
//            @Override
//            public boolean test(String item) {
//                return item.equals("nveg");
//            }
//        };
//
//        menu.removeIf(nonVegPredicate); // Object are first-class citizens

        //------------------------------------------------------------
        // declarative style  , Lambda Expressions a.k.a Functions  ( JDK 1.8 )
        //------------------------------------------------------------

//        Predicate<String> nonVegPredicate=menuItem->menuItem.equals("nveg");
//        menu.removeIf(nonVegPredicate); // function is first-class citizens

        // or

        menu.removeIf(menuItem->menuItem.equals("nveg")); // function is first-class citizens
        System.out.println(menu);

        /*

            Functional Programming

                => improves code readability
                => compact & concise code

            syntax for Lambda Expressions

            params -> body

            () -> body

            arg1 -> body

            (arg1,arg2) -> body

            () -> {
                line-1
                line-2
            }

         */

    }
}


