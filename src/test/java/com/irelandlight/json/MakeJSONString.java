package com.irelandlight.json;

import com.alibaba.fastjson.JSON;
import com.irelandlight.model.ShopCarGoodsRelation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 16:46
 * Description: 生成JSON测试数据 .
 */
public class MakeJSONString {

    public static void main(String[] args) {
        /*ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        shopCarGoodsRelation.setShopCarId(1L);
        shopCarGoodsRelation.setGoodsId(1L);
        shopCarGoodsRelation.setSize("2");
        shopCarGoodsRelation.setCount(4);

        System.out.println(JSON.toJSONString(shopCarGoodsRelation));*/

        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        shopCarGoodsRelation.setSize("3");
        shopCarGoodsRelation.setGoodsId(2L);
        shopCarGoodsRelation.setShopCarId(5L);
        ShopCarGoodsRelation shopCarGoodsRelation2 = new ShopCarGoodsRelation();
        shopCarGoodsRelation2.setSize("4");
        shopCarGoodsRelation2.setGoodsId(1L);
        shopCarGoodsRelation2.setShopCarId(5L);
        List<ShopCarGoodsRelation> shopCarGoodsRelations = new ArrayList<ShopCarGoodsRelation>();
        shopCarGoodsRelations.add(shopCarGoodsRelation);
        shopCarGoodsRelations.add(shopCarGoodsRelation2);

        System.out.println(JSON.toJSONString(shopCarGoodsRelations));

    }

}
