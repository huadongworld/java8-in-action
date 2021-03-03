package com.ys.design.principle_组合聚合原则;

/**
 * @author HuaDong
 * @date 2021/3/3 23:41
 */
public class ProductDao{
    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }
}
