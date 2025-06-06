package com.demo2.repository;

import com.demo2.model.Product;

import java.util.List;

public interface ProductRepo {
    List<Product> findAll();

    boolean add(Product product);

    boolean checkExistProductName(String productName, Integer productId);

    Product findById(int id);

    boolean update(Product product);

    boolean delete(int id);
}
