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
@ResponseBody
@RequestMapping(value = "login")
public class UserLoginController {

    @Resource
    UserService userService;

    @RequestMapping(value = "/userLogin")
    public String userLogin(String account , String pswd) {
        if (account != null) {
            User user;
//            ModelAndView modelAndView = new ModelAndView();
            user = userService.findUserByAccount(account);
            user.setPswd(pswd);
            if (userService.userLogin(user) == 1) {
//                modelAndView.setViewName("index");
                System.out.println(user.getLast_login_time());
                return user.toString();
            } else {
//                modelAndView.setViewName("login");
                return "登录失败";
            }
        }
        return null;
    }
}
