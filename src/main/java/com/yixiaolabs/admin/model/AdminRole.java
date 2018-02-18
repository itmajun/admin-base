package com.yixiaolabs.admin.model;

import javax.persistence.*;

@Table(name = "admin_role")
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer admins;
    private Integer roles;

    /**
     * @return admins
     */
    public Integer getAdmins() {
        return admins;
    }

    /**
     * @param admins
     */
    public void setAdmins(Integer admins) {
        this.admins = admins;
    }

    /**
     * @return roles
     */
    public Integer getRoles() {
        return roles;
    }

    /**
     * @param roles
     */
    public void setRoles(Integer roles) {
        this.roles = roles;
    }
}