package com.ys.design.principle2;

/**
 * 管理员有博客的所有权限
 *
 * @author HuaDong
 * @since 2021/2/26 14:26
 */
public class AdminUser implements ReadBlog, AdminBlog {

    @Override
    public Boolean insertBlog() {
        return null;
    }

    @Override
    public Boolean updateBlog() {
        return null;
    }

    @Override
    public Boolean deleteBlog() {
        return null;
    }

    @Override
    public String getBlog() {
        return null;
    }
}
