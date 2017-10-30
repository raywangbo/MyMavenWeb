package com.ym.shiro.filter;

import com.ym.pojo.User;
import com.ym.shiro.token.TokenManager;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 判断登录状态
 *
 * @auther Administrator Ray
 * @create 2017/10/30
 */
public class LoginFilter extends AccessControlFilter{
    final static Class<LoginFilter> CLASS = LoginFilter.class;
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object o) throws Exception {
        User user = TokenManager.getToken();
        return null != user || isLoginRequest(request, response);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        //保存Response和Request到登陆后的链接
        saveRequestAndRedirectToLogin(request, response);
        return false;
    }
}
