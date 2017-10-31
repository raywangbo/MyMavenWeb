package com.ym.mapper;


import com.ym.pojo.UserRole;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @auther Administrator Ray
 * @create 2017/10/31
 */
public interface UserRoleMapper {
    int deleteByKey(Long id);

    int insertRole(UserRole userRole);

    int insertSelective(UserRole userRole);

    UserRole selectByKey(Long id);

    int updateByKeySelective(UserRole userRole);

    int updateByKey(UserRole userRole);

    Set<String> findRoleByUserId(Long id);

    List<UserRole> findNowAllPermission(Map<String, Object> map);

    void initData();
}
