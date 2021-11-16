package com.example;

import com.example.model.Dish;

import java.util.List;

public class Ex2 {

    public static void main(String[] args) {


        List<Dish> dishList=Dish.menu;

        dishList
                .stream()  // build
                .filter(d->d.getCalories()>=400)  // intermediate
                .map(d->d.getCalories())  // intermediate
                .sorted()  // intermediate
                .forEach(System.out::println);  // terminal ope


    }

}
