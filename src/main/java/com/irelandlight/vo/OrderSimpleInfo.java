package com.irelandlight.vo;

import java.util.Date;

/**
 * Created by mac on 2016/12/6.
 */
public class OrderSimpleInfo {
    private Long id;
    private Date createTime;        //下单时间
    private Long consumerId;        //消费者id做逻辑外键
    private String usrName;         //客户账号
    private String orderNumber;     //订单编号
    private Integer orderStatus;         //订单状态

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }


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

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
