package com.ym.pojo;

import java.util.Date;

/**
 * Created by Ray on 2017/10/19.
 */
public class User {
    private Long id;                //用户id
    private String account;         //用户账号
    private String name;            //用户名称
    private String pswd;            //用户密码
    private String role;            //用户角色
    private Date createTime; //用户创造时间
    private Date lastlLoginTime;   //用户最后登录时间
    private Long status;            //用户状态

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastlLoginTime() {
        return lastlLoginTime;
    }

    public void setLastlLoginTime(Date lastlLoginTime) {
        this.lastlLoginTime = lastlLoginTime;
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", pswd='" + pswd + '\'' +
                ", role='" + role + '\'' +
                ", createTime=" + createTime +
                ", lastlLoginTime=" + lastlLoginTime +
                ", status=" + status +
                '}';
    }
}
