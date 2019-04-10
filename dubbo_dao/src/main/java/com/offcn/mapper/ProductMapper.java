package com.offcn.mapper;

import com.offcn.po.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {

    /**
     * 新增商品
     * @param product
     */
    @Insert("insert into product(id,name,price,descs,sales,imgurl) values(#{id},#{name},#{price},#{descs},#{sales},#{imgurl})")
    public Integer addProduct(Product product);
    /***
     * 获取商品列表
     * @return
     */
    @Select("select * from product ")
    public List<Product> getAllProduct();

    /**
     * 读取指定id的商品详情
     * @param id
     * @return
     */
    @Select("select * from product where id=#{id}")
    public Product findProductById(Long id);

    /**
     * 更新指定id的商品销量
     * @param id
     * @param sales
     */
    @Update("update product set sales=#{sales} where id=#{id}")
    public Integer updateSales(Long id, Integer sales);

    /**
     * 删除商品
     * @param id
     * @return
     */
    @Delete("delete from product where id=#{id}")
    public Integer delete(Long id);

    /**
     * 更新商品
     * @param product
     * @return
     */
    @Update("update product set name=#{name},price=#{price},descs=#{descs},sales=#{sales},imgurl=#{imgurl} where id=#{id}")
    public Integer updateProduct(Product product);
}
