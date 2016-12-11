package com.irelandlight.service;

import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.impl.ShopCarGoodsRelationServiceImpl;
import com.irelandlight.test.BaseJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/9
 * Time: 18:16
 * Description: 购物车详情service测试.
 */
public class ShopCarGoodsRelationTest extends BaseJunitTest {

    @Resource
    private ShopCarGoodsRelationServiceImpl shopCarGoodsRelationService;


    @Test
    public void testInsertGoodsWithNo()throws Exception{
        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        shopCarGoodsRelation.setCount(10);
        shopCarGoodsRelation.setSize("3");
        shopCarGoodsRelation.setGoodsId(2L);
        shopCarGoodsRelation.setShopCarId(5L);
        shopCarGoodsRelationService.insertGoodsWithNo(shopCarGoodsRelation);
    }

    @Test
    public void testUpdateShopCarGoodsRelation() throws Exception {
        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        shopCarGoodsRelation.setCount(10);
        shopCarGoodsRelation.setSize("3");
        shopCarGoodsRelation.setGoodsId(2L);
        shopCarGoodsRelation.setShopCarId(5L);
        shopCarGoodsRelationService.updateShopCarGoodsRelation(shopCarGoodsRelation);
    }


    @Test
    public void testDeleteShopCarGoodsRelation() throws Exception {
        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        shopCarGoodsRelation.setSize("3");
        shopCarGoodsRelation.setGoodsId(2L);
        shopCarGoodsRelation.setShopCarId(5L);
        shopCarGoodsRelationService.deleteShopCarGoodsRelation(shopCarGoodsRelation);
    }


    @Test
    public void testBatchDeleteShopCarGoodsRelations() throws Exception {
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
        shopCarGoodsRelationService.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations);

    }


    @Test
    public void testFindShopCarGoodsRelationByShopCarId() throws Exception {

        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        shopCarGoodsRelation.setShopCarId(1L);
        List<ShopCarGoodsRelation> shopCarGoodsRelations = shopCarGoodsRelationService.findShopCarGoodsRelationByShopCarId(shopCarGoodsRelation);
        System.out.println(shopCarGoodsRelations);
    }


    @Test
    public void testInsertGoodsRelation() throws Exception {
        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        shopCarGoodsRelation.setShopCarId(1L);
        shopCarGoodsRelation.setGoodsId(1L);
        shopCarGoodsRelation.setSize("2");
        shopCarGoodsRelation.setCount(4);
        shopCarGoodsRelationService.insertGoodsRelation(shopCarGoodsRelation);
    }

}
