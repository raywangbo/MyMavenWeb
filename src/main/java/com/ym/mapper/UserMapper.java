package com.ym.mapper;

import com.ym.pojo.User;

/**
 * Created by Ray on 2017/10/20.
 */
public interface UserMapper {
    Integer userLogin(User user);//通过用户信息查找用户

    User findUserByAccount(String account);//通过账户查找用户

    Integer insertUser(User user);//插入用户信息
}
