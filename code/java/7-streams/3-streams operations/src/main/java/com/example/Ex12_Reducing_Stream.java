package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Ex12_Reducing_Stream {

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(10, 20, 30);


        Integer sum =
                integers
                        .stream()
                        .reduce(0, (acc, next) -> acc + next);

        System.out.println(sum);



        String[] employeeNames={"Revee","charles","jeremy"};

       String str=
        Arrays.stream(employeeNames)
                //.reduce((name1,name2)->name1+" "+name2);
                        .collect(Collectors.joining(" "));

        System.out.println(str);
    }

}
