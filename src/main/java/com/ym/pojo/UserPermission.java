package com.ym.pojo;

import java.io.Serializable;

/**
 * 用户权限
 *
 * @auther Administrator Ray
 * @create 2017/10/31
 */
public class UserPermission implements Serializable{
    private Long id;        //权限id
    private String url;     //权限URL
    private String name;    //权限名称

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserPermissionMapper{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
