package com.itcast.test.demoTest;

import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class ServiceTest {

    @Test
    public void Test1() throws Exception{
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-service.xml","applicationContext-dao.xml");
        ProductService productService = app.getBean(ProductService.class);
        List<Product> productList = productService.findAll();
        for (Product product : productList) {
            System.out.println(product);
        }
    }

}
