package com.irelandlight.vo;

import java.util.Date;

/**
 * Created by lenovo on 2016/12/9.
 */
public class PurchaseHistory {

    private Date buyDate;
    private String buyGoods;

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public String getBuyGoods() {
        return buyGoods;
    }

    public void setBuyGoods(String buyGoods) {
        this.buyGoods = buyGoods;
    }

    @Override
    public String toString() {
        return "PurchaseHistory{" +
                "buyDate=" + buyDate +
                ", buyGoods='" + buyGoods + '\'' +
                '}';
    }
}
