package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/23 14:41
 */
public class H_130_被围绕的区域 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 边界上的 'O' 及与其相邻的都填为 '-'
                if ((i == 0 || j == 0 || i == m - 1 || j == n - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 剩下的 'O' 都填为 'X'
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 之前的 '-' 都填回 'O'
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
            }
        }
    }


    private void dfs(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != 'O' || board[i][j] == '-') {
            return;
        }

        board[i][j] = '-';

        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
    }

    @Test
    public void demo() {
        this.solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }
}
