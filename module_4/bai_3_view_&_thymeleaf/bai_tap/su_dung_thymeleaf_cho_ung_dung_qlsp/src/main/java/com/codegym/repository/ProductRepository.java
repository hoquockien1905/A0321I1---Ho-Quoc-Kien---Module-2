package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    int getIndex(int id);

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
