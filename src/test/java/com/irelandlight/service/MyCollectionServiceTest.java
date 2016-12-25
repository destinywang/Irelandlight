package com.irelandlight.service;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.model.ConsumerGoodsRelation;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * User: Matt
 * Date: 2016/12/15
 * Time: 18:58
 * Description: description
 */
public class MyCollectionServiceTest extends BaseJunitTest {

    @Resource
    private MyCollectionService myCollectionServiceImpl;

    @Test
    public void testFindMyCollection() throws Exception {
        System.out.println(myCollectionServiceImpl.findMyCollection(1001l));
    }

    @Test
    public void testinsertMyCollection() throws Exception {
        ConsumerGoodsRelation relation = new ConsumerGoodsRelation();
        relation.setConsumerId(1001l);
        relation.setGoodsId(3l);
        relation.setSize("1");
        myCollectionServiceImpl.insertMyCollection(relation, 1001l);
    }

    @Test
    public void testDeleteMyCollection() throws Exception {
        myCollectionServiceImpl.deleteMyCollection(1l);
    }

    @Test
    public void testAddToShopCarFromCollection() throws Exception {
        ConsumerGoodsRelation relation = new ConsumerGoodsRelation();
        relation.setConsumerId(1006l);
        relation.setGoodsId(3l);
        relation.setSize("1");
        myCollectionServiceImpl.addToShopCarFromCollection(relation);
    }

    @Test
    public void testDeleteCollectionList() throws Exception {
        ArrayList<Long> list = new ArrayList<Long>();
        list.add(1l);
        list.add(3l);
        myCollectionServiceImpl.deleteCollectionList(list);
    }

    @Test
    public void testAddToShopCarFromCollectionList() throws Exception {
        ArrayList<ConsumerGoodsRelation> list=new ArrayList<ConsumerGoodsRelation>();

        ConsumerGoodsRelation relation = new ConsumerGoodsRelation();
        relation.setConsumerId(1006l);
        relation.setGoodsId(2l);
        relation.setSize("3");
        list.add(relation);

        ConsumerGoodsRelation relation1 = new ConsumerGoodsRelation();
        relation1.setConsumerId(1006l);
        relation1.setGoodsId(3l);
        relation1.setSize("1");
        list.add(relation1);

        myCollectionServiceImpl.addToShopCarFromCollectionList(list);
    }

}
