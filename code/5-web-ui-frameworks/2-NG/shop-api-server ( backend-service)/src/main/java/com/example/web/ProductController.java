package com.example.web;

import com.example.entity.Product;
import com.example.entity.Review;
import com.example.repository.ProductRepository;
import io.javalin.http.Handler;

import java.util.List;

public class ProductController {

    public static ProductRepository productRepository;

    public static Handler get= ctx->{
        List<Product> products=productRepository.findAll();
        ctx.json(products);
    };
    public static Handler getReviews= ctx->{
        int productId=Integer.parseInt(ctx.pathParam("productId"));
        List<Review> reviews=productRepository.findAllReviews(productId);
        ctx.json(reviews);
    };

}
