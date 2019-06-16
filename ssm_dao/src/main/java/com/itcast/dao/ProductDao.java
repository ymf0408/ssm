package com.itcast.dao;

import com.itcast.domain.Product;

import java.util.List;

public interface ProductDao {

    public List<Product> findAll();

    void save(Product product);
}
