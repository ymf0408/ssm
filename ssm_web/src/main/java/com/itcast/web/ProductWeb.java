package com.itcast.web;

import com.itcast.domain.Product;
import com.itcast.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductWeb {

    @Autowired
    private ProductService productService;

    @RequestMapping("/save") //产品添加
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll";
    }

    @RequestMapping("/findAll") //查询全部产品
    public ModelAndView findById(ModelAndView modelAndView) throws Exception{
        List<Product> productList = productService.findAll();

        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("product-list");
        return modelAndView;
    }

}
