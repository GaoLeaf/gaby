package com.smile.tool.json;

import com.smile.tool.lang.Strings;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author gaowenjin
 * @date 2021/1/31
 * @description:
 */
public class JsonParser {

    private JsonParser() {
    }

    public static Object parse(String json) {

        if (Strings.isEmpty(json)) {
            return json;
        }

        //TODO 转为Set
        if (json.startsWith("[")) { // 数组 & Collection
            return new HashSet<>(Arrays.asList(json.substring(1, json.length()-1).split(",")));
        }

        return json;

    }

}
