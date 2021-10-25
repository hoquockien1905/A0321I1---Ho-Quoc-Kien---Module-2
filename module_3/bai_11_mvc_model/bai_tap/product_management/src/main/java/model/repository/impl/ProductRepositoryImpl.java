package model.repository.impl;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

    static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product("Iphone", 2000));
        productMap.put(2, new Product("Vivo", 1200));
        productMap.put(3, new Product("Nokia", 1500));
        productMap.put(4, new Product("Oppo", 1700));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void add(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {
        productMap.remove(id);
    }
}
