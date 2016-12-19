package com.irelandlight.model.vo;

/**
 * Created by Zichu on 2016/12/11.
 */
public class CommentGoods {
    private int commentId;
    private String goodsContent;
    private String consumerName;

    public int getCommentId() {
        return commentId;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public String getConsumerName() {
        return consumerName;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    @Override
    public String toString() {
        return "CommentGoods{" +
                "commentId=" + commentId +
                ", goodsContent='" + goodsContent + '\'' +
                ", consumerName='" + consumerName + '\'' +
                '}';
    }
}
