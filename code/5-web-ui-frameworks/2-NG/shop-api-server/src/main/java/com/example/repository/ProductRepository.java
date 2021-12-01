package com.example.repository;

import com.example.entity.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

}
