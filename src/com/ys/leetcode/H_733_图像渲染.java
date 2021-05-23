package com.ys.leetcode;

/**
 * @author HuaDong
 * @date 2021/5/23 14:06
 */
public class H_733_图像渲染 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        dfs(image, sr, sc, newColor, image[sr][sc]);

        return image;

    }

    void dfs(int[][] image, int sr, int sc, int newColor, int oldColor) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length
                || image[sr][sc] != oldColor || newColor == oldColor){
            return;
        }

        image[sr][sc] = newColor;

        dfs(image, sr - 1, sc, newColor, oldColor);
        dfs(image, sr + 1, sc, newColor, oldColor);
        dfs(image, sr, sc - 1, newColor, oldColor);
        dfs(image, sr, sc + 1, newColor, oldColor);

    }
}
