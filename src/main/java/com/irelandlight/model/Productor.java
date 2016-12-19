package com.irelandlight.model;

import java.util.Date;

/**
 * Created by mac on 2016/12/3.
 */
public class Productor {
    private Long id;                //
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最近一次更新时间
    private Integer visibility;     //是否逻辑删除
    private String userName;        //管理员名
    private String password;        //管理员密码
    private String salt;            //盐值

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
