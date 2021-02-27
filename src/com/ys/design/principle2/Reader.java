package com.ys.design.principle2;

/**
 * 读者只开放博客阅读接口
 *
 * @author HuaDong
 * @since 2021/2/26 14:25
 */
public class Reader implements ReadBlog {
    @Override
    public String getBlog() {
        return null;
    }
}
