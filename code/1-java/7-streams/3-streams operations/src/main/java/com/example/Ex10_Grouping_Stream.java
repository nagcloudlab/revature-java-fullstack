package com.example;

import com.example.model.CaloricLevel;
import com.example.model.Dish;
import com.example.model.DishType;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Ex10_Grouping_Stream {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;


        Map<DishType, List<Dish>> map1 =
                menu
                        .stream()
                        .collect(Collectors.groupingBy(Dish::getType));


        // DIET -> <=400 , NORMAL <=700 , FAT >=700

        Map<CaloricLevel, List<Dish>> map2 =
                menu
                        .stream()
                        .collect(Collectors.groupingBy(dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT;
                        }));


        Map<DishType, Map<CaloricLevel, List<Dish>>> map3 =
                menu
                        .stream()
                        .collect(
                                Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
                                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                                    else return CaloricLevel.FAT;
                                })));



        Map<DishType,Long> map4=
        menu
                .stream()
                .collect(Collectors.groupingBy(Dish::getType,Collectors.counting()));


        Map<DishType,Integer> map5=
        menu
                .stream()
                .collect(groupingBy(Dish::getType,summingInt(Dish::getCalories)));



        Map<DishType, Set<CaloricLevel>> map6=
        menu.stream().collect(
                groupingBy(Dish::getType, mapping(
                        dish -> {
                            if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                            else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                            else return CaloricLevel.FAT; }, toSet() )));

        System.out.println(map6);

    }

}
