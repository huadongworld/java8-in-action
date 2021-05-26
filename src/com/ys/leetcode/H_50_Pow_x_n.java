package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/26 18:59
 */
public class H_50_Pow_x_n {
    public double myPow(double x, int n) {

        int m;
        if (n < 0) {
            m = -n;
        } else {
            m = n;
        }

        double res = 1;
        while (m != 0) {
            if ((m & 1) == 1) {
                res *= x;
            }
            x *= x;
            m >>= 1;
        }

        if (n < 0) {
            return 1.0 / res;
        }

        return res;
    }
}
