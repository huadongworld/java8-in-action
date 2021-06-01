package com.ys.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * DP方程：
 *
 * F(i) = min(F(i - coins[j])) + 1
 *
 * @author HuaDong
 * @date 2021/5/29 19:55
 */
public class H_322_零钱兑换 {

    class DequeCoins {
        int total;
        int level;

        public DequeCoins(int total, int level) {
            this.total = total;
            this.level = level;
        }
    }

    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }

        Deque<DequeCoins> queue = new LinkedList<>();

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == amount) {
                return 1;
            }
            queue.offer(new DequeCoins(coins[i], 1));
        }

        while (!queue.isEmpty()) {
            DequeCoins dequeCoins = queue.poll();
            for (int i = 0; i < coins.length; i++) {
                int total = dequeCoins.total + coins[i];
                if (total == amount) {
                    return dequeCoins.level + 1;
                } else if (total < amount) {
                    queue.offer(new DequeCoins(total, dequeCoins.level + 1));
                }
            }
        }

        return -1;
    }

    public int coinChange2(int[] coins, int amount) {

        int n = coins.length;
        int[] dp = new int[amount + 1];

        Arrays.sort(coins);

        if (amount == 0) {
            return 0;
        }

        if (amount < coins[0]) {
            return -1;
        }
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (coins[i] <= amount) {
                dp[coins[i]] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i < coins[j]) {
                    break;
                }
                min = Math.min(dp[i - coins[j]], min);
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            } else {
                dp[i] = min;
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    @Test
    public void demo() {
        this.coinChange2(new int[]{1, 2, 5}, 11);
    }
}
