package com.ys.design.principle_组合聚合原则.error;

/**
 * @author HuaDong
 * @date 2021/3/3 23:41
 */
public class Test {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDao();
        productDao.addProduct();
    }
}
