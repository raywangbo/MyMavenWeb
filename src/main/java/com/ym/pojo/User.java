package com.ym.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Ray on 2017/10/19.
 */
public class User {
    private Long id;                //用户id
    private String account;         //用户账号
    private String name;            //用户名称
    private String fullName;        //用户全名
    private String pswd;            //用户密码
    private String role;            //用户角色
    private Timestamp createTime; //用户创造时间
    private Timestamp lastLoginTime;   //用户最后登录时间
    private String status;            //用户状态

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", pswd='" + pswd + '\'' +
                ", role='" + role + '\'' +
                ", createTime=" + createTime +
                ", lastLoginTime=" + lastLoginTime +
                ", status=" + status +
                '}';
    }
}
