package com.offcn.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    /**
     * 主键
     */
    private Long id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String encrptPassword;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String telephone;

    //验证码
    private String smscode;

    /**
     * 配送地址
     */
    private String address;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 账号状态 1、启用  0、禁用
     */
    private Integer status;
}
