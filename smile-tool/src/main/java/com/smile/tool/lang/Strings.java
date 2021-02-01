package com.smile.tool.lang;

/**
 * @author gaowenjin
 * @date 2021/1/31
 * @description:
 */
public class Strings {

    private Strings() {
    }

    /**
     * 判断字符是否为空
     * @param text
     * @return
     */
    public static boolean isEmpty(String text) {
        return text == null || text.trim().length() == 0;
    }

}
