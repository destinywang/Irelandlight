package com.irelandlight.vo;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by mac on 2016/12/20.
 */
public class ModifyGoodsVO {
    private Long goodsId;
    private Map<String,BigDecimal> sizeMapPrice;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Map<String, BigDecimal> getSizeMapPrice() {
        return sizeMapPrice;
    }

    public void setSizeMapPrice(Map<String, BigDecimal> sizeMapPrice) {
        this.sizeMapPrice = sizeMapPrice;
    }
}
