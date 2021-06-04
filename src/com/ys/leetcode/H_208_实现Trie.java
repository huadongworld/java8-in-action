package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/6/1 19:37
 */
public class H_208_实现Trie {

    class Trie {

        private Trie[] children;
        private final Integer R = 26;
        private boolean end;

        Trie() {
            children = new Trie[R];
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.end = true;
        }

        public boolean search(String word) {
            Trie node = this.searchWith(word);
            return node != null && node.end;
        }

        public boolean startsWith(String word) {
            Trie node = this.searchWith(word);
            return node != null;
        }

        private Trie searchWith(String word) {

            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] != null) {
                    node = node.children[index];
                } else {
                    return null;
                }
            }

            return node;
        }
    }
}
