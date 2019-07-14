package com.ys.java8.test;

import org.junit.Test;

import java.math.BigDecimal;

public class Section13 {

    @Test
    public void demo01() {

        String billId = "WX0120150600006";

        String date = billId.substring(4, 10);
        for(int i=0; i< 10; i++) {
            String num;
            int d = (int)(Math.random()*28) + 1;
            if(d/10 > 0)
                num =date + d;
            else
                num =date + "0" + d;
            System.out.println(num);
        }

    }

    @Test
    public void demo02() {
        String cell = "1200.08";
        String cell1 = "12003.0";
        System.out.println(cell.split("\\.0")[0]);
        System.out.println(cell1.split("\\.0")[0]);

        System.out.println(multiply(new BigDecimal(10), new BigDecimal(8)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(1)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(10)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(-1)));
        System.out.println(multiply(new BigDecimal(10), new BigDecimal(11)));

        System.out.println(new BigDecimal(0).multiply(new BigDecimal("10")));
    }

    private BigDecimal multiply(BigDecimal price, BigDecimal discount) {
        if (discount.compareTo(new BigDecimal("1")) > 0 && discount.compareTo(new BigDecimal("10")) < 0) {
            return price.multiply(discount).multiply(new BigDecimal(0.1));
        }
        return price;
    }

    @Test
    public void demo03() {
        System.out.println(new StringBuffer("524"));
    }
}
