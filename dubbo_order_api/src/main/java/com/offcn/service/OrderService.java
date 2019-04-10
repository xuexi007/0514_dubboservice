package com.offcn.service;


import com.github.pagehelper.PageInfo;
import com.offcn.po.Order;

public interface OrderService {
    public Integer createOrder(Order order);

    public Order getOrderById(Long id);

    public Integer updateOrderStatus(Long id, Integer paystatus);

    public PageInfo<Order> getall(Integer page, Integer size);
}
