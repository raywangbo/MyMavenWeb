package com.ym.controller;


import com.ym.pojo.User;
import com.ym.service.UserService;
import com.ym.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ray on 2017/10/23.
 * 响应用户登录及注册动作
 */

@Controller
@RequestMapping(value = "login")
public class UserLoginController {

    @Resource
    UserService userService;

    /**
     * 处理用户登录请求
     * @param account 账户
     * @param pswd  密码
     * @return
     */
    @RequestMapping(value = "/userLogin")
    public void userLogin(HttpServletResponse response, HttpServletRequest request, String account , String pswd, String rememberMe) throws Exception {
        if (account != null) {
            User user;
            user = userService.findUserByAccount(account);
            if (MD5Util.verify(pswd,user.getPswd())) {
                System.out.println("["+rememberMe+"]");
                System.out.println();
                response.sendRedirect("/index.html");
                //request.getRequestDispatcher("login/index.html").forward(request,response);
            }
        }
    }

    /**
     * 处理用户注册请求
     * @return
     */
    @RequestMapping(value = "/userRegister")
    public String userRegister(String fullName, String userName, String userAccount, String pswd){
        if(userAccount != null && pswd != null){
            User user = new User();
            user.setFullName(fullName);
            user.setName(userName);
            user.setAccount(userAccount);
            user.setPswd(MD5Util.generate(pswd));
            user.setStatus("1");
            userService.insertUser(user);
           return "index";
        }
        return "-1";
    }
}
