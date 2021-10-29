package com.example;

import com.example.model.Dish;

import java.util.List;
import java.util.stream.IntStream;

public class Ex8_Numeric_Streams {

    public static void main(String[] args) {

        List<Dish> menu=Dish.menu;

        int totalCalories=
        menu
                .stream()
                .mapToInt(Dish::getCalories)
                .sum();



        int maxCalorie=
                menu
                        .stream()
                        .mapToInt(Dish::getCalories)
                        .max()
                        .getAsInt();


        System.out.println(maxCalorie);

        //------------------------------------------------

        IntStream intStream=IntStream.range(1,100);
        intStream
                .filter(n->n%2==0)
                .forEach(System.out::println);



    }

}
