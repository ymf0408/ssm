package com.itcast.service;

import com.itcast.domain.Orders;

import java.util.List;

public interface OrdersService {
    public List<Orders> findAll(int page,int size) throws Exception;

    public Orders findById(String id) throws Exception;
}
