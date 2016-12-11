package com.irelandlight.vo;

import com.irelandlight.model.Order;
import com.irelandlight.model.ShopCarGoodsRelation;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 12:15
 * Description:  购物车生成订单Vo类 .
 */
public class ShopCarOrderVo {

    //Order信息
    private Order order;

    //购物车信息
    private List<ShopCarGoodsRelation> shopCarGoodsRelations;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<ShopCarGoodsRelation> getShopCarGoodsRelations() {
        return shopCarGoodsRelations;
    }

    public void setShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) {
        this.shopCarGoodsRelations = shopCarGoodsRelations;
    }
}
