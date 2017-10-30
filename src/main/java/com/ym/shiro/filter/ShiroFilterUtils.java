package com.ym.shiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

/**
 * ShiroFilter工具类
 *
 * @auther Administrator Ray
 * @create 2017/10/30
 */
public class ShiroFilterUtils {
    /**
     * 判断是否是Ajax请求
     * @param request
     * @return
     */
    public static boolean isAjax(ServletRequest request){
        return "XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest)request).getHeader("X-Requested-With"));
    }
}
