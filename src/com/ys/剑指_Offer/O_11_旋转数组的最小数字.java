package com.ys.剑指_Offer;

/**
 * @author HuaDong
 * @date 2021/7/23 21:17
 */
public class O_11_旋转数组的最小数字 {
    public static int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (numbers[mid] < numbers[r]) {
                r = mid;
            } else if (numbers[mid] > numbers[r]) {
                l = mid + 1;
            } else {
                if (numbers[mid] == numbers[l]) {
                    l++;
                    r--;
                } else {
                    r = mid;
                }
            }
        }

        return numbers[r];
    }

    public static void main(String[] args) {
        minArray(new int[]{10, 1, 10, 10, 10});
    }
}
