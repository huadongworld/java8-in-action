package com.ys.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * @author HuaDong
 * @date 2021/5/23 21:14
 */
public class H_51_N皇后 {

    @Test
    public void demo() {
        this.solveNQueens4(4);
    }


    /**
     * 方法一：回溯
     * 方案：每一行&每一列必定存在一个皇后，这里以每一行作为回溯遍历
     */
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens3(int n) {
        //初始化棋盘
        char[][] chessboard = new char[n][n];
        for (char[] line : chessboard) {
            Arrays.fill(line, '.');
        }
        backTrack(chessboard, n, 0);
        return res;
    }

    private void backTrack(char[][] chessboard, int n, int row) {
        if (row == chessboard.length) {
            List<String> copyBoard = new ArrayList<>();
            for (char[] line : chessboard) {
                copyBoard.add(String.valueOf(line));
            }
            res.add(copyBoard);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (!isValid(chessboard, n, row, col)) {
                continue;
            }

            chessboard[row][col] = 'Q';
            backTrack(chessboard, n, row + 1);
            chessboard[row][col] = '.';

        }
    }

    private boolean isValid(char[][] chessboard, int n, int row, int col) {

        // 判断列是否存在皇后
        for (int r = 0; r < n; r++) {
            if (chessboard[r][col] == 'Q') {
                return false;
            }
        }

        // 判断右上方（斜线）是否存在皇后
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 判断左上方（斜线）是否存在皇后
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    List<List<String>> board = new ArrayList<>();

    public List<List<String>> solveNQueens4(int n) {

        int[] q = new int[n];
        Arrays.fill(q, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> upDiagonal = new HashSet<>();
        Set<Integer> downDiagonal = new HashSet<>();

        dfs(q, 0, n, columns, upDiagonal, downDiagonal);

        return board;
    }

    private void dfs(int[] q, int row, int n, Set<Integer> columns, Set<Integer> upDiagonal, Set<Integer> downDiagonal) {
        if (row == n) {
            // 生成棋盘
            createBoard(q);
            return;
        }

        for (int i = 0; i < n; i++) {

            // 判断同列是否存在皇后
            if (columns.contains(i)) {
                continue;
            }

            int upVal = row + i;
            if (upDiagonal.contains(upVal)) {
                continue;
            }

            int downVal = row - i;
            if (downDiagonal.contains(downVal)) {
                continue;
            }

            columns.add(i);
            upDiagonal.add(upVal);
            downDiagonal.add(downVal);
            q[row] = i;
            dfs(q, row + 1, n, columns, upDiagonal, downDiagonal);
            columns.remove(i);
            upDiagonal.remove(upVal);
            downDiagonal.remove(downVal);
            q[row] = -1;
        }
    }

    private void createBoard(int[] q) {
        int n = q.length;

        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[q[i]] = 'Q';
            tmp.add(new String(row));
        }

        board.add(tmp);
    }
}
