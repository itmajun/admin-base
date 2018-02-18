package com.yixiaolabs.admin.model;

import javax.persistence.*;

public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限的名称
     */
    private String name;

    private String type;

    /**
     * 系统默认权限
     */
    private Boolean choose;

    /**
     * 权限
     */
    private String authorities;

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
     * 获取权限的名称
     *
     * @return name - 权限的名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置权限的名称
     *
     * @param name 权限的名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取系统默认权限
     *
     * @return choose - 系统默认权限
     */
    public Boolean getChoose() {
        return choose;
    }

    /**
     * 设置系统默认权限
     *
     * @param choose 系统默认权限
     */
    public void setChoose(Boolean choose) {
        this.choose = choose;
    }

    /**
     * 获取权限
     *
     * @return authorities - 权限
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * 设置权限
     *
     * @param authorities 权限
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }
}