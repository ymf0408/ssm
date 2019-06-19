package com.itcast.dao;

import com.itcast.domain.Orders;

import java.util.List;

public interface OrdersDao {

    public List<Orders> findAll() throws Exception;

    public Orders findById(String id) throws Exception;
}
