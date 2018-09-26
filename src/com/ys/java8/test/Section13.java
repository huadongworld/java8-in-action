package com.ys.java8.test;

import org.junit.Test;

public class Section13 {

    @Test
    public void Demo01() {

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
}
