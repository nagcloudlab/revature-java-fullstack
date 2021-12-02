package com.example.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    private String description;
    private String image_path;
    private boolean is_available;

    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<Review> reviews;

    public Product(int id, String name, double price, String description, String image_path, boolean is_available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.image_path = image_path;
        this.is_available = is_available;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public boolean isIs_available() {
        return is_available;
    }

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }
}
