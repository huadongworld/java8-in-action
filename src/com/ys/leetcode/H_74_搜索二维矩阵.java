package com.ys.leetcode;

import org.junit.Test;

/**
 * @author HuaDong
 * @date 2021/5/29 10:17
 */
public class H_74_搜索二维矩阵 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        // 二分搜索到合适的行
        int l = 0, r = m - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (target > matrix[mid][n - 1]) {
                l = mid + 1;
            } else if (target < matrix[mid][0]) {
                r = mid - 1;
            } else {
                l = mid;
                break;
            }
        }

        // 获取查找行，继续二分查找指定元素
        int le = 0, ri = matrix[l].length - 1;
        while (le < ri) {
            int mid = (ri + le) / 2;
            if (matrix[l][mid] < target) {
                le = mid + 1;
            } else if (matrix[l][mid] > target) {
                ri = mid - 1;
            } else {
                return true;
            }
        }
        return matrix[l][le] == target;
    }

    @Test
    public void demo() {
        this.searchMatrix(new int[][]{{1, 1}}, 3);
    }
}
