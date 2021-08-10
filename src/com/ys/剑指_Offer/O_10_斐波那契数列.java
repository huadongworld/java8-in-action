package com.ys.剑指_Offer;

/**
 * @author HuaDong
 * @date 2021/7/22 21:28
 */
public class O_10_斐波那契数列 {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] num = new int[n + 1];
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[i] = (num[i - 1] + num[i - 2]) % 1000000007;
        }
        return num[n];
    }
    public int fib2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int a = 1;
        int b = 2;
        for (int i = 2; i < n; i++) {
            int sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return b;
    }
}
