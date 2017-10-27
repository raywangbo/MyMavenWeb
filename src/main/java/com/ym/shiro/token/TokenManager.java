package com.ym.shiro.token;

import com.ym.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;

import java.util.List;

/**
 * Token的工具类
 */
public class TokenManager {

    /**
     * 获取当前登录用户的User对象
     * @return
     */
    public static User getToken(){
        return (User) SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前用户的Session
     * @return
     */
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 获取当前用户姓名
     * @return
     */
    public static String getName(){
        return getToken().getName();
    }

    /**
     * 获取当前用户的ID
     * @return
     */
    public static  Long getUserId(){
        return getToken().getId();
    }

    /**
     * 把值放入当前登录用户的session
     * @param key
     * @param value
     */
    public static void setVal2Session(Object key, Object value){
        getSession().setAttribute(key ,value);
    }

    /**
     * 从当前登录用户的session里取值
     * @param key
     * @return
     */
    public static Object getValFromSession(Object key){
        return getSession().getAttribute(key);
    }

    /**
     * 登录
     * @param user
     * @param rememberMe
     * @return
     */
    public static User login(User user, String rememberMe){
        ShiroToken shiroToken = new ShiroToken(user.getAccount(),user.getPswd());
        shiroToken.setRememberMe(!rememberMe.equals(null));
        SecurityUtils.getSubject().login(shiroToken);
        return getToken();
    }

    /**
     * 判断是否登录
     * @return
     */
    public static boolean isLogin(){
        return null != SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 退出登录
     */
    public static void logout(){
        SecurityUtils.getSubject().logout();
    }

    /**
     * 根据userIds清空权限信息
     * @param userIds 用户ID
     */
    public static void clearUserAuthByUserId(Long...userIds){
        if(null == userIds || userIds.length == 0) return;

    }
}
