package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void edit(int id, String name, double price);

    void delete(int id);

}
