package model.service;

import model.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void delete(int id);

}
