package com.irelandlight.vo;

import java.util.Map;

/**
 * Created by mac on 2016/12/20.
 */
public class ModifyGoodsVO {
    private Long goodsId;
    private Map<String,Integer> sizeMapPrice;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Map<String, Integer> getSizeMapPrice() {
        return sizeMapPrice;
    }

    public void setSizeMapPrice(Map<String, Integer> sizeMapPrice) {
        this.sizeMapPrice = sizeMapPrice;
    }
}
