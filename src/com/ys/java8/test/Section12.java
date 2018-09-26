package com.ys.java8.test;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.*;

public class Section12 {

    /**
     * LocalDate
     */
    @Test
    public void Demo01() {

        LocalDateTime date = LocalDateTime.of(2099,12,31,23,59,59);
        System.out.println(date);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
//        boolean leap = date.isLeapYear();

        LocalDate today = LocalDate.now();
        System.out.println(today);
        LocalDateTime todayTime = LocalDateTime.now();
        System.out.println(todayTime);

        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);

        System.out.println(year);
        System.out.println(year1);
        System.out.println(month);
        System.out.println(month1);
        System.out.println(day);
        System.out.println(day1);
    }

    /**
     * LocalTime
     */
    @Test
    public void Demo02() {

        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

        LocalDate date = LocalDate.parse("2011-11-11");
        LocalTime time1 = LocalTime.parse("14:34:56");
        System.out.println(date.getMonth());
        System.out.println(time1);

        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);
    }

    /**
     * LocalDateTime
     */
    @Test
    public void Demo03() {

        LocalDate date = LocalDate.of(2016, 11, 11);
        LocalTime time = LocalTime.of(13, 45, 20);
        LocalDateTime dt1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(06, 36, 33);
        LocalDateTime dt4 = date.atTime(time);
        LocalDateTime dt5 = time.atDate(date);

        System.out.println(dt1);
        System.out.println(dt2);
        System.out.println(dt3);
        System.out.println(dt4);
        System.out.println(dt5);
    }

    /**
     * Duration表示时间间隔
     */
    @Test
    public void Demo04() {

        LocalDate date = LocalDate.of(2016, 11, 11);
        LocalTime time1 = LocalTime.of(13, 45, 20);
        LocalTime time2 = LocalTime.of(11, 45, 22);
        LocalDateTime dateTime1 = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45, 20);
        LocalDateTime dateTime2 = date.atTime(06, 36, 33);
        Instant instant1 = Instant.ofEpochSecond(3, 0);
        Instant instant2 = Instant.ofEpochSecond(2, 1_000_000_000);

        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(instant1, instant2);
        Duration d3 = Duration.between(dateTime1, dateTime2);

        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
    }

    /**
     * Period表示时间间隔
     */
    @Test
    public void Demo05() {
        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes1 = Duration.of(3, ChronoUnit.MINUTES);
        Period tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);

        System.out.println(threeMinutes);
        System.out.println(threeMinutes1);
        System.out.println(tenDays);
        System.out.println(threeWeeks);
        System.out.println(twoYearsSixMonthsOneDay);
    }

    /**
     * 操作时间
     */
    @Test
    public void Demo06() {

        // 以比较直观的方式操纵LocalDate的属性
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        //以相对方式修改LocalDate对象的属性
        LocalDate date5 = LocalDate.of(2014, 3, 18);
        LocalDate date6 = date5.plusWeeks(1);
        LocalDate yesterday = date6.minusDays(1);
        LocalDate date7 = date6.minusYears(3);
        LocalDate date8 = date7.plus(6, ChronoUnit.MONTHS);

        //使用TemporalAdjuster进行更加复杂的操作
        LocalDate date9 = LocalDate.of(2014, 3, 18);
        LocalDate date10 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date11 = date2.with(lastDayOfMonth());

        LocalDate thisMonday = LocalDate.now().with(DayOfWeek.MONDAY);
        LocalDate thisSunday = LocalDate.now().with(DayOfWeek.SUNDAY);

    }

    /**
     * 日期格式
     */
    @Test
    public void Demo07() throws ParseException {
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(s1);
        System.out.println(s2);

        LocalDateTime nowDateTime = LocalDateTime.now();
        LocalDateTime beforeFiveMinDateTime = nowDateTime.minusMinutes(5);

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String nowStr = nowDateTime.format(format);
        String nowStr1 = beforeFiveMinDateTime.format(format);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date6 = sdf.parse(nowStr);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        String localDateTime1 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(localDateTime1);

        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date1);
        System.out.println(date2);

        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date3 = LocalDate.of(2014, 3, 18);
        String formattedDate = date.format(italianFormatter);
        System.out.println(formattedDate);
        LocalDate date4 = LocalDate.parse(formattedDate, italianFormatter);
        System.out.println(date3);
        System.out.println(date4);

        DateTimeFormatter italianFormatter1 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
        System.out.println(italianFormatter1);

        ZoneId romeZone = ZoneId.of("Europe/Rome");
        LocalDate date5 = LocalDate.of(2014, Month.MARCH, 18);
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);
        LocalDateTime dateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);
        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

    }

    @Test
    public void Demo08() {
        //今天
        LocalDate today = LocalDate.now();
        //本周周一
        LocalDate thisMonday = today.with(DayOfWeek.MONDAY);
        //本周周天
        LocalDate thisSunday = today.with(DayOfWeek.SUNDAY);
        //本月第一天
        LocalDate thisMonthStart = today.with(firstDayOfMonth());
        //本月最后一天
        LocalDate thisMonthEnd = today.with(lastDayOfMonth());
        //本季度第一天
        LocalDate thisQuarterStart = today.with(TemporalAdjusters.ofDateAdjuster((t) -> {
            switch (t.getMonth().getValue()) {
                //第一季度
                case 1:
                case 2:
                case 3:
                    return Quarter.FIRST_QUARTER_START.getDesc();
                //第二季度
                case 4:
                case 5:
                case 6:
                    return Quarter.SECOND_QUARTER_START.getDesc();
                //第三季度
                case 7:
                case 8:
                case 9:
                    return Quarter.THIRD_QUARTER_START.getDesc();
                //第四季度
                default:
                    return Quarter.FOURTH_QUARTER_START.getDesc();
            }
        }));
        //本季度最后一天
        LocalDate thisQuarterEnd = today.with(TemporalAdjusters.ofDateAdjuster((t) -> {
            switch (t.getMonth().getValue()) {
                //第一季度
                case 1:
                case 2:
                case 3:
                    return Quarter.FIRST_QUARTER_END.getDesc();
                //第二季度
                case 4:
                case 5:
                case 6:
                    return Quarter.SECOND_QUARTER_END.getDesc();
                //第三季度
                case 7:
                case 8:
                case 9:
                    return Quarter.THIRD_QUARTER_END.getDesc();
                //第四季度
                default:
                    return Quarter.FOURTH_QUARTER_END.getDesc();
            }
        }));
        //昨天
        LocalDate yesterday = today.minusDays(1);
        //上周周天
        LocalDate lastSunday = thisMonday.minusDays(1);
        //上周周一
        LocalDate lastMonday = lastSunday.with(DayOfWeek.MONDAY);
        //上月最后一天
        LocalDate lastMonthEnd = thisMonthStart.minusDays(1);
        //上月第一天
        LocalDate lastMonthStart = lastMonthEnd.with(firstDayOfMonth());
        //上季度最后一天
        LocalDate lastQuarterEnd = thisQuarterStart.minusDays(1);
        //本季度第一天
        LocalDate lastQuarterStart = today.with(TemporalAdjusters.ofDateAdjuster((t) -> {
            //计算当前月份三个月前的月份
            Integer month = (t.getMonth().getValue() + 9) % 12;
            switch (month) {
                //第一季度
                case 1:
                case 2:
                case 3:
                    return Quarter.FIRST_QUARTER_START.getDesc();
                //第二季度
                case 4:
                case 5:
                case 6:
                    return Quarter.SECOND_QUARTER_START.getDesc();
                //第三季度
                case 7:
                case 8:
                case 9:
                    return Quarter.THIRD_QUARTER_START.getDesc();
                //第四季度
                default:
                    return Quarter.FOURTH_QUARTER_START.getDesc();
            }
        }));
    }

    @Test
    public void demo09() {

        for (int i = 0; i <= 100000; i++) {
            if (i % 7 == 4 && (i + 5) % 5 == 2 && i % 3 == 0) {
                System.out.println(i);
            }
        }
    }
}
