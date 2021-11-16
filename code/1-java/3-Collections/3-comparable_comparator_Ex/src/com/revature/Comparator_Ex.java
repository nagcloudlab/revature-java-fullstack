package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Comparator_Ex {
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

        // ByName sorting
        ByName byNameComparator=new ByName();
        Collections.sort(products,byNameComparator);
        display(products);


        // ByPrice sorting
        ByPrice byPriceComparator=new ByPrice();
        Collections.sort(products,byPriceComparator);
        display(products);


        // From java-8, FP using Lambda Expression
        //Collections.sort(products,Comparator.comparing(Product::getPrice));

    }

    private static void display(List<Product> products) {
        for(Product product:products){
            System.out.println(product);
        }
    }
}


class ByName implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class ByPrice implements  Comparator<Product>{
    @Override
    public int compare(Product o1, Product o2) {
        return Double.compare(o1.getPrice(),o2.getPrice());
    }
}