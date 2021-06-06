package com.ys.leetcode;

import org.junit.Test;

/**
 * 首先这一题可以使用动态规划来进行解决：
 *
 * 状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
 * 状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，dp[i][j]=true，否则为false
 * 这个状态转移方程是什么意思呢？
 *
 * 当只有一个字符时，比如 a 自然是一个回文串。
 * 当有两个字符时，如果是相等的，比如 aa，也是一个回文串。
 * 当有三个及以上字符时，比如 ababa 这个字符记作串 1，把两边的 a 去掉，也就是 bab 记作串 2，可以看出只要串2是一个回文串，那么左右各多了一个 a 的串 1 必定也是回文串。所以当 s[i]==s[j] 时，自然要看 dp[i+1][j-1] 是不是一个回文串。
 *
 * @author HuaDong
 * @date 2021/6/5 21:06
 */
public class H_647_回文子串 {
    public int countSubstrings(String s) {
        // 动态规划法
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }

    public int countSubstrings2(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        int res = 1;

        dp[0][0] = true;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1])) {
                    res++;
                    dp[i][j] = true;
                }
            }
        }

        return res;
    }

    @Test
    public void demo() {
        this.countSubstrings2("aaa");
    }
}
