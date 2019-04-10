package com.offcn.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 分页结果集
 *
 * @author sunny
 */
@Data
@AllArgsConstructor
public class PageResult<T> {
    private Long total;
    private Boolean success;
    private String msg;
    private List<T> rows;
}