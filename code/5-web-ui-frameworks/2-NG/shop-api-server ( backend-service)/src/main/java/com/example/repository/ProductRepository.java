package com.example.repository;

import com.example.entity.Product;
import com.example.entity.Review;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    List<Review> findAllReviews(int productId);

}
