package com.ys.剑指_Offer;

/**
 * @author HuaDong
 * @date 2021/7/20 21:33
 */
public class O_05_替换空格 {
    public static String replaceSpace(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 32) {
                String start = s.substring(0, i);
                String end = s.substring(i + 1, len);
                s = start + "%20" + end;
                len += 2;
                i += 2;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        replaceSpace("We are happy.");
    }
}
