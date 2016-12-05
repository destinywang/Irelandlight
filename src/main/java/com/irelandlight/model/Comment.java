package com.irelandlight.model;

import java.util.Date;

/**
 * Created by mac on 2016/12/3.
 */
public class Comment {
    private Long id;
    private Date createTime;        //创建时间
    private Date lastUpdate;        //最后更新时间
    private Integer visibility;     //表示是否已删除
    private String content;         //评论内容
    private Long consumerId;        //消费者表主键做逻辑外键，与productor_id互斥
    private Long productorId;       //管理者表主键做逻辑外键，与consumer_id互斥
    private Long goodsId;           //商品表主键做逻辑外键
    private Long commentedId;       //评论表主键做逻辑外键，用于存储子环一对多关系


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public Long getProductorId() {
        return productorId;
    }

    public void setProductorId(Long productorId) {
        this.productorId = productorId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(Long commentedId) {
        this.commentedId = commentedId;
    }

}
