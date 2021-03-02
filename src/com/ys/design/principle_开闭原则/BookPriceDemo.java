package com.ys.design.principle_开闭原则;

/**
 * 测试类
 *
 * @author HuaDong
 * @date 2021/3/2 20:17
 */
public class BookPriceDemo {
    public static void main(String[] args) {
        ParityBook parityBook = new DiscountBook("Java", 100.00);
        System.out.println(parityBook.getPrice());
    }
}
