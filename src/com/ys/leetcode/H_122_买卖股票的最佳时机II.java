package com.ys.leetcode;

/**
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
}
