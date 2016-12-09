package com.irelandlight.model.vo;

import com.irelandlight.model.Goods;
import com.irelandlight.model.GoodsImage;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/5.
 */
public class ContainerItem {
    private String goodsImgUrl;
    private Long goodsId;
    private String goodsName;
    private List<Map<String,BigDecimal>> priceMapSize;    //键为尺寸，值为价格
    private Integer weight;
    private String description;
    private Integer quantity;
    private Date lastUpdate;


    public String getGoodsImgUrl() {
        return goodsImgUrl;
    }

    public void setGoodsImgUrl(String goodsImgUrl) {
        this.goodsImgUrl = goodsImgUrl;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public List<Map<String, BigDecimal>> getPriceMapSize() {
        return priceMapSize;
    }

    public void setPriceMapSize(List<Map<String, BigDecimal>> priceMapSize) {
        this.priceMapSize = priceMapSize;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
