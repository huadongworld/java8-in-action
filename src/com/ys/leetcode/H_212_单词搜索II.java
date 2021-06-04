package com.ys.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuaDong
 * @date 2021/6/2 19:33
 */
public class H_212_单词搜索II {

    class Trie {
        String val;
        Trie[] son;
        boolean end;
        final int R = 26;

        public Trie() {
            son = new Trie[R];
        }

        private void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.son[index] == null) {
                    node.son[index] = new Trie();
                }
                node = node.son[index];
            }
            node.val = word;
            node.end = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        int m = words.length;
        Trie root = new Trie();
        for (int i = 0; i < m; i++) {
            root.insert(words[i]);
        }

        List<String> res = new ArrayList<>();
        int row = board.length, col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean[][] visited = new boolean[row][col];
                dfs(board, i, j, visited, root, res);
            }
        }

        return res;
    }

    private void dfs(char[][] board, int i, int j, boolean[][] visited, Trie root, List<String> res) {

        if (root.end) {
            res.add(root.val);
            root.end = false;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return;
        }

        char c = board[i][j];
        int index = c - 'a';
        if (root.son[index] == null) {
            return;
        }

        visited[i][j] = true;

        dfs(board, i + 1, j, visited, root.son[index], res);
        dfs(board, i, j + 1, visited, root.son[index], res);
        dfs(board, i - 1, j, visited, root.son[index], res);
        dfs(board, i, j - 1, visited, root.son[index], res);

        visited[i][j] = false;
    }

    @Test
    public void demo() {
        this.findWords(new char[][]{
                        {'a'}},
                new String[]{"a"});
    }
}
