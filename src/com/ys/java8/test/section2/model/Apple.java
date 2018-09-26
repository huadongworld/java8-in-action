package com.ys.java8.test.section2.model;

public class Apple {

    private String color;
    private Integer weight;

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Apple() {
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(Integer weight, String color) {

        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
