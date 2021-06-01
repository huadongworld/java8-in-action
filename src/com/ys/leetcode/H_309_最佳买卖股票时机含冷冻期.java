package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/30 19:16
 */
public class H_309_最佳买卖股票时机含冷冻期 {

    /**
     * https://www.cnblogs.com/peng8098/articles/13409788.html
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        if (prices.length < 2) {
            return 0;
        }

        int n = prices.length;

        // dp 记录的是利润
        int[][] dp = new int[n][2];


        for (int i = 0; i < n; i++) {

            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            if (i == 1) {
                dp[1][1] = Math.max(dp[i - 1][1], -prices[i]);
                continue;
            }
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[n - 1][0];
    }

    @Test
    public void demo() {
        this.maxProfit(new int[]{1, 2, 3, 0, 2});
    }

}
