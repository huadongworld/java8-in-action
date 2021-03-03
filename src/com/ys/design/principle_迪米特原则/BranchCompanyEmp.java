package com.ys.design.principle_迪米特原则;

/**
 * @author HuaDong
 * @date 2021/3/2 22:36
 */
public class BranchCompanyEmp {
    public String name ;
    BranchCompanyEmp(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "BranchCompanyEmp{name='" + name + '}';
    }
}
