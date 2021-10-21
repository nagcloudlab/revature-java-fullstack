package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Comparable_Ex {
    public static void main(String[] args) {

        Product product1=new Product(234234,"mac-laptop",250000.00);
        Product product2=new Product(345345,"mobile",50000.00);
        Product product3=new Product(123123,"cam",150000.00);
        Product product4=new Product(123123,"cam",150000.00);
        Product product5=new Product(645646,"air-pods",2000.00);

        List<Product> products=new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        //display(products);

        // sort , by id
        /*

            sorting

            2 steps

            step-1 : compare
            step-2 : swap

            sorting algorithms

                - quick sort
                - merge sort
                - insertion sort

         */

        display(products);
        Collections.sort(products); // p1.compareTo(p2) = -1 , Quick-sorting algorithm
        System.out.println();
        display(products);

    }

    private static void display(List<Product> products) {
        for(Product product:products){
            System.out.println(product);
        }
    }
}

