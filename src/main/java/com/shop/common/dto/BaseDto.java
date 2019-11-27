package com.shop.common.dto;


import com.baomidou.mybatisplus.annotations.TableField;

import java.io.Serializable;

/**
 * 所有Dto的基类
 */
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 页数 */
    @TableField(exist=false)
    private int page;

    /** 每页条数 */
    @TableField(exist=false)
    private int rows;

    /** 排序的列 */
    @TableField(exist=false)
    private String sidx;

    /** 排序规则 */
    @TableField(exist=false)
    private String sord = "desc";

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
