package com.ys.java8.test.tag.figure;

/**
 * @author HuaDong
 * @date 2019/7/16 22:22
 */
public class Circle extends Figure {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
