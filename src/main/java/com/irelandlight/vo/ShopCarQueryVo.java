package com.irelandlight.vo;

import com.irelandlight.model.ShopCar;
import com.irelandlight.model.ShopCarGoodsRelation;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/3
 * Time: 18:42
 * Description: 购物车包装对象 .
 */
public class ShopCarQueryVo {
    private ShopCar shopCar;
    private ShopCarGoodsRelation shopCarGoodsRelation;

    public ShopCar getShopCar() {
        return shopCar;
    }

    public void setShopCar(ShopCar shopCar) {
        this.shopCar = shopCar;
    }

    public ShopCarGoodsRelation getShopCarGoodsRelation() {
        return shopCarGoodsRelation;
    }

    public void setShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) {
        this.shopCarGoodsRelation = shopCarGoodsRelation;
    }
}
