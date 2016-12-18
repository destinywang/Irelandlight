package com.irelandlight.vo;

import java.util.List;

/**
 * Created by lenovo on 2016/12/8.
 */
public class MessageBackHome {

    private List<ConsumerCustomRecently> userList;
    private ProductorCustom administratorinfo;
    private List<NewsHistory> sendAllHistory;

    public List<ConsumerCustomRecently> getUserList() {
        return userList;
    }

    public void setUserList(List<ConsumerCustomRecently> userList) {
        this.userList = userList;
    }

    public ProductorCustom getAdministratorinfo() {
        return administratorinfo;
    }

    public void setAdministratorinfo(ProductorCustom administratorinfo) {
        this.administratorinfo = administratorinfo;
    }

    public List<NewsHistory> getSendAllHistory() {
        return sendAllHistory;
    }

    public void setSendAllHistory(List<NewsHistory> sendAllHistory) {
        this.sendAllHistory = sendAllHistory;
    }
}
