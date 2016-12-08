package com.irelandlight.model.vo;

/**
 * Created by Zichu on 2016/12/8.
 */
public class SizePrice {
    private double goodsPrice;
    private String goodsSize;
    private int goodsId;

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public String getGoodsSize() {
        return goodsSize;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public void setGoodsSize(String goodsSize) {
        this.goodsSize = goodsSize;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
}
