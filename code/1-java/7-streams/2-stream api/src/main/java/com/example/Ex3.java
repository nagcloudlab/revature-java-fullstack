package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ex3 {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 7, 8, 9); // 10M

        // stream lib ,
        List<Integer> evens=
            integers
                    .parallelStream()
                    .filter(n->n%2==0)
                    .distinct()
                    .collect(Collectors.toList());
        System.out.println(evens);


    }
}

// 60% code , processing collection-of-data for any sources  array,collections, files , db , n/w sockets
