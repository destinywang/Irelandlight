package com.irelandlight.model.vo;

import java.util.List;

/**
 * Created by Zichu on 2016/12/8.
 */
public class GoodsAll {

    private GoodsInfo goodsInfo;
    private List<SizePrice> sizePrices;

    public GoodsInfo getGoodsInfo() {
        return goodsInfo;
    }

    public List<SizePrice> getSizePrices() {
        return sizePrices;
    }

    public void setGoodsInfo(GoodsInfo goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public void setSizePrices(List<SizePrice> sizePrices) {
        this.sizePrices = sizePrices;
    }

    @Override
    public String toString() {
        return "GoodsAll{" +
                "goodsInfo=" + goodsInfo +
                ", sizePrices=" + sizePrices +
                '}';
    }
}
