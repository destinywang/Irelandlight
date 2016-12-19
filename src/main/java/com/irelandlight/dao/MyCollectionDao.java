package com.irelandlight.dao;

import com.irelandlight.model.Consumer;
import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.vo.GoodDisplay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matt on 2016/12/9.
 */
@Repository
public interface MyCollectionDao {

    public void insertMyCollection(ConsumerGoodsRelation consumerGoodsRelation)throws Exception;

    public void deleteMyCollection(Long relationId)throws Exception;

    public void addToShopCarFromCollection(ConsumerGoodsRelation consumerGoodsRelation)throws Exception;

    public Long findExistGoods(ConsumerGoodsRelation consumerGoodsRelation)throws Exception;

    public void AddGoodsCount(Long relationId)throws Exception;

    public void deleteCollectionList(@Param("CollectionIdList") ArrayList<Long> CollectionIdList)throws Exception;

    //根据rid批量添加收藏记录至购物车
    public void addToShopCarFromCollectionList (List<ConsumerGoodsRelation> relationList )throws Exception;

    public List<GoodDisplay> findMyCollection(@Param("consumerId") Long id ) throws Exception;

    public List<ConsumerGoodsRelation> findCollectionTest(Long id)throws Exception;

    //根据收藏id更新修改时间
    public void updateLastTime(Long collectionId)throws Exception;

}
