package com.irelandlight.model.vo;

/**
 * Created by Zichu on 2016/12/11.
 */
public class ReplyVO {
    private String replyContent;
    private int sourceId;
    private String fromNickName;
    private String toNickName;
    private int replyId;


    public String getReplyContent() {
        return replyContent;
    }

    public int getSourceId() {
        return sourceId;
    }

    public String getFromNickName() {
        return fromNickName;
    }

    public String getToNickName() {
        return toNickName;
    }

    public int getReplyId() {
        return replyId;
    }



    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public void setFromNickName(String fromNickName) {
        this.fromNickName = fromNickName;
    }

    public void setToNickName(String toNickName) {
        this.toNickName = toNickName;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    @Override
    public String toString() {
        return "ReplyVO{" +
                "replyContent='" + replyContent + '\'' +
                ", sourceId=" + sourceId +
                ", fromNickName='" + fromNickName + '\'' +
                ", toNickName='" + toNickName + '\'' +
                ", replyId=" + replyId +
                '}';
    }
}
