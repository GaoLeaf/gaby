package com.smile.tool.bean.dto;

import java.io.Serializable;

/**
 * @author gaowenjin
 * @date 2021/4/21
 * @description:
 */
public class PageInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pageSize = 10; // 每页显示条数

    private int pageNumber = 1; // 页号

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
