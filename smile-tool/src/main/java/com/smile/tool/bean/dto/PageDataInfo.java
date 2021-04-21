package com.smile.tool.bean.dto;

import java.util.List;

/**
 * @author gaowenjin
 * @date 2021/4/16
 * @description:
 */
public class PageDataInfo<T> extends PageInfo {

    private static final long serialVersionUID = 1L;

    private long total; // 总条数

    private List<T> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
