package com.irelandlight.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by mac on 2016/12/12.
 */
public class OrderDetail {
    private Long orderId;       //订单id
    private String orderNo;     //订单编号
    private Long userId;        //用户的id
    private Integer transferWay; //配送方式
    private Date createTime;    //下单时间
    private Integer status;     //订单当前状态
    private Date transferBegin;  //配货时间
    private String transferTime;  //配货时间
    private Date transferEnd;   //收获时间
    private BigDecimal orderSum;    //订单总金额
    private String userName;    //收收货人姓名
    private String detail;     //收货人地址
    private String province;      //省
    private String city;            //城市
    private String district;        //区
    private String street;          //街道
    private String post;            //邮编
    private String telephone;    //收货人联系方式
    private String remark;          // 顾客备注信息

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }




    public Date getTransferBegin() {
        return transferBegin;
    }

    public void setTransferBegin(Date transferBegin) {
        this.transferBegin = transferBegin;
    }

    public String getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(String transferTime) {
        this.transferTime = transferTime;
    }

    public Date getTransferEnd() {
        return transferEnd;
    }

    public void setTransferEnd(Date transferEnd) {
        this.transferEnd = transferEnd;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getTransferWay() {
        return transferWay;
    }

    public void setTransferWay(Integer transferWay) {
        this.transferWay = transferWay;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(BigDecimal orderSum) {
        this.orderSum = orderSum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



}
