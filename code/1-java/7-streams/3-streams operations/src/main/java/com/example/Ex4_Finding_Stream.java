package com.example;

import com.example.model.Dish;

import java.util.List;
import java.util.Optional;

public class Ex4_Finding_Stream {
    public static void main(String[] args) {

        List<Dish> menu=Dish.menu;

        boolean isVegetarianFriendlyMenu=
        menu
                .stream()
                .anyMatch(Dish::isVegetarian);
        System.out.println(isVegetarianFriendlyMenu);



        boolean isHealthyMenu=
                menu
                        .stream()
                        .allMatch(d->d.getCalories()<1000);
        System.out.println(isHealthyMenu);


        isHealthyMenu=
                menu
                        .stream()
                        .noneMatch(d->d.getCalories()>=1000);



       Optional<Dish> vegDish= menu
                .stream()
                .filter(Dish::isVegetarian)
                .findFirst(); // terminal methods

       if(vegDish.isPresent()){
           System.out.println(vegDish.get());
       }



    }
}
