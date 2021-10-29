package com.example;

import com.example.model.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex6_Map_Stream {

    public static void main(String[] args) {

        List<Dish> menu = Dish.menu;

        //--------------------------------------------------------------
        // map
        //--------------------------------------------------------------
        menu
                .stream()
                .map(dish -> dish.getName())
                .forEach(System.out::println);


        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        integers
                .stream()
                .map(n -> n * 10)
                .forEach(System.out::println);

        List<String> stringList = Arrays.asList("hello", "hi", "hey", "ola");

        stringList
                .stream()
                .map(s -> s.length())
                .forEach(System.out::println);


        //--------------------------------------------------------------
        // flatMap
        //--------------------------------------------------------------

        String[] menuLines = {
                "idly,vada,poori",
                "idly,vada,pongal",
                "c-biryani,f-biryani",
                "f-biryani"
        };

        // Ex.

        Arrays
                .stream(menuLines)
                .flatMap(line-> Arrays.stream(line.split(",")))
                .forEach(System.out::println);


        //-----------------------------------------------------------------

        List<List<Integer>> list=new ArrayList<>();
        list.add(List.of(1,2,3,4,5,6));
        list.add(List.of(2,3,6,7,7,9));
        list.add(List.of(2,3,5,67,8,9));


        list
                .stream()
                .flatMap(eachList->eachList.stream())
                .distinct()
                .sorted()
                .forEach(System.out::println);

//        ----------------------------------------------------------------



    }

}
