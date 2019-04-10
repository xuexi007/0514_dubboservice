package com.offcn.service.impl;

import com.offcn.po.ProductStock;
import com.offcn.service.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ProductStockServiceImpl implements ProductStockService {
    @Autowired
    ProductStockService productStockService;
    @Override
    public Integer updateStock(Integer stock, Long productid) {
        return productStockService.updateStock(stock,productid);
    }

    @Override
    public Integer addStock(ProductStock productStock) {
        return productStockService.addStock(productStock);
    }

    @Override
    public ProductStock getStockByProductId(Long productid) {
        try {
            ProductStock productStock = productStockService.getStockByProductId(productid);
            return productStock;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
