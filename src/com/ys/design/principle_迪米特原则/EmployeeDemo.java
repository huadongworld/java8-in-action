package com.ys.design.principle_迪米特原则;

/**
 * @author HuaDong
 * @date 2021/3/2 22:35
 */
public class EmployeeDemo {
    public static void main(String[] args) {
        HeadCompanyEmpManage empManage = new HeadCompanyEmpManage();
        BranchCompanyEmpManage branchEmp = new BranchCompanyEmpManage();

        empManage.printEmp(branchEmp);
    }
}
