package com.example.web;

import com.example.entity.Product;
import com.example.entity.Review;
import com.example.repository.ProductRepository;
import io.javalin.http.Handler;
import org.eclipse.jetty.http.HttpStatus;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductController {

    public static ProductRepository productRepository;

    public static Handler getAll= ctx->{
        List<Product> products=productRepository.findAll();
        TimeUnit.SECONDS.sleep(1); // intentional delay for teaching purpose
        ctx.json(products);
    };
    public static Handler get= ctx->{
        int productId=Integer.parseInt(ctx.pathParam("productId"));
        Product product=productRepository.findById(productId);
        ctx.json(product);
    };
    public static Handler create= ctx->{
        Product product=ctx.bodyAsClass(Product.class);
        productRepository.save(product);
        ctx.status(HttpStatus.CREATED_201);
    };
    public static Handler delete= ctx->{
        int productId=Integer.parseInt(ctx.pathParam("productId"));
        productRepository.delete(productId);
    };
    public static Handler getReviews= ctx->{
        int productId=Integer.parseInt(ctx.pathParam("productId"));
        List<Review> reviews=productRepository.findAllReviews(productId);
        ctx.json(reviews);
    };

}
