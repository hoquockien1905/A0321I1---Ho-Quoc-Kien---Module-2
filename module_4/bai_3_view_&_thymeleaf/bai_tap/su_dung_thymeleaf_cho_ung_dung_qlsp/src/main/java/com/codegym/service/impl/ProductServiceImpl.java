package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductService productService;

    @Override
    public List<Product> findAll() {
        return productService.findAll();
    }

    @Override
    public int getIndex(int id) {
        return productService.getIndex(id);
    }

    @Override
    public void save(Product product) {
        productService.save(product);
    }

    @Override
    public Product findById(int id) {
        return productService.findById(id);
    }

    @Override
    public void update(Product product) {
        productService.update(product);
    }

    @Override
    public void remove(int id) {
        productService.remove(id);
    }
}
