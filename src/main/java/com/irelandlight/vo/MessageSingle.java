package com.irelandlight.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 后台单人聊天页面渲染数据
 * Created by lenovo on 2016/12/9.
 */
public class MessageSingle {

    private ConsumerCustomSingle userinfo;
    private List<PurchaseHistory> purchaseHistory = new ArrayList<PurchaseHistory>();
    private ProductorCustom administratorinfo;

    public ConsumerCustomSingle getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(ConsumerCustomSingle userinfo) {
        this.userinfo = userinfo;
    }

    public List<PurchaseHistory> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<PurchaseHistory> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }

    public ProductorCustom getAdministratorinfo() {
        return administratorinfo;
    }

    public void setAdministratorinfo(ProductorCustom administratorinfo) {
        this.administratorinfo = administratorinfo;
    }
}
