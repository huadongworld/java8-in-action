package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/31 19:28
 */
public class H_518_零钱兑换II {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int x = coins[i]; x <= amount; x++) {
                dp[x] += dp[x - coins[i]];
            }
        }
        return dp[amount];
    }

    @Test
    public void demo() {
        this.change(5, new int[]{1, 2, 5});
    }
}
