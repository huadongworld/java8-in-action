package com.ys.design.principle_里氏替换原则;

/**
 * 这里使用组合的方式完成计算
 *
 * @author HuaDong
 * @since 2021/2/26 14:59
 */
public class BizCalculate extends Calculate {
    private BaseCalculate baseCalculate = new BaseCalculate();

    public int add(int a, int b) {
        return this.baseCalculate.add(a, b);
    }
}
