package com.ys.leetcode;

/**
 * https://www.cnblogs.com/peng8098/articles/13409788.html
 *
 * @author HuaDong
 * @date 2021/5/30 19:33
 */
public class H_188_买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {

        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int maxK = k;

        // dp 记录的是利润
        int[][][] dp = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            // base 情况：
            // - k = 0，空仓：说明无利润；
            // - k = 0，有仓位：说明利润为负（或者非法），假设为最小值
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
            for (int kk = maxK; kk >= 1; kk--) {
                // base 情况：
                // - i = 0，空仓：说明第一天没加仓，利润为0
                // - i = 0，有仓位：说明第一天加仓了prices[0]，利润为 -prices[0]
                if (i == 0) {
                    dp[0][kk][0] = 0;
                    dp[0][kk][1] = -prices[0];
                    continue;
                }
                dp[i][kk][0] = Math.max(dp[i - 1][kk][0], dp[i - 1][kk][1] + prices[i]);
                dp[i][kk][1] = Math.max(dp[i - 1][kk][1], dp[i - 1][kk - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][maxK][0];
    }
}
