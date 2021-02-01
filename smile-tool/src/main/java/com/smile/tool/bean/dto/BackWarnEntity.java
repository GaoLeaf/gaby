package com.smile.tool.bean.dto;

import java.io.Serializable;

/**
 * 返回提示
 *
 * @author gaowenjin
 * @date 2021/2/1
 * @description:
 */
public class BackWarnEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean isSuccess; // 是否成功

    private String code; // 返回码

    private String message; // 返回信息

    public BackWarnEntity() {
        super();
    }

    public BackWarnEntity(boolean isSuccess, String message) {
        super();
        this.isSuccess = isSuccess;
        this.message = message;
    }

    public BackWarnEntity(boolean isSuccess, String code, String message) {
        super();
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
