package com.revature;


public class Product implements Comparable<Product> {

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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
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
        return Integer.compare(this.id,this.id);
    }
}
