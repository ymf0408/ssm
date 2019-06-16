package com.itcast.service.impl;

import com.itcast.dao.ProductDao;
import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Product> findAll() throws Exception{
        return productDao.findAll();
    }

    public void save(Product product) throws Exception {
        productDao.save(product);
    }
}
