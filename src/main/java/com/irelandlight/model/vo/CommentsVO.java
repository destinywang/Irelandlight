package com.irelandlight.model.vo;

import java.util.List;

/**
 * Created by Zichu on 2016/12/11.
 */
public class CommentsVO {
    private CommentGoods commentGoods;
    private List<ReplyVO> replyVOs;

    public CommentGoods getCommentGoods() {
        return commentGoods;
    }

    public List<ReplyVO> getReplyVOs() {
        return replyVOs;
    }

    public void setCommentGoods(CommentGoods commentGoods) {
        this.commentGoods = commentGoods;
    }

    public void setReplyVOs(List<ReplyVO> replyVOs) {
        this.replyVOs = replyVOs;
    }

    @Override
    public String toString() {
        return "CommentsVO{" +
                "commentGoods=" + commentGoods +
                ", replyVOs=" + replyVOs +
                '}';
    }
}
