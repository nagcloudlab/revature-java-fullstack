package com.example;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference_Ex_2 {

    public static void main(String[] args) {

        Function<String, Integer> getStringLength1 = s -> s.length();
        Function<String, Integer> getStringLength2 = String::length;

        System.out.println(getStringLength1.apply("Nag"));
        System.out.println(getStringLength2.apply("Nag"));

        BiFunction<Integer, Integer, Integer> compareFn1 = (n1, n2) -> Integer.compare(n1, n2);
        BiFunction<Integer, Integer, Integer> compareFn2 = Integer::compare;

        System.out.println(compareFn1.apply(12, 121));


    }

}
