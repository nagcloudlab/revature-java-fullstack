package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product implements Comparable<Product> {

    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    public int compareTo(Product o) {
        /*
            if 2 objects are equal , return 0
            if obj-1 > obj-2 , return +v , swap
            if obj-1 < obj-2 , return -v
         */
//        if(this.id==o.id)
//            return 0;
//        if(this.id>o.id)
//            return 1;
//        else
//            return -1;
        // -or-
        return this.id-o.id;
    }
}


public class Application {
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

