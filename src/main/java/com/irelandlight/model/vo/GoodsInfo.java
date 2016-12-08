package com.irelandlight.model.vo;

/**
 * Created by Zichu on 2016/12/8.
 */
public class GoodsInfo {
    private String goodsName;
    private int goodsId;
    private String goodsDescription;
    private int goodsQuantity;

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public void setGoodsQuantity(int goodsQuantity) {
        this.goodsQuantity = goodsQuantity;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public int getGoodsQuantity() {
        return goodsQuantity;
    }
}
