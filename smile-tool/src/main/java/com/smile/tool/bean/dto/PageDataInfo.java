package com.smile.tool.bean.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/4/16
 * @description:
 */
public class PageDataInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private long total; // 总条数

    private int pageSize = 10; // 每页显示条数

    private int pageNumber = 1; // 页号

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

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

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
