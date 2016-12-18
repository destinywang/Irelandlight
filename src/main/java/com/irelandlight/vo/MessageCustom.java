package com.irelandlight.vo;

/**
 * Created by lenovo on 2016/12/6.
 */
public class MessageCustom {

    private Long fromId;            //发送方的逻辑外键
    private Long toId;              //接收方主键
    private String content;         //消息内容
    private Integer type;           //消息类型，0为文本，1为图片

    public Long getFromId() {
        return fromId;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
