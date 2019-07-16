package com.ys.java8.test.tag;

/**
 * @author HuaDong
 * @date 2019/7/16 22:12
 */
public class Figure {

    enum Shape {RECTANGLE, CIRCLE};

    final Shape shape;

    double length;
    double width;

    double radius;

    public Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    public Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError();
        }
    }
}
