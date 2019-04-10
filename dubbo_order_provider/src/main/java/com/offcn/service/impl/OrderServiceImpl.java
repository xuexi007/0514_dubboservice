package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.mapper.OrderMapper;
import com.offcn.mapper.ProductMapper;
import com.offcn.mapper.ProductStockMapper;
import com.offcn.po.Order;
import com.offcn.po.Product;
import com.offcn.po.ProductStock;
import com.offcn.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    ProductStockMapper productStockMapper;

    @Autowired
    ProductMapper productMapper;
    @Override
    @Transactional   //开启事务
    public Integer createOrder(Order order) {

        //读取指定商品id现库存信息
        ProductStock productStock = productStockMapper.getStockByProductId(order.getProductid());
        Integer insertOrderNum=0;
        Integer updateStockNum=0;
        Integer updateSalesNum=0;
        //判断下单商品库存是否大于0
        if (productStock.getStock()>0) {
            //保存订单
            insertOrderNum = orderMapper.createOrder(order);
            //更新库存
            updateStockNum = productStockMapper.updateStock(productStock.getStock() - order.getAmount(), order.getProductid());
            //模拟异常
            /*  int a=8;
            a=a/0;*/

            //读取指定商品id现销量
            Product product = productMapper.findProductById(order.getProductid());
            //更新销量
            updateSalesNum = productMapper.updateSales(order.getProductid(), product.getSales() + order.getAmount());
        }

        return insertOrderNum+updateStockNum+updateSalesNum;
    }

    @Override
    public Order getOrderById(Long id) {
        return orderMapper.getOrderById(id);
    }

    @Override
    public Integer updateOrderStatus(Long id, Integer paystatus) {
        return orderMapper.updateOrderStatus(id, paystatus);
    }

    @Override
    public PageInfo<Order> getall(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Order> list = orderMapper.getall();
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
