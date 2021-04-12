package com.smile.tool.bean.enums;

/**
 * 资金方向
 *
 * @author gaowenjin
 * @date 2021/4/9
 * @description:
 */
public enum AmountDirection {

    EXPENSE("00", "支出"),
    INCOME("01", "收入");

    private String code;

    private String description;

    private AmountDirection(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }

    @Override
    public String toString() {
        return code;
    }
}
