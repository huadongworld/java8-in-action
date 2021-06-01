package com.ys.leetcode;

/**
 * https://www.cnblogs.com/peng8098/articles/13409788.html
 *
 * @author HuaDong
 * @date 2021/5/30 19:51
 */
public class H_714_买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0] - fee;
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
        }

        return dp[n - 1][0];
    }
}
