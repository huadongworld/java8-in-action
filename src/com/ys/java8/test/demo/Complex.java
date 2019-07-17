package com.ys.java8.test.demo;

/**
 * @author HuaDong
 * @date 2019/7/14 12:35
 */
public class Complex {
    private final double re;
    private final double im;

    private Complex(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public static Complex valueOf(double re, double im) {
        return new Complex(re, im);
    }
}
