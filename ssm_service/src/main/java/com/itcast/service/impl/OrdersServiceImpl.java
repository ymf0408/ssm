package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.OrdersDao;
import com.itcast.domain.Orders;
import com.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    public List<Orders> findAll(int page,int size) throws Exception{
        PageHelper.startPage(page,size);
        return ordersDao.findAll();
    }

    public Orders findById(String id) throws Exception{
        return ordersDao.findById(id);
    }
}
