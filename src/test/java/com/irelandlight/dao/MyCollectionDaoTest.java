package com.irelandlight.dao;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Matt
 * Date: 2016/12/12
 * Time: 23:32
 * Description: MyCollectionDao层测试
 */
public class MyCollectionDaoTest extends BaseJunitTest {

    @Resource
    private MyCollectionDao myCollectionDao;

    @Test
    public void testInsertMyCollection()throws Exception{//1
        ConsumerGoodsRelation relation=new ConsumerGoodsRelation();
        relation.setConsumerId(1008L);
        relation.setGoodsId(5L);
        relation.setSize("5");
        myCollectionDao.insertMyCollection(relation);
    }

   @Test
    public void testDeleteMyCollection()throws Exception{//1
        myCollectionDao.deleteMyCollection(9L);
    }

    @Test
    public void testAddToShopCarFromCollection()throws Exception{//1
        ConsumerGoodsRelation relation=new ConsumerGoodsRelation();
        relation.setConsumerId(1008L);
        relation.setGoodsId(5L);
        relation.setSize("998");
        myCollectionDao.addToShopCarFromCollection(relation);
    }

    @Test
    public void findExistGoods()throws Exception{//1
        ConsumerGoodsRelation relation=new ConsumerGoodsRelation();
        relation.setConsumerId(1008L);
        relation.setGoodsId(5L);
        relation.setSize("98");
        Long relationId=myCollectionDao.findExistGoods( relation );
        if (relationId==null)
            System.out.println("null");
        else
            System.out.println(relationId);
    }

    @Test
    public void testAddGoodsCount()throws Exception{//1
        //根据shopcargoodsrelationId添加
        myCollectionDao.AddGoodsCount(18L);
    }

    @Test
    public void testDeleteCollectionList()throws Exception{//1
        //根据收藏ID进行删除
        ArrayList<Long> CollectionIdList=new ArrayList<Long>();
        CollectionIdList.add(1L);
        CollectionIdList.add(3L);
        CollectionIdList.add(4L);
        myCollectionDao.deleteCollectionList(CollectionIdList);
    }

    @Test
    public void testFindMyCollection()throws Exception{//1
        /*根据用户id进行查询*/
        System.out.println(myCollectionDao.findMyCollection(1001L));
    }

    @Test//直接返回收藏列表
    public void testFindCollectionTest()throws Exception{//1
        System.out.println(myCollectionDao.findCollectionTest(1006L));
    }

    @Test
    public void testAddToShopCarFromCollectionList()throws Exception{//1
        List<ConsumerGoodsRelation> list=myCollectionDao.findCollectionTest(1006L);
        myCollectionDao.addToShopCarFromCollectionList(list);
    }


}
