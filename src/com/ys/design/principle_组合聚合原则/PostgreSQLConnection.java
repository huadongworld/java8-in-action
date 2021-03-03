package com.ys.design.principle_组合聚合原则;

/**
 * @author HuaDong
 * @date 2021/3/3 23:41
 */
public class PostgreSQLConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "PostgreSQL数据库连接";
    }
}
