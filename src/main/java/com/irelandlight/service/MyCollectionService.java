package com.irelandlight.service;

import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.vo.GoodDisplay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2016/12/9.
 */
public interface MyCollectionService {

    /*返回我的收藏集合*/
    public List<GoodDisplay> findMyCollection(Long id) throws Exception;

    /*插入一条我的收藏记录*/
    public void insertMyCollection(ConsumerGoodsRelation relation,Long consumerId) throws Exception;

    /*删除一条我的收藏记录*/
    public void deleteMyCollection(Long id) throws Exception;

    /*添加一条购物车记录*/
    public void addToShopCarFromCollection(ConsumerGoodsRelation relation) throws Exception;

    /*批量删除记录*/
    public void deleteCollectionList(ArrayList<Long> CollectionIdList) throws Exception;

    /*批量添加购物车*/
    public void addToShopCarFromCollectionList(ArrayList<ConsumerGoodsRelation> collection) throws Exception;

}
