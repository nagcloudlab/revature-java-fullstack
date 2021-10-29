package com.example;

import com.example.model.Dish;
import com.example.model.DishType;

import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Ex11_Partitioning_Stream {

    public static void main(String[] args) {


        List<Dish> menu = Dish.menu;

        Map<Boolean, List<Dish>> map1 =
                menu
                        .stream()
                        .collect(partitioningBy(Dish::isVegetarian));

        Map<Boolean, Map<DishType, List<Dish>>> map2 =
                menu
                        .stream()
                        .collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)));


      Map<Boolean,Dish> map3=
                menu
                        .stream()
                        .collect(partitioningBy(Dish::isVegetarian, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)), Optional::get)));


        System.out.println(map3);
    }

}
