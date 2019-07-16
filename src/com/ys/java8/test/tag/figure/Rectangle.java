package com.ys.java8.test.tag.figure;

/**
 * @author HuaDong
 * @date 2019/7/16 22:23
 */
public class Rectangle extends Figure {
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
