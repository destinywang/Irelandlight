package com.irelandlight.model;

import org.relaxng.datatype.DatatypeException;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by mac on 2016/12/3.
 */
public class Order {
    private Long id;
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最后更新时间
    private Integer visibility;     //表示是否已删除
    private String orderNumber;     //订单编号
    private Long consumerId;        //消费者id做逻辑外键
    private Long addressId;         //地址id做逻辑外键
    private Integer payWay;         //支付方式
    private Integer transferWay;    //配送方式
    private String transferTime;    //用户期望的配送时间
    private String gift;            //用户期望的附赠礼物
    private Integer tableWareCount; //附赠餐具数
    private Long couponId;        //活动表id做逻辑外键
    private BigDecimal price;       //订单费用
    private Date transferBegin;     //配送开始时间
    private Date transferEnd;       //配送结束时间
    private Integer status;         //订单状态
    private String remark;          //消费者的留言

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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Integer getPayWay() {
        return payWay;
    }

    public void setPayWay(Integer payWay) {
        this.payWay = payWay;
    }

    public Integer getTransferWay() {
        return transferWay;
    }

    public void setTransferWay(Integer transferWay) {
        this.transferWay = transferWay;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public Integer getTableWareCount() {
        return tableWareCount;
    }

    public void setTableWareCount(Integer tableWareCount) {
        this.tableWareCount = tableWareCount;
    }

    public Long getCouponId() {
        return couponId;
    }

    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getTransferBegin() {
        return transferBegin;
    }

    public void setTransferBegin(Date transferBegin) {
        this.transferBegin = transferBegin;
    }

    public Date getTransferEnd() {
        return transferEnd;
    }

    public void setTransferEnd(Date transferEnd) {
        this.transferEnd = transferEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
