package com.ym.pojo;

/**
 * 用户角色以及权限的对照表
 *
 * @auther Administrator Ray
 * @create 2017/10/31
 */
public class UserRolePermission {
    Long rId;   //角色ID
    Long pId;   //权限ID

    public UserRolePermission(Long rId, Long pId) {
        this.rId = rId;
        this.pId = pId;
    }

    public Long getrId() {
        return rId;
    }

    public void setrId(Long rId) {
        this.rId = rId;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "UserRolePermissionMapper{" +
                "rId=" + rId +
                ", pId=" + pId +
                '}';
    }
}
