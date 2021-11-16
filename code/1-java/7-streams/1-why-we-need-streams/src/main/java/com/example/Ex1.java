package com.example;

import com.example.model.Dish;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ex1 {

    public static void main(String[] args) {

        List<Dish> dishList = Dish.menu;

        // display Low-caloric ( < 400) dish names in sorted by calorie


        List<String> dishNames = getLocalCaloricDishNamesV3(dishList);
        System.out.println(dishNames);


    }

    //--------------------------------------------------------------
    // Internal Iteration => streams
    //--------------------------------------------------------------

    private static List<String> getLocalCaloricDishNamesV4(List<Dish> dishList) {
        return dishList
                .stream() // api
                .filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }

    private static List<String> getLocalCaloricDishNamesV3(List<Dish> dishList) {

        return dishList
                .stream() // api
                .filter(d -> d.getCalories() < 400)
                .sorted((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()))
                .map(d -> d.getName())
                .collect(Collectors.toList());

    }


    //--------------------------------------------------------------
    // External Iteration  leads to code in imperative style
    //--------------------------------------------------------------

    private static List<String> getLocalCaloricDishNamesV2(List<Dish> dishList) {
        // filtering low caloric dishes into new list
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishList) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        // sorting low caloric dishes
        lowCaloricDishes.sort((d1, d2) -> Integer.compare(d1.getCalories(), d2.getCalories()));
        // extracting dish names into new list
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        return lowCaloricDishesName;
    }


    //--------------------------------------------------------------
    // imperative style
    //--------------------------------------------------------------

    private static List<String> getLocalCaloricDishNamesV1(List<Dish> dishList) {
        // filtering low caloric dishes into new list
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : dishList) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        // sorting low caloric dishes
        lowCaloricDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        // extracting dish names into new list
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish dish : lowCaloricDishes) {
            lowCaloricDishesName.add(dish.getName());
        }
        return lowCaloricDishesName;
    }

}
