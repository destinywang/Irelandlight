package com.irelandlight.model;

import java.util.Date;

/**
 * Created by Zichu on 2016/12/11.
 */
public class Reply {
    private Long id;
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最后更新时间
    private Integer visibility;     //表示是否已删除
    private Long sourceId;          //表示源目标评论id
    private String reply;           //表示回复内容
    private Long fromId;            //表示回复者Id
    private Long toId;              //表示被回复的Id

    public Long getId() {
        return id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public String getReply() {
        return reply;
    }

    public Long getFromId() {
        return fromId;
    }

    public Long getToId() {
        return toId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public void setFromId(Long fromId) {
        this.fromId = fromId;
    }

    public void setToId(Long toId) {
        this.toId = toId;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", lastUpdate=" + lastUpdate +
                ", visibility=" + visibility +
                ", sourceId=" + sourceId +
                ", reply='" + reply + '\'' +
                ", fromId=" + fromId +
                ", toId=" + toId +
                '}';
    }
}
