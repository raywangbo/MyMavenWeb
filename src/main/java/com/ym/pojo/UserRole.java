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
    private String code;
    private String name;    //角色名称

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


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name +
                '}';
    }
}
