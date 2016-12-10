package com.irelandlight.model.vo;

/**
 * Created by Zichu on 2016/12/8.
 */
public class CommentFrom {
    private int id;                     //评论的id
    private String commentContent;     //评论内容
    private String fromName;          //评论来源
    private int commentId;            //被评论的评论id

    public int getId() {
        return id;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public String getFromName() {
        return fromName;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "CommentFrom{" +
                "id=" + id +
                ", commentContent='" + commentContent + '\'' +
                ", fromName='" + fromName + '\'' +
                ", commentId=" + commentId +
                '}';
    }
}
