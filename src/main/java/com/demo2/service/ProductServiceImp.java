package com.demo2.service;

import com.demo2.model.Product;
import com.demo2.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public boolean add(Product product) {
        return productRepo.update(product);
    }

    @Override
    public boolean checkExistProductName(String productName, Integer productId) {
        return false;
    }

    @Override
    public Product findById(int id) {
        return productRepo.findById(id);
    }

    @Override
    public boolean update(Product product) {
        return productRepo.update(product);
    }

    @Override
    public boolean delete(int id) {
        return productRepo.delete(id);
    }
}
