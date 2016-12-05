package com.irelandlight.model;

import java.util.Date;

/**
 * Created by mac on 2016/12/3.
 */
public class Coupon {
    private Long id;                //
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最近一次更新时间
    private Integer visibility;     //是否逻辑删除
    private Long target;            //消费金额
    private Long reduce;            //优惠金额
    private Long consumerId;        //消费者表主键做逻辑外键
    private String content;         //满减券内容

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

    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
    }

    public Long getReduce() {
        return reduce;
    }

    public void setReduce(Long reduce) {
        this.reduce = reduce;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
