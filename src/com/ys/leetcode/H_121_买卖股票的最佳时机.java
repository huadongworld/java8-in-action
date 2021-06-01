package com.ys.leetcode;

/**
 * https://www.cnblogs.com/peng8098/articles/13409788.html
 *
 * @author HuaDong
 * @date 2021/5/30 15:22
 */
public class H_121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {

        int res = 0;
        int tmp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(prices[i] - tmp, res);
            tmp = Math.min(prices[i], tmp);
        }

        return res;
    }


    public int maxProfit2(int[] prices) {

        int length = prices.length;
        int[][] dp = new int[length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], - prices[i]);
        }

        return dp[length - 1][0];
    }
}
