package com.ys.java8.test.jdbc;

import org.junit.Test;

import java.util.Calendar;
import java.util.Properties;

/**
 * @author HuaDong
 * @date 2019/8/1 13:50
 */
public class JDBCUtils {

    private static final String driverClass;
    private static final String url;
    private static final String username;
    private static final String password;

    static {
        driverClass = "1";
        url = "2";
        username = "3";
        password = "4";

        Properties properties = new Properties();
        JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
    }

    @Test
    public void demo() {
        System.out.println(driverClass);
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }

    @Test
    public void demo01() {
        String result = "resultStatus={\n" +
                "  9000\n" +
                "};memo={\n" +
                "  \n" +
                "};result={\n" +
                "  {\n" +
                "    \"alipay_trade_app_pay_response\": {\n" +
                "      \"code\": \"10000\",\n" +
                "      \"msg\": \"Success\",\n" +
                "      \"app_id\": \"2019070965805117\",\n" +
                "      \"auth_app_id\": \"2019070965805117\",\n" +
                "      \"charset\": \"utf-8\",\n" +
                "      \"timestamp\": \"2019-08-02 09:40:56\",\n" +
                "      \"out_trade_no\": \"FFZW2019080299513\",\n" +
                "      \"total_amount\": \"0.01\",\n" +
                "      \"trade_no\": \"2019080222001415630561230476\",\n" +
                "      \"seller_id\": \"2088721002919317\"\n" +
                "    },\n" +
                "    \"sign\": \"BOyCBT0hkaWYF66LS9aEU38d1qDIVkICc+zMISfnaed9nRVeRDMjTKK5KNMWm3m9RzpycKW0yAcOWYcT81Uxk4rIUB6DTUck52XTMOO/tw+R7FncN4rXUcUjqySR9HMfUTMgrfw3f+7V/tUWXXkIDlcHxSN0+uHveErdssxP/jejThF7eMW6CVsWPSFJqSjzxozH5TChxgfvDEk5P/O1BUM5QtGgSr8ScYhaITxREp4mIsbiRShzY9Vy+9g2Nd3IPKcUga7Nnxajp4Oaft+3DL+eu0tazo+wcGJMOyXxGoghdB6X5u2Qxy/jnFHqVzIDxHfGE2+i7UqoVJt4QrsgsA==\",\n" +
                "    \"sign_type\": \"RSA2\"\n" +
                "  }\n" +
                "}\n";

        //outTradeNo的开始位置
        Integer outTradeNoIndex = result.indexOf("out_trade_no") + 16;
        String outTradeNo = result.substring(outTradeNoIndex, outTradeNoIndex + 17);

        System.out.println(outTradeNo);
    }

    @Test
    public void demo02() {

        long totalMilliSeconds = System.currentTimeMillis();
        long totalSeconds = totalMilliSeconds / 1000;

        //求出现在的秒
        long currentSecond = totalSeconds % 60;

        //求出现在的分
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;

        //求出现在的小时
        long totalHour = totalMinutes / 60;
        long currentHour = totalHour % 24;

        //显示时间
        System.out.println("总毫秒为： " + totalMilliSeconds);
        System.out.println(currentHour + ":" + currentMinute + ":" + currentSecond + " GMT");
    }
}
