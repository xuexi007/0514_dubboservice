package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.mapper.ProductMapper;
import com.offcn.mapper.ProductStockMapper;
import com.offcn.po.Product;
import com.offcn.po.ProductStock;
import com.offcn.service.ProductService;
import com.offcn.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductStockMapper productStockMapper;

    @Autowired
    IdWorker idWorker;
    @Override
    @Transactional
    public Integer addProduct(Product product) {
        product.setSales(0);
        Integer num1 = productMapper.addProduct(product);
        //新增库存信息
        ProductStock productStock = new ProductStock();
        productStock.setId(idWorker.nextId());
        productStock.setProductid(product.getId());
        productStock.setStock(product.getStock());
        Integer num2 = productStockMapper.addStock(productStock);
        return num1+num2;
    }

    @Override
    public PageInfo<Product> getAllProduct(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Product> list = productMapper.getAllProduct();
        //遍历商品集合，更新商品库存
        for (Product product:list){
            ProductStock productStock = productStockMapper.getStockByProductId(product.getId());
            if(productStock!=null) {
                product.setStock(productStock.getStock());
            }else {
                product.setStock(0);
            }
        }
        PageInfo<Product> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Product findProductById(Long id) {
        Product product = productMapper.findProductById(id);
        ProductStock productStock = productStockMapper.getStockByProductId(product.getId());
        if(productStock!=null) {
            product.setStock(productStock.getStock());
        }else {
            product.setStock(0);
        }
        return product;
    }

    @Override
    public Integer updateSales(Long id, Integer sales) {
        return productMapper.updateSales(id,sales);
    }

    @Override
    @Transactional
    public Integer delete(Long id) {
        //1、先删除商品表数据
        Integer num1 = productMapper.delete(id);
        //2、删除库存表数据
        Integer num2 = productStockMapper.deleteStockByProductId(id);
        return num1+num2;
    }

    @Override
    @Transactional
    public Integer updateProduct(Product product) {
        product.setSales(0);
        Integer num1 = productMapper.updateProduct(product);

        //2、更新库存数据
        Integer num2=productStockMapper.updateStock(product.getStock(),product.getId());

        return num1+num2;
    }
}
