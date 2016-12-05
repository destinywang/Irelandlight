package com.irelandlight.model;

import java.util.Date;

/**
 * Created by mac on 2016/12/3.
 */
public class LoginTicket {
    private Long id;                //
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最近一次更新时间
    private Integer visibility;     //是否逻辑删除
    private Long consumerId;        //消费者表主键做逻辑外键，与productor_id互斥
    private Long productorId;       //管理者表主键做逻辑外键，与consumer_id互斥
    private Date expired;           //过期时间
    private String ticket;          //用户登录凭据
    private Integer status;         //ticket状态

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

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getProductorId() {
        return productorId;
    }

    public void setProductorId(Long productorId) {
        this.productorId = productorId;
    }

    public Date getExpired() {
        return expired;
    }

    public void setExpired(Date expired) {
        this.expired = expired;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
