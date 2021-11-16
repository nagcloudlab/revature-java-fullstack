package com.example;

import com.example.model.Dish;

import java.util.Arrays;
import java.util.List;

public class Ex2_Filtering_Stream {
    public static void main(String[] args) {

        /*
            How to filter stream elements ?
            Intermediate operations that select some elements and discard others
                based on:
                    - content  => filter(),takeWhile(),dropWhile()
                    - amount   => limit() , skip()
                    - Uniqueness => distinct()

         */

        List<Dish> menu=Dish.menu;

        menu
                .stream()
                .filter(dish -> dish.isVegetarian())
                .forEach(dish -> System.out.println(dish));

        // -or-

        menu
                .stream()
                .filter(Dish::isVegetarian)
                .forEach(System.out::println);


        // Filtering unique elements
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers
                .stream()
                .filter(i->i%2==0)
                .distinct()
                .forEach(System.out::println);

        menu
                .stream()
                .filter(dish -> dish.getCalories()>300)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("-".repeat(30));

        menu
                .stream()
                .filter(dish -> dish.getCalories()>300)
                .skip(3)
                .forEach(System.out::println);


    }
}
