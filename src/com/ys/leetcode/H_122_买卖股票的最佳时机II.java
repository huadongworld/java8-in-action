package com.ys.leetcode;

/**
 * https://www.cnblogs.com/peng8098/articles/13409788.html
 *
 * @author HuaDong
 * @date 2021/5/26 23:09
 */
public class H_122_买卖股票的最佳时机II {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int tmp = prices[i + 1] - prices[i];
            if (tmp > 0) {
                res += tmp;
            }
        }
        return res;
    }

    public int maxProfit2(int[] prices) {

        int length = prices.length;
        int[][] dp = new int[length][2];

        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }
}
