package com.irelandlight.model.vo;

import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsImage;

import java.util.List;

/**
 * Created by mac on 2016/12/5.
 */
public class ContainerItem {
    private String imageHeadUrl;
    private Goods goods;

    public String getImageHeadUrl() {
        return imageHeadUrl;
    }

    public void setImageHeadUrl(String imageHeadUrl) {
        this.imageHeadUrl = imageHeadUrl;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }
}
