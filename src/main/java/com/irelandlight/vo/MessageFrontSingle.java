package com.irelandlight.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 前台单人客服页面
 * Created by lenovo on 2016/12/10.
 */
public class MessageFrontSingle {

    private String productorName;
    private String consumerHeadUrl;
    private List<MessageCustom> messageList = new ArrayList<MessageCustom>();

    public String getProductorName() {
        return productorName;
    }

    public void setProductorName(String productorName) {
        this.productorName = productorName;
    }

    public String getConsumerHeadUrl() {
        return consumerHeadUrl;
    }

    public void setConsumerHeadUrl(String consumerHeadUrl) {
        this.consumerHeadUrl = consumerHeadUrl;
    }

    public List<MessageCustom> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageCustom> messageList) {
        this.messageList = messageList;
    }
}
