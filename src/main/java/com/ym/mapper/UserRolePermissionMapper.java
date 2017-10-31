package com.ym.mapper;

import com.ym.pojo.UserRolePermission;

import java.util.List;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @auther Administrator Ray
 * @create 2017/10/31
 */
public interface UserRolePermissionMapper {
    int insertRP(UserRolePermission record);

    int insertSelective(UserRolePermission record);

    List<UserRolePermission> findRolePermissionByPid(Long id);

    List<UserRolePermission> findRolePermissionByRid(Long id);

    List<UserRolePermission> findRP(UserRolePermission entity);

    int deleteByPid(Long id);
    int deleteByRid(Long id);
    int deleteRP(UserRolePermission entity);

    int deleteByRids(Map<String,Object> resultMap);
}
