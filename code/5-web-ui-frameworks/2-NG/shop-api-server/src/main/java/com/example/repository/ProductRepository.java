package com.example.repository;

import com.example.entity.Product;
import com.example.entity.Review;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(int productId);
    List<Review> findAllReviews(int productId);
    void save(Product product);
    void delete(int productId);

}
