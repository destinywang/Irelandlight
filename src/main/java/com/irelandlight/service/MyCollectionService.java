package com.irelandlight.service;

import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.vo.GoodDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Matt on 2016/12/9.
 */
public interface MyCollectionService {

    /*返回我的收藏集合*/
    public Map<String,Object> findMyCollection(Long id);

    /*插入一条我的收藏记录*/
    public Map<String,Object> insertMyCollection(ConsumerGoodsRelation relation, Long consumerId);

    /*删除一条我的收藏记录*/
    public Map<String,Object> deleteMyCollection(Long relationid);

    /*添加一条购物车记录*/
    public Map<String,Object> addToShopCarFromCollection(ConsumerGoodsRelation relation);

    /*批量删除记录*/
    public Map<String,Object> deleteCollectionList(ArrayList<Long> CollectionIdList);

    /*批量添加购物车*/
    public Map<String,Object> addToShopCarFromCollectionList(ArrayList<ConsumerGoodsRelation> collection);

}
