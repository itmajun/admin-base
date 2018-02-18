package com.yixiaolabs.admin.model;

import javax.persistence.*;

@Table(name = "role_auth")
public class RoleAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色id
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "auth_id")
    private Integer authId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色id
     *
     * @return role_id - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取权限id
     *
     * @return auth_id - 权限id
     */
    public Integer getAuthId() {
        return authId;
    }

    /**
     * 设置权限id
     *
     * @param authId 权限id
     */
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }
}