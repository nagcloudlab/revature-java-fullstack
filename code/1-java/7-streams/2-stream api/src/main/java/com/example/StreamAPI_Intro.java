package com.example;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/*

    Java -8 : Stream Api


    to process collection elements with internal iteration to get aggregate results
    using declarative approach

 */

public class StreamAPI_Intro {

    public static void main(String[] args) {


        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        /// Req: pick all even numbers  and display in console

        //---------------------------------------------------------------------
        // way-1 : imperative style with external iterations
        //---------------------------------------------------------------------

        // #1 : with Iterator
//        Iterator<Integer> iterator = numberList.iterator();
//        while (iterator.hasNext()) {
//            Integer number = iterator.next();
//            if (number % 2 == 0) {
//                System.out.println(number);
//            }
//        }

        // #2: with for-each loop
//        for (Integer number : numberList) {
//            if (number % 2 == 0)
//                System.out.println(number);
//        }

        //---------------------------------------------------------------------
        // way-2 : declarative style with internal iterations  using stream-api
        //---------------------------------------------------------------------

        numberList
                .stream() // build
                .filter(n -> n%2==0) // intermediate
                .forEach(System.out::println); // terminal

    }

}
