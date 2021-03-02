package com.ys.design.principle_开闭原则;

/**
 * 原价书籍
 *
 * @author HuaDong
 * @date 2021/3/2 20:18
 */
public class ParityBook implements Book {
    private String name;
    private Double price;

    ParityBook(String name, Double price) {
        this.name = name;
        this.price = price;
    }
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
