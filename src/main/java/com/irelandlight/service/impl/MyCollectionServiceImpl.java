package com.irelandlight.service.impl;

import com.irelandlight.dao.MyCollectionDao;
import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.MyCollectionService;
import com.irelandlight.vo.GoodDisplay;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Matt
 * Date: 2016/12/14
 * Time: 6:57
 * Description: description
 */
@Service
public class MyCollectionServiceImpl implements MyCollectionService{

    @Resource
    private MyCollectionDao myCollectionDaoImpl;

    /*根据用户id查询收藏记录*/
    public List<GoodDisplay> findMyCollection(Long id) throws Exception {
        List<GoodDisplay> list= myCollectionDaoImpl.findMyCollection(id);
        return list;
    }

    /*根据一条收藏信息进行插入收藏,包含用户id 货物id 货物size*/
    /*如果收藏中已经存在此收藏信息,则更新 last_update*/
    /*consumerId在Controller层传递*/
    public void insertMyCollection(ConsumerGoodsRelation relation,Long consumerId) throws Exception {
        List<ConsumerGoodsRelation> relationsList=myCollectionDaoImpl.findCollectionTest(consumerId);
        Boolean flag=false;
        Long ExistRelation=null;//保存已有的收藏记录的id
        /*遍历该用户已有收藏记录,如果已有,flag为true,此时只需更改修改时间;否则,插入一条收藏记录*/
        for(ConsumerGoodsRelation relationElement:relationsList){
            if ( relationElement.getGoodsId().equals(relation.getGoodsId()) && relationElement.getSize().equals( relation.getSize()) ){
                flag=true;
                ExistRelation=relationElement.getId();
                break;
            }
        }
        if (flag){
            myCollectionDaoImpl.updateLastTime(ExistRelation);
        }
        else{
            myCollectionDaoImpl.insertMyCollection(relation);
        }
    }

    //根据收藏Id删除一条收藏记录
    public void deleteMyCollection(Long relationid) throws Exception {
        myCollectionDaoImpl.deleteMyCollection(relationid);
    }

    /*根据一条收藏信息进行添加购物车,包含用户id 商品id 商品size*/
    /*如果购物车中已经存在此商品信息,则更改数量*/
    public void addToShopCarFromCollection(ConsumerGoodsRelation relation) throws Exception {
        Long shopCarGoodsRelationId=myCollectionDaoImpl.findExistGoods(relation);//返回购物车详情ID
        if (shopCarGoodsRelationId==null){//如果购物车中不存在该商品，则将该商品添加至购物车当中
            myCollectionDaoImpl.addToShopCarFromCollection(relation);
        }
        else {
            myCollectionDaoImpl.AddGoodsCount(shopCarGoodsRelationId);//否则，增加该商品数量
        }
    }

    //根据收藏ID批量删除收藏记录
    public void deleteCollectionList(ArrayList<Long> collectionIdList) throws Exception {
        myCollectionDaoImpl.deleteCollectionList(collectionIdList);
    }

    public void addToShopCarFromCollectionList(ArrayList<ConsumerGoodsRelation> collectionList) throws Exception {
        //myCollectionDaoImpl.addToShopCarFromCollectionList(collectionList);
        for (ConsumerGoodsRelation collection:collectionList){
            System.out.println(collection);
            this.addToShopCarFromCollection(collection);
        }
    }
}
