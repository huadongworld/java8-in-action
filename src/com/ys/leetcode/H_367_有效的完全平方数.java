package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/27 20:42
 */
public class H_367_有效的完全平方数 {
    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        long start = 2, end = num;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long res = mid * mid;
            if (res == num) {
                return true;
            } else if (res > num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public boolean isPerfectSquare2(int num) {
        int sumnum = 1;
        while (num > 0) {
            num -= sumnum;
            sumnum += 2;
        }

        return num==0;
    }
}
