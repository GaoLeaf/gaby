package com.smile.tool.time;

import java.time.format.DateTimeFormatter;

/**
 * 日期辅助类
 *
 * @author gaowenjin
 * @date 2021/4/8
 * @description:
 */
public class LocalDates {

    private LocalDates() {
    }

    public static final DateTimeFormatter DATETIME_YMDHMSS = DateTimeFormatter.ofPattern("yyMMddhhmmssSSS");

}
