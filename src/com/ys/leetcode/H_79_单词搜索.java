package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/23 15:02
 */
public class H_79_单词搜索 {

    private boolean has = false;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 找出所有网格中单词首字母的位置开始搜索
                if (board[i][j] == wordChars[0]) {
                    boolean[][] visited = new boolean[m][n];
                    dfs(board, i, j, wordChars, 0, visited);
                }
            }
        }

        return has;
    }

    private void dfs(char[][] board, int i, int j, char[] wordChars, int cur, boolean[][] visited) {

        if (has || cur == wordChars.length) {
            has = true;
            return;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != wordChars[cur] || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(board, i + 1, j, wordChars, cur + 1, visited);
        dfs(board, i, j + 1, wordChars, cur + 1, visited);
        dfs(board, i - 1, j, wordChars, cur + 1, visited);
        dfs(board, i, j - 1, wordChars, cur + 1, visited);

        visited[i][j] = false;
    }

    @Test
    public void demo() {
        this.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
    }
}
