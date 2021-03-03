package com.ys.design.principle_迪米特原则;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/3/2 22:39
 */
public class BranchCompanyEmpManage {
    /**
     * 添加分公司员工
     */
    public List<BranchCompanyEmp> addEmp() {
        List<BranchCompanyEmp> list = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            list.add(new BranchCompanyEmp("分公司员工：" + i));
        }
        return list;
    }

    /**
     * 获取分公司员工
     */
    public void printBranchCompanyEmp() {
        List<BranchCompanyEmp> list = addEmp();
        for (BranchCompanyEmp emp : list) {
            System.out.println(emp);
        }
    }
}
