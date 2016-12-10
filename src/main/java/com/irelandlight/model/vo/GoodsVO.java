package com.irelandlight.model.vo;

/**
 * 商品展示类
 * Created by Zichu on 2016/12/7.
 */
public class GoodsVO {
    private int goodsId;
    private String goodsImageUrl;
    private String goodsName;
    private double goodsPrice;

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsImageUrl() {
        return goodsImageUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsImageUrl(String goodsImageUrl) {
        this.goodsImageUrl = goodsImageUrl;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Override
    public String toString() {
        return "GoodsVO{" +
                "goodsId=" + goodsId +
                ", goodsImageUrl='" + goodsImageUrl + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                '}';
    }
}
