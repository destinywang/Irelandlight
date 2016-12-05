package com.irelandlight.model;

import java.util.Date;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/3
 * Time: 10:02
 * Description: 购物车表 .
 */
public class ShopCar {

    private Long id;
    private Date createTime;    //创建时间
    private Date lastUpdate;    //最后修改时间
    private Integer visibility; //是否逻辑删除
    private Long consumerId;    //消费者表主键做逻辑外键
    //map扩展
    private List<ShopCarGoodsRelation> shopCarGoodsRelations;

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

    public Long getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Long consumerId) {
        this.consumerId = consumerId;
    }

    public List<ShopCarGoodsRelation> getShopCarGoodsRelations() {
        return shopCarGoodsRelations;
    }

    public void setShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) {
        this.shopCarGoodsRelations = shopCarGoodsRelations;
    }
}
