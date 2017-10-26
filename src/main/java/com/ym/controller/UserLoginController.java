package com.ym.controller;


import com.ym.pojo.User;
import com.ym.service.UserService;
import com.ym.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ray on 2017/10/23.
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
    public void userLogin(HttpServletResponse response, HttpServletRequest request, String account , String pswd) throws Exception {
        if (account != null) {
            User user;
            user = userService.findUserByAccount(account);
            user.setPswd(pswd);
            if (userService.userLogin(user) == 1) {
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
           return "index";
        }
        return "-1";
    }
}
