package com.irelandlight.vo;

import com.irelandlight.model.GoodsSizePrice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by mac on 2016/12/15.
 */
public class GoodsDetail {
    private Long goodsId;
    private Integer weight;
    private Map<String,BigDecimal> priceMapSize;    //键为尺寸，值为价格
    private String name;            //蛋糕名称
    private String description;     //蛋糕描述
    private String preference;      //蛋糕偏好
    private String use;             //蛋糕用途
    private String taste;           //蛋糕口味
    private Integer quantity;       //库存
    private Integer saleCount;      //销售量
    private Integer status;         //商品的状态
    private String headImgUrl;      //蛋糕头像

    public Integer getWeight() {
        return weight;
    }

    public Map<String, BigDecimal> getPriceMapSize() {
        return priceMapSize;
    }

    public void setPriceMapSize(Map<String, BigDecimal> priceMapSize) {
        this.priceMapSize = priceMapSize;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }
}
