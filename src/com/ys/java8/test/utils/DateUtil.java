package com.ys.java8.test.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author HuaDong
 * @date 2019/8/2 17:13
 */
public class DateUtil {

    public static final String DATE_TIME_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String SQL_DATE_FORMAT_PATTERN = "yyyy/MM/dd";

    public static final String SHORT_DATE_FORMAT_PATTERN = "yyyyMMdd";

    public static final String DATE_DETAIL_FORMAT_PATTERN = "yyyyMMddHHmmssSSS";

    public static final DateFormat DATE_DETAIL_FORMAT = new SimpleDateFormat(DATE_DETAIL_FORMAT_PATTERN);

    public static final DateFormat DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT_PATTERN);

    public static final DateFormat SQL_DATE_FORMAT = new SimpleDateFormat(SQL_DATE_FORMAT_PATTERN);

    public static final DateFormat SHORT_DATE_FORMAT = new SimpleDateFormat(SHORT_DATE_FORMAT_PATTERN);

    /**
     * 时间格式化 yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static Date tryParseDate(String date) {
        if (date == null) {
            return null;
        }

        try {
            return DATE_TIME_FORMAT.parse(date);
        } catch (ParseException e) {
            try {
                return SQL_DATE_FORMAT.parse(date);
            } catch (ParseException e2) {
                try {
                    return SHORT_DATE_FORMAT.parse(date);
                } catch (ParseException e1) {
                    //ignore
                }
            }
            return null;
        }
    }

    /**
     * 年的加法
     *
     * @param date
     * @param years
     * @return
     */
    public static Date plusYears(Date date, int years) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.YEAR, years);
        return c.getTime();
    }

    /**
     * 获取当前时间时间戳，格式 yyyyMMddHHmmssSSS
     *
     * @return
     */
    public static String getTimeStamp(Date date) {
        return DATE_DETAIL_FORMAT.format(date);
    }
}
