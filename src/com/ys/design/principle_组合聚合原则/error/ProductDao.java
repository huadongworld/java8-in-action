package com.ys.design.principle_组合聚合原则.error;

/**
 * @author HuaDong
 * @date 2021/3/3 23:41
 */
public class ProductDao extends DBConnection {
    public void addProduct() {
        String conn = super.getConnection();
        System.out.println("使用" + conn + "增加产品");
    }
}
