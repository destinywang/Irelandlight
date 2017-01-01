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

    public Integer insertMyCollection(ConsumerGoodsRelation consumerGoodsRelation);

    public Integer deleteMyCollection(Long relationId);

    public Integer addToShopCarFromCollection(ConsumerGoodsRelation consumerGoodsRelation);

    public Long findExistGoods(ConsumerGoodsRelation consumerGoodsRelation);

    public Integer AddGoodsCount(Long relationId);

    public Integer deleteCollectionList(@Param("CollectionIdList") ArrayList<Long> CollectionIdList);

    //根据rid批量添加收藏记录至购物车
    public Integer addToShopCarFromCollectionList(List<ConsumerGoodsRelation> relationList);

    public List<GoodDisplay> findMyCollection(@Param("consumerId") Long id);

    public List<ConsumerGoodsRelation> findCollectioninCGRFrom(Long id);

    //根据收藏id更新修改时间
    public Integer updateLastTime(Long collectionId);

}
