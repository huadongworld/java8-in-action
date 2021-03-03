package com.ys.design.principle_迪米特原则;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/3/2 22:36
 */
public class HeadCompanyEmpManage {

    /**
     * 添加总公司员工
     */
    public List<HeadCompanyEmp> addHeadEmp() {
        List<HeadCompanyEmp> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add(new HeadCompanyEmp("总公司员工：" + i));
        }
        return list;
    }

    /**
     * 打印分公司员工
     */
    public void printEmp(BranchCompanyEmpManage empManage) {
        empManage.printBranchCompanyEmp();
        List<HeadCompanyEmp> headEmpList = addHeadEmp();
        for (HeadCompanyEmp headCompanyEmp : headEmpList) {
            System.out.println(headCompanyEmp);
        }
    }
}
