package com.irelandlight.model;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/3
 * Time: 18:42
 * Description: 购物车包装对象 .
 */
public class ShopCarQueryVo {

    private ShopCar shopCar;

    private ShopCarCustom shopCarCustom;

    private ShopCarGoodsRelation shopCarGoodsRelation;

    private ShopCarGoodsRelationCustom shopCarGoodsRelationCustom;

    private List<ShopCarCustom> shopCarCustomList;

    public ShopCar getShopCar() {
        return shopCar;
    }

    public void setShopCar(ShopCar shopCar) {
        this.shopCar = shopCar;
    }

    public ShopCarCustom getShopCarCustom() {
        return shopCarCustom;
    }

    public void setShopCarCustom(ShopCarCustom shopCarCustom) {
        this.shopCarCustom = shopCarCustom;
    }

    public ShopCarGoodsRelation getShopCarGoodsRelation() {
        return shopCarGoodsRelation;
    }

    public void setShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) {
        this.shopCarGoodsRelation = shopCarGoodsRelation;
    }

    public ShopCarGoodsRelationCustom getShopCarGoodsRelationCustom() {
        return shopCarGoodsRelationCustom;
    }

    public void setShopCarGoodsRelationCustom(ShopCarGoodsRelationCustom shopCarGoodsRelationCustom) {
        this.shopCarGoodsRelationCustom = shopCarGoodsRelationCustom;
    }

    public List<ShopCarCustom> getShopCarCustomList() {
        return shopCarCustomList;
    }

    public void setShopCarCustomList(List<ShopCarCustom> shopCarCustomList) {
        this.shopCarCustomList = shopCarCustomList;
    }
}
