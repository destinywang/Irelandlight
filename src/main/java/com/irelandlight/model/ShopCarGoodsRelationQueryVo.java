package com.irelandlight.model;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/3
 * Time: 19:02
 * Description: 购物车商品详情包装类 .
 */
public class ShopCarGoodsRelationQueryVo  {

    private ShopCarGoodsRelation shopCarGoodsRelation;

    private ShopCarGoodsRelationCustom shopCarGoodsRelationCustom;

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
}
