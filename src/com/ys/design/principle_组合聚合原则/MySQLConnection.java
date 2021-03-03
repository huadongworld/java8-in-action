package com.ys.design.principle_组合聚合原则;

/**
 * @author HuaDong
 * @date 2021/3/3 23:40
 */
public class MySQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "MySQL数据库连接";
    }
}
