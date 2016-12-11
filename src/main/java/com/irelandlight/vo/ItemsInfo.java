package com.irelandlight.vo;

/**
 * Created by mac on 2016/12/8.
 */
public class ItemsInfo {
    private int goodsTotal; //商品总数
    private int upedGoods;  //已上架商品
    private int unUpGoods;  //未上架商品
    private int goodsComment;   //商品的品论总数

    public int getGoodsTotal() {
        return goodsTotal;
    }

    public void setGoodsTotal(int goodsTotal) {
        this.goodsTotal = goodsTotal;
    }

    public int getUpedGoods() {
        return upedGoods;
    }

    public void setUpedGoods(int upedGoods) {
        this.upedGoods = upedGoods;
    }

    public int getUnUpGoods() {
        return unUpGoods;
    }

    public void setUnUpGoods(int unUpGoods) {
        this.unUpGoods = unUpGoods;
    }

    public int getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(int goodsComment) {
        this.goodsComment = goodsComment;
    }
}
