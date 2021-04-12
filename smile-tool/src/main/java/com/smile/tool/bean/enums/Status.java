package com.smile.tool.bean.enums;

/**
 * @author gaowenjin
 * @date 2021/4/9
 * @description:
 */
public enum Status {

    INVALID("00", "无效"),
    VALID("01", "有效");

    private String code;
    private String description;

    private Status(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String code() {
        return this.code;
    }

    public String description() {
        return this.description;
    }

    public String toString() {
        return this.code;
    }

}
