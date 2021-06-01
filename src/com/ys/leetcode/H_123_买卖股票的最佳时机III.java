package com.ys.leetcode;

import org.junit.Test;

/**
 * https://www.cnblogs.com/peng8098/articles/13409788.html
 *
 * @author HuaDong
 * @date 2021/5/30 18:16
 */
public class H_123_买卖股票的最佳时机III {

    /**
     * dp[-1][k][0] = 0
     * 解释：因为 i 是从 0 开始的，所以 i = -1 意味着还没有开始，这时候的利润当然是 0 。
     * dp[-1][k][1] = -infinity
     * 解释：还没开始的时候，是不可能持有股票的，用负无穷表示这种不可能。
     * dp[i][0][0] = 0
     * 解释：因为 k 是从 1 开始的，所以 k = 0 意味着根本不允许交易，这时候利润当然是 0 。
     * dp[i][0][1] = -infinity
     * 解释：不允许交易的情况下，是不可能持有股票的，用负无穷表示这种不可能。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int maxK = 2;

        // dp 记录的是利润
        int[][][] dp = new int[n][maxK + 1][2];

        for (int i = 0; i < n; i++) {
            // base 情况：
            // - k = 0，空仓：说明无利润；
            // - k = 0，有仓位：说明利润为负（或者非法），假设为最小值
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
            for (int k = maxK; k >= 1; k--) {
                // base 情况：
                // - i = 0，空仓：说明第一天没加仓，利润为0
                // - i = 0，有仓位：说明第一天加仓了prices[0]，利润为 -prices[0]
                if (i == 0) {
                    dp[0][k][0] = 0;
                    dp[0][k][1] = -prices[0];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][maxK][0];
    }

    @Test
    public void demo() {
        this.maxProfit(new int[]{7, 6, 4, 3, 1});
    }
}
