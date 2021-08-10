package com.ys.剑指_Offer;

/**
 * @author HuaDong
 * @date 2021/7/20 21:14
 */
public class O_04_二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        int x = matrix.length;
        if (x == 0) {
            return false;
        }
        int y = matrix[0].length;
        int i = 0, j = y - 1;

        while (i < x && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
