package com.offcn.service;

import com.offcn.po.ProductStock;

public interface ProductStockService {
    public Integer updateStock(Integer stock, Long productid);
    public Integer addStock(ProductStock productStock);
    public ProductStock getStockByProductId(Long productid);
}
