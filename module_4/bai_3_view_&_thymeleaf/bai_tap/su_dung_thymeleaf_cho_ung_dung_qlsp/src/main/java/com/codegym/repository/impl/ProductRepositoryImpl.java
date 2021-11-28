package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static List<Product> productList;
    static {
        productList = new ArrayList<>();
        productList.add(new Product(1,"iPhone", 2300000, "Điện thoại"));
        productList.add(new Product(2,"Nokia", 2300000, "Điện thoại"));
        productList.add(new Product(3,"Vivo", 2300000, "Điện thoại"));
        productList.add(new Product(4,"Oppo", 2300000, "Điện thoại"));
        productList.add(new Product(5,"Samsung", 2300000, "Điện thoại"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public int getIndex(int id) {
        for(int i=0; i<productList.size(); i++){
            if(productList.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(getIndex(id));
    }

    @Override
    public void update(Product product) {
        int index = getIndex(product.getId());
        productList.set(index,product);
    }

    @Override
    public void remove(int id) {
        productList.remove(getIndex(id));
    }
}
