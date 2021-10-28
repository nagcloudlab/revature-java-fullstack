package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// 10yrs ago
class FoodUtil {
    public static boolean isNonVeg(String foodItem) {
        return foodItem.startsWith("non-");
    }
}

public class MethodReference_Ex_1 {

    public static void main(String[] args) {

        // 2021
        List<String> menu = new ArrayList<>();
        menu.add("veg");
        menu.add("veg");
        menu.add("non-veg");
        menu.add("veg");
        menu.add("non-veg");

//        menu.removeIf(foodItem -> foodItem.startsWith("non-"));
//        menu.removeIf(foodItem -> FoodUtil.isNonVeg(foodItem));
//        menu.removeIf(FoodUtil::isNonVeg); // Method Reference

        // Pointer => memory address of something ( var , method )

        // Method Reference
        Predicate<String> v = FoodUtil::isNonVeg;
        menu.removeIf(v);

        System.out.println(menu);

    }

}

/*

    using method-reference, we can use existing methods as functions.


 */
