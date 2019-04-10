package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品表
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
private Long id;
private String name;       //商品名称
private Double price;     //价格
private String descs;     //商品描述
private Integer sales;   //销量
private Integer stock;   //库存
private String imgurl;   //配图

}
