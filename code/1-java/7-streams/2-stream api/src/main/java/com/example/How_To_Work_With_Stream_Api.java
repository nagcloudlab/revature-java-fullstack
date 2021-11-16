package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class How_To_Work_With_Stream_Api {

    public static void main(String[] args) {

        /*
            steps to work with stream api:

            step-1 : build-the-stream
            step-2 : add one or more intermediate operations e.g filter  ( optional )
            step-3 : must have one terminal-operations , to collect result

         */

        int n1=1;
        int n2=2;
        int n3=3;
        int n4=4;
        int n5=5;
        Integer[] numbers={1,2,3,4,5};
        List<Integer> numberList=Arrays.asList(1,2,3,4,5);


//        Stream.of(n1,n2,n3,n3,n4,n5) // build the stream
//        Arrays.stream(numbers)
            numberList.stream()
            .filter(n->n%2!=0) // intermediate operations
            .limit(2) // intermediate operations
            .forEach(System.out::println); // Terminal operations


    }

}
