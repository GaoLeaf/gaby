package com.smile.tool.json;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * JSON 序列化
 *
 * @author gaowenjin
 * @date 2021/1/29
 * @description:
 */
public class JsonSerializer {

    private JsonSerializer() {
    }

    /**
     * JSON 串转换为字符串
     * @param obj
     * @return
     */
    public static String stringify(Object obj) {

        if (obj instanceof Collection) {
            Collection<String> iterable = (Collection) obj;
            return iterable.stream()
                    .collect(Collectors.joining(",", "[", "]"));
        }

        return null;
    }

    public static void parse() {

    }

}
