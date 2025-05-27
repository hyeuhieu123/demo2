package com.demo2.repository;

import com.demo2.config.ConnectionDB;
import com.demo2.model.Product;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepoImp implements ProductRepo{
    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> products = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_products()}");

            ResultSet rs = callSt.executeQuery();
            products = new ArrayList<>();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setImage(rs.getString("image"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public boolean add(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_product(?,?,?,?)}");

            callSt.setString(1, product.getName());
            callSt.setDouble(2, product.getPrice());
            callSt.setInt(3, product.getQuantity());
            callSt.setString(4, product.getImage());

            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @Override
    public boolean checkExistProductName(String productName, Integer productId) {
        return false;
    }

    @Override
    public Product findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Product product = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_product_by_id(?)}");

            callSt.setInt(1, id);

            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                product = new Product();
                product.setId(rs.getInt("product_id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setQuantity(rs.getInt("quantity"));
                product.setImage(rs.getString("image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean update(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_product(?,?,?,?,?)}");

            callSt.setInt(1, product.getId());
            callSt.setString(2, product.getName());
            callSt.setDouble(3, product.getPrice());
            callSt.setInt(4, product.getQuantity());
            callSt.setString(5, product.getImage());

            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override

    public boolean delete(int id) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_product(?)}");
            callSt.setInt(1, id);
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
