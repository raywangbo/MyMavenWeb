package com.ym.pojo;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 用户权限角色
 *
 * @auther Administrator Ray
 * @create 2017/10/31
 */
public class UserRole implements Serializable {
    private Long id;        //角色ID
    private String name;    //角色名称
    private String type;    //角色类型
    private List<UserPermission> permissions = new LinkedList<>();//权限集合

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<UserPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<UserPermission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", permissions=" + permissions +
                '}';
    }
}
