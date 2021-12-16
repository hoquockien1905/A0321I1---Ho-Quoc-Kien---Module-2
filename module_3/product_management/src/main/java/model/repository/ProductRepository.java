package model.repository;

import model.bean.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();

    void save(Product product);

    void delete(int id);

    void update(Product product);

    Product findById(int id);
}
