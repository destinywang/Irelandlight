package com.irelandlight.service;

import com.irelandlight.model.OrderGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.test.BaseJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/10
 * Time: 10:04
 * Description: 目的... .
 */
public class OrderGoodsRelationTest extends BaseJunitTest {

    @Resource
    private OrderGoodsRelationService orderGoodsRelationService;

    @Test
    public void testInsertOrderDetail() throws Exception{
        List<ShopCarGoodsRelation> shopCarGoodsRelations = new ArrayList<ShopCarGoodsRelation>();
        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        ShopCarGoodsRelation shopCarGoodsRelation2 = new ShopCarGoodsRelation();

        shopCarGoodsRelation.setGoodsId(1L);
        shopCarGoodsRelation.setSize("2");
        shopCarGoodsRelation.setCount(4);

        shopCarGoodsRelation2.setGoodsId(2L);
        shopCarGoodsRelation2.setSize("2");
        shopCarGoodsRelation2.setCount(6);

        shopCarGoodsRelations.add(shopCarGoodsRelation);
        shopCarGoodsRelations.add(shopCarGoodsRelation2);

        //orderGoodsRelationService.insertOrderDetail(2L,shopCarGoodsRelations);

    }

    @Test
    public void testBuyNow() throws Exception{
        OrderGoodsRelation orderGoodsRelation = new OrderGoodsRelation();
        orderGoodsRelation.setOrderId(7L);
        orderGoodsRelation.setCount(2);
        orderGoodsRelation.setGoodsId(2L);
        orderGoodsRelation.setSize("3");
        orderGoodsRelationService.buyNow(orderGoodsRelation);
    }

}
