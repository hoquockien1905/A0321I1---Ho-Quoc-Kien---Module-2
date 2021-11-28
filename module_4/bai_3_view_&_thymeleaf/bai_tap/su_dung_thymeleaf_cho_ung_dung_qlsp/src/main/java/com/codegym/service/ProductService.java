package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    int getIndex(int id);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
