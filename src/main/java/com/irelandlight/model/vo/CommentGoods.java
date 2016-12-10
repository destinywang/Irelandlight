package com.irelandlight.model.vo;

/**
 * Created by Zichu on 2016/12/8.
 */
public class CommentGoods {
    private String consumerName;
    private String goodsContent;
    private int commentId;

    public String getConsumerName() {
        return consumerName;
    }

    public String getGoodsContent() {
        return goodsContent;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setConsumerName(String consumerName) {
        this.consumerName = consumerName;
    }

    public void setGoodsContent(String goodsContent) {
        this.goodsContent = goodsContent;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "CommentGoods{" +
                "consumerName='" + consumerName + '\'' +
                ", goodsContent='" + goodsContent + '\'' +
                ", commentId=" + commentId +
                '}';
    }
}
