package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/31 20:28
 */
public class H_91_解码方法 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            if (i > 1 && s.charAt(i - 2) != '0'
                    && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

    @Test
    public void demo() {
        this.numDecodings("11226");
    }
}
