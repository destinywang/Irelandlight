package com.irelandlight.vo;

import java.util.Date;

/**
 * Created by mac on 2016/12/13.
 */
public class OrderModify {
    private Integer orderStatus;
    private Date transferBegin;
    private Date transferEnd;
    private Integer transferWay;

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
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

    public Integer getTransferWay() {
        return transferWay;
    }

    public void setTransferWay(Integer transferWay) {
        this.transferWay = transferWay;
    }
}
