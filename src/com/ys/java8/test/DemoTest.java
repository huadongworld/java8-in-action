package com.ys.java8.test;

import com.ys.java8.test.function.Supplier;
import org.junit.Test;

import java.util.Random;

/**
 * @author HuaDong
 * @date 2019/9/6 17:44
 */
public class DemoTest {

    @Test
    public void demo() {
        final String version = "1.8";
        foo(new Supplier() {
            @Override
            public String get() {
                return version;
            }
        });
    }


    @Test
    public void demo01() {
        Random random = new Random();
        int index = random.nextInt(9) + 1;

        System.out.println(index);
    }

    private void foo(Supplier supplier) {
        System.out.println(supplier.get());
    }
}
