package com.ym.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

import java.io.Serializable;

public class ShiroToken extends UsernamePasswordToken implements Serializable {

    private static final Long serialVersionUID = -6451794657814516274L;

    public ShiroToken(String account, String pswd){
        super(account,pswd);
        this.pswd = pswd;
    }

    private String pswd;//登录密码

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

}
