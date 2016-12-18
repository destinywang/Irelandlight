package com.irelandlight.vo;

import java.util.List;

/**
 * 站内信后台单人客服页面
 * Created by lenovo on 2016/12/10.
 */
public class MessageSingleBack {

    private ConsumerCustomSingle userinfo;
    private List<PurchaseHistory> purchaseHistory;
    private List<MessageCustom> receive;
    private ProductorCustom administatorinfo;

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

    public List<MessageCustom> getReceive() {
        return receive;
    }

    public void setReceive(List<MessageCustom> receive) {
        this.receive = receive;
    }

    public ProductorCustom getAdministatorinfo() {
        return administatorinfo;
    }

    public void setAdministatorinfo(ProductorCustom administatorinfo) {
        this.administatorinfo = administatorinfo;
    }
}
