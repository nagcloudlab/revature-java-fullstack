package com.example;

import com.example.model.Dish;

import java.util.*;
import java.util.stream.Collectors;

public class Ex9_Collectors_Stream {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;


        List<Dish> vegMenuList =
                menu
                        .stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toList());

        System.out.println(vegMenuList instanceof ArrayList);

        Set<Dish> vegMenuSet =
                menu
                        .stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.toSet());


        long howManyDishes =
                menu
                        .stream()
                        .filter(Dish::isVegetarian)
                        .collect(Collectors.counting());


        int totalCalories =
                menu
                        .stream()
                        .collect(Collectors.summingInt(Dish::getCalories));


        double avgCalroies =
                menu
                        .stream()
                        .collect(Collectors.averagingInt(Dish::getCalories));


        IntSummaryStatistics intSummaryStatistics =
                menu
                        .stream()
                        .collect(Collectors.summarizingInt(Dish::getCalories));

//        System.out.println(intSummaryStatistics.getSum());
//        System.out.println(intSummaryStatistics.getAverage());
//        System.out.println(intSummaryStatistics.getMin());
//        System.out.println(intSummaryStatistics.getMax());


        String dishesNameString =
                menu
                        .stream()
                        .map(dish -> dish.getName())
                        .collect(Collectors.joining(", "));

        System.out.println(dishesNameString);

    }

}
