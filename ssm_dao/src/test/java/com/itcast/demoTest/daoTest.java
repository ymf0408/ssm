package com.itcast.demoTest;

import com.itcast.dao.ProductDao;
import com.itcast.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class daoTest {

    @Test
    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-dao.xml");
        //System.out.println(app);
        ProductDao productDao = app.getBean(ProductDao.class);
        List<Product> productList = productDao.findAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }
}