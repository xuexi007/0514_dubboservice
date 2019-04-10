package com.offcn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果实体
 *
 * @author sunny
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {

    /**
     * 是否成功
     */
    private Boolean flag;

     /**
     * 返回信息
     */
    private String message;

    /**
     * 无返回数据
     */
    private Object data;

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }


}
