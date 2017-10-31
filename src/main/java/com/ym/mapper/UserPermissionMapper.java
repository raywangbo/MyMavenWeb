package com.ym.mapper;

import com.ym.pojo.UserPermission;

import java.util.List;
import java.util.Set;

/**
 * ${DESCRIPTION}
 *
 * @auther Administrator Ray
 * @create 2017/10/31
 */
public interface UserPermissionMapper {
    int deleteByKey(Long id);

    int insertPermission(UserPermission userPermission);

    UserPermission selectPermisionByKey(Long id);

    int updateByKeySelective(UserPermission userPermission);

    int updateByKey(UserPermission userPermission);

    //List<UPermissionBo> selectPermissionById(Long id);
    //根据用户ID获取权限的Set集合
    Set<String> findPermissionByUserId(Long id);
}
