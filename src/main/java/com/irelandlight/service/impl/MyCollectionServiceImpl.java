package com.irelandlight.service.impl;

import com.irelandlight.dao.MyCollectionDao;
import com.irelandlight.manager.MyCollectionManager;
import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.MyCollectionService;
import com.irelandlight.vo.GoodDisplay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/14
 * Time: 6:57
 * Description: description
 */
@Service
public class MyCollectionServiceImpl implements MyCollectionService{

    @Resource
    private MyCollectionManager myCollectionManagerImpl;

    /*根据用户id查询收藏记录*/
    public Map<String,Object> findMyCollection(Long id)  {
        return myCollectionManagerImpl.findMyCollection(id);
    }

    /*根据一条收藏信息进行插入收藏,包含用户id 货物id 货物size*/
    /*如果收藏中已经存在此收藏信息,则更新 last_update*/
    /*consumerId在Controller层传递*/
    public Map<String,Object> insertMyCollection(ConsumerGoodsRelation relation, Long consumerId)  {
        return myCollectionManagerImpl.insertMyCollection(relation,consumerId);
    }

    //根据收藏Id删除一条收藏记录
    public Map<String,Object> deleteMyCollection(Long relationid)  {
       return myCollectionManagerImpl.deleteMyCollection(relationid);
    }

    /*根据一条收藏信息进行添加购物车,包含用户id 商品id 商品size*/
    /*如果购物车中已经存在此商品信息,则更改数量*/
    public Map<String,Object> addToShopCarFromCollection(ConsumerGoodsRelation relation) {
       return myCollectionManagerImpl.addToShopCarFromCollection(relation);
    }

    //根据收藏ID批量删除收藏记录
    public Map<String,Object> deleteCollectionList(ArrayList<Long> collectionIdList)  {
        return myCollectionManagerImpl.deleteCollectionList(collectionIdList);
    }

    public Map<String,Object> addToShopCarFromCollectionList(ArrayList<ConsumerGoodsRelation> collectionList) {
        return myCollectionManagerImpl.addToShopCarFromCollectionList(collectionList);
    }
}
