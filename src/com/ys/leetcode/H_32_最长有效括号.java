package com.ys.leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author HuaDong
 * @date 2021/6/5 18:26
 */
public class H_32_最长有效括号 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[len];
        // 先把字符串转换成字符数组，方便取值
        char[] ch = s.toCharArray();
        dp[0] = 0; //base case：dp[0]一定为0
        //dp[i]表示以第i个字符结尾的最长有效括号的长度
        //比如说()(())中，dp[4]=2,dp[5]=6  dp[5]=dp[4]+2+dp[1]=2+2+2=6
        //状态转移方程：
        //对于当前位为 ) 的情况：
        //1.如果前一位是 ( 且i-2<0,   dp[i] = 2
        //2.如果前一位是 ( 且i-2>=0 ，dp[i] = dp[i-2] + 2
        //3.如果前一位是 ) 且ch[i-1-dp[i-1]]=='(' （说明对称的位置正好是左括号）
        //有两种情况，如果对称的位置之前没有非零dp值(i-1-dp[i-1]<1)，dp[i]=dp[i-1] + 2
        //如果对称的位置之前有非零dp值(i-1-dp[i-1]>=1)，dp[i]=dp[i-1] + 2 + dp[i-2-dp[i-1]]
        //4.如果前一位是 ) 但是对称位也是 ) ，dp[i] = 0;
        for (int i = 0; i < len; i++) {
            //当前字符串为(时，不需要判断，dp[i]一定为0
            if (ch[i] == ')') {
                if ((i - 1 >= 0) && ch[i - 1] == '(') {
                    if (i - 2 < 0) {
                        dp[i] = 2;
                    } else {
                        dp[i] = dp[i - 2] + 2;
                    }
                } else if ((i - 1 >= 0) && (i - 1 - dp[i - 1] >= 0) && ch[i - 1] == ')') {
                    if (ch[i - 1 - dp[i - 1]] == '(') {
                        dp[i] = i - 2 - dp[i - 1] >= 0 ? (dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]]) : (dp[i - 1] + 2);
                    } else {
                        dp[i] = 0;
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
