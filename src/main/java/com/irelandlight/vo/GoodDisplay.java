package com.irelandlight.vo;

import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsImage;

import java.util.Date;

/**
 * User: Matt
 * Date: 2016/12/12
 * Time: 17:23
 * Description: 用于我的收藏，我的足迹展示商品
 */
public class GoodDisplay {

    private Long goodsId;
    private Long collectionId;
    private Long historyId;
    private String goodsImgUrl;
    private String goodsName;
    private Float goodsPrice;
    private String size;
    private Date createTime;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "GoodDisplay{" +
                "goodsId=" + goodsId +
                ", collectionId=" + collectionId +
                ", goodsImgUrl='" + goodsImgUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", size='" + size + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
