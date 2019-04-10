package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {

    private Long id;
    private Long userid;        //用户id
    private Long productid;    //商品编号
    private Double price;      //商品单价
    private Integer amount;    //够买数量
    private Double total;      //合计金额
    private Integer paystatus;  //支付状态
}
