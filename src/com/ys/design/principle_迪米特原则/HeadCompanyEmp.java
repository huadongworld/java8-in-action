package com.ys.design.principle_迪米特原则;

/**
 * @author HuaDong
 * @date 2021/3/2 22:37
 */
public class HeadCompanyEmp {
    public String name;
    public HeadCompanyEmp(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "HeadCompanyEmp{name='" + name + '}';
    }
}
