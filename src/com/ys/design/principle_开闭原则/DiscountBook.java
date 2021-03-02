package com.ys.design.principle_开闭原则;

/**
 * 打折后书籍
 *
 * @author HuaDong
 * @date 2021/3/2 20:19
 */
public class DiscountBook extends ParityBook {
    DiscountBook(String name, Double price) {
        super(name, price);
    }
    @Override
    public Double getPrice() {
        double oldPrice = super.getPrice();
        return oldPrice * 0.8 ;
    }
}
