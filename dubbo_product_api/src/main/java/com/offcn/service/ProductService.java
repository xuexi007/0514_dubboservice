package com.offcn.service;

import com.github.pagehelper.PageInfo;
import com.offcn.po.Product;

public interface ProductService {
    public Integer addProduct(Product product);

    public PageInfo<Product> getAllProduct(Integer page, Integer size);

    public Product findProductById(Long id);

    public Integer updateSales(Long id, Integer sales);

    public Integer delete(Long id);

    public Integer updateProduct(Product product);
}
