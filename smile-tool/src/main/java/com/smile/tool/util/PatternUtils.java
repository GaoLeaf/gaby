package com.smile.tool.util;

import java.util.regex.Pattern;

/**
 * @author gaowenjin
 * @date 2021/1/28
 * @description:
 */
public class PatternUtils {

    private PatternUtils(){}

    /**
     * 正则匹配
     * @param regex
     * @param inputStr
     * @return
     */
    public static boolean matches(String regex, String inputStr) {

        Pattern pattern = Pattern.compile(regex);

        return pattern.matcher(inputStr).matches();
    }

}
