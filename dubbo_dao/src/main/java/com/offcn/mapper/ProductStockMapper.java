package com.offcn.mapper;

import com.offcn.po.ProductStock;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ProductStockMapper {

    /***
     * 更新指定商品id的库存
     * @param productid
     */
    @Update("update product_stock set stock=#{stock} where productid=#{productid}")
    public Integer updateStock(Integer stock, Long productid);

    /***
     * 新增库存信息，在新增商品信息后调用
     * @param productStock
     */
    @Insert("insert into product_stock(id,stock,productid) values(#{id},#{stock},#{productid})")
    public Integer addStock(ProductStock productStock);

    /***
     * 查询指定商品id的库存信息
     * @param productid
     * @return
     */
    @Select("select * from product_stock where productid=#{productid}")
    public ProductStock getStockByProductId(Long productid);

    /***
     * 删除指定商品id的库存信息
     */
    @Delete("delete from product_stock where productid=#{productid}")
    public Integer deleteStockByProductId(Long productid);
}
