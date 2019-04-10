package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 商品库存表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductStock {

    private Long id;
    private Integer stock;   //库存数量
    private Long productid;  //商品编号
}
