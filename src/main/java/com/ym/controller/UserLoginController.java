package com.ym.controller;


import com.ym.pojo.User;
import com.ym.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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
    public String userLogin(String account , String pswd) {
        if (account != null) {
            User user;
//            ModelAndView modelAndView = new ModelAndView();
            user = userService.findUserByAccount(account);
            user.setPswd(pswd);
            if (userService.userLogin(user) == 1) {
//                modelAndView.setViewName("index")
                return "index";
            } else {
//                modelAndView.setViewName("login");
                return "-1";
            }
        }
        return null;
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
            user.setPswd(pswd);
            user.setStatus("1");
           return "index";
        }
        return "-1";
    }
}
