package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FP_Ex_3 {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product(24234, "laptop", 320000));
        products.add(new Product(45645, "mobile", 60000));
        products.add(new Product(22312, "camera", 20000));
        products.add(new Product(12312, "airpod", 20000));

        Comparator<Product> byName = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Product> byPriceAsc = (o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice());
        Comparator<Product> byPriceDsc=byPriceAsc.reversed();


//        Comparator<Product> byPriceAndName = (o1, o2) -> {
//            if (o1.getPrice() == o2.getPrice()) {
//                return o1.getName().compareTo(o2.getName());
//            } else if (o1.getPrice() > o2.getPrice())
//                return 1;
//            else return -1;
//        };

        // - or -

        Comparator<Product> byPriceAndName = byPriceAsc.thenComparing(byName);  ///

        Collections.sort(products, byPriceDsc);

        for (Product product : products) {
            System.out.println(product);
        }


    }
}

