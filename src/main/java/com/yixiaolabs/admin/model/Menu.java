package com.yixiaolabs.admin.model;

import javax.persistence.*;

public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    /**
     * 1:sys 2:app 3:ext
     */
    private Integer type;

    @Column(name = "parent_id")
    private Integer parentId;

    private String url;

    private Integer sorder;

    private String appid;

    private String icon;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取1:sys 2:app 3:ext
     *
     * @return type - 1:sys 2:app 3:ext
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1:sys 2:app 3:ext
     *
     * @param type 1:sys 2:app 3:ext
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return parent_id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return sorder
     */
    public Integer getSorder() {
        return sorder;
    }

    /**
     * @param sorder
     */
    public void setSorder(Integer sorder) {
        this.sorder = sorder;
    }

    /**
     * @return appid
     */
    public String getAppid() {
        return appid;
    }

    /**
     * @param appid
     */
    public void setAppid(String appid) {
        this.appid = appid;
    }

    /**
     * @return icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * @param icon
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }
}