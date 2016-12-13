package com.irelandlight.vo;

import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/14.
 */
public class OrderInfo {
    private Integer orderUnhandle;
    private Integer orderUnpay;
    private Integer orderUndispatch;
    private Integer orderSucceed;
    private Integer orderCanceled;
    private List<Map<Object,Object>> orderDetailByMonth;


    public Integer getOrderUnhandle() {
        return orderUnhandle;
    }

    public void setOrderUnhandle(Integer orderUnhandle) {
        this.orderUnhandle = orderUnhandle;
    }

    public Integer getOrderUnpay() {
        return orderUnpay;
    }

    public void setOrderUnpay(Integer orderUnpay) {
        this.orderUnpay = orderUnpay;
    }

    public Integer getOrderUndispatch() {
        return orderUndispatch;
    }

    public void setOrderUndispatch(Integer orderUndispatch) {
        this.orderUndispatch = orderUndispatch;
    }

    public Integer getOrderSucceed() {
        return orderSucceed;
    }

    public void setOrderSucceed(Integer orderSucceed) {
        this.orderSucceed = orderSucceed;
    }

    public Integer getOrderCanceled() {
        return orderCanceled;
    }

    public void setOrderCanceled(Integer orderCanceled) {
        this.orderCanceled = orderCanceled;
    }

    public List<Map<Object, Object>> getOrderDetailByMonth() {
        return orderDetailByMonth;
    }

    public void setOrderDetailByMonth(List<Map<Object, Object>> orderDetailByMonth) {
        this.orderDetailByMonth = orderDetailByMonth;
    }
}
