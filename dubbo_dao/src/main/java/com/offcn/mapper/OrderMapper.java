package com.offcn.mapper;

import com.offcn.po.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {

    /***
     * 新增订单，订单状态为未支付 0
     * @param order
     */
    @Insert("insert into orders(id,userid,productid,price,amount,total,paystatus) values(#{id},#{userid},#{productid},#{price},#{amount},#{total},0)")
    public Integer createOrder(Order order);

    /***
     * 根据指定订单号获取订单信息
     * @param id
     * @return
     */
    @Select("select * from orders where id=#{id}")
    public Order getOrderById(Long id);


    /**
     * 更新指定订单id的状态
     * @param id
     * @param paystatus
     */
    @Update("update orders set paystatus=#{paystatus} where id=#{id}")
    public Integer updateOrderStatus(Long id, Integer paystatus);

    /**
     * 查询全部订单
     * @return
     */
    @Select("select * from orders ")
    public List<Order> getall();

}
