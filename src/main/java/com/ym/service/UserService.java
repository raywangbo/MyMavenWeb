package com.ym.service;

import com.ym.pojo.User;

/**
 * Created by Ray on 2017/10/23.
 */

public interface UserService {

    Integer userLogin(User user);//通过用户信息查找用户

    User findUserByAccount(String account);//通过账户查找用户

    String insertUser(User user);//新增用户信息
}
