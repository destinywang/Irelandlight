package com.irelandlight.model;

import java.util.Date;

/**
 * Created by mac on 2016/12/3.
 */
public class ShopCarGoodsRelation {
    private Long id;
    private Date createTime;    //创建时间
    private Date lastUpdate;    //最后修改时间
    private Integer visibility; //是否逻辑删除
    private Long shopCarId;     //购物车表主键做逻辑外键
    private Long goodsId;       //商品表主键做逻辑外键
    private Integer count;      //每种商品的数量

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Long getShopCarId() {
        return shopCarId;
    }

    public void setShopCarId(Long shopCarId) {
        this.shopCarId = shopCarId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
