package com.smile.tool.common;

import com.smile.tool.lang.Strings;
import com.smile.tool.time.LocalDates;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 自增ID生成辅助类
 *
 * @author gaowenjin
 * @date 2021/4/8
 * @description:
 */
public class GenerationIds {

    private GenerationIds() {
    }

    public static final String PREFIX_ACCOUNT_BILL = "80"; // 账户明细流水ID前缀

    /**
     * 获取账户流水ID
     * @param date 流水日期 格式：yyyy-MM-dd
     * @param userId 用户ID
     * @return
     */
    public static String getAccountBillGenerationIdByDateTime(String date, String userId) {
        LocalDateTime dateTime = LocalDateTime.now();
        if (date.length() == 10) {
            dateTime.withYear(Integer.valueOf(date.substring(0, 4)))
                    .withMonth(Integer.valueOf(date.substring(5, 7)))
                    .withDayOfMonth(Integer.valueOf(date.substring(8, 10)));
        }
        return getGenerationIdByDateTime(PREFIX_ACCOUNT_BILL, dateTime, userId, 11, 32);
    }

    /**
     * 生成自增ID
     * @param prefix     前缀
     * @param dateTime 时间
     * @param joinStr 连接串
     * @param joinStrLen 连接串长度，不足左补0
     * @param totalLen 总长度，不足右补随机数
     * @return
     */
    public static String getGenerationIdByDateTime(String prefix, LocalDateTime dateTime,
                                                   String joinStr, int joinStrLen, int totalLen) {

        StringBuilder sb = new StringBuilder(prefix);

        // 加上日期
        if (dateTime == null) {
            dateTime = LocalDateTime.now();
        }
        sb.append(dateTime.format(LocalDates.DATETIME_YMDHMSS));

        /**
         * 加上连接字符串
         * 字符长度不够，左补0
         * 字符长度超过，截取前面对应长度
         */
        if (Strings.isEmpty(joinStr)) {
            IntStream.range(0, joinStrLen).forEach(i -> sb.append("0"));
        } else if (joinStr.length() < joinStrLen) {
            IntStream.range(0, joinStrLen - joinStr.length()).forEach(i -> sb.append("0"));
            sb.append(joinStr);
        } else if (joinStr.length() > joinStrLen) {
            sb.append(joinStr, 0, joinStrLen - 1);
        }

        // 检测长度是否够，不够补上随机数
        if (sb.length() < totalLen) {
            IntStream.range(0, totalLen - sb.length()).forEach(i -> sb.append(new Random().nextInt(9)));
        }

        return sb.toString();
    }

}
