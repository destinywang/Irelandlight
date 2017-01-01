package com.irelandlight.manager;

import com.irelandlight.dao.MyCollectionDao;
import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.vo.GoodDisplay;
import com.sun.corba.se.impl.util.RepositoryId;
import org.hamcrest.core.Is;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/23
 * Time: 5:09
 * Description: description
 */
@Component
public class MyCollectionManager {

    @Resource
    private MyCollectionDao myCollectionDaoImpl;

    public Map<String,Object> findMyCollection(Long consumerId){
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        List<GoodDisplay> goodDisplayList= myCollectionDaoImpl.findMyCollection(consumerId);
        if (goodDisplayList==null){
            updateStatus.put("status",1);
            updateStatus.put("msg","查询失败");
        }else {
            updateStatus.put("status",0);
            updateStatus.put("msg",goodDisplayList);
        }
        return updateStatus;
    }

    public Map<String,Object> insertMyCollection(ConsumerGoodsRelation relation,Long consumerId){
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        //先根据consumerId查找该用户的收藏列表
        List<ConsumerGoodsRelation> relationsList=myCollectionDaoImpl.findCollectioninCGRFrom(consumerId);
        Boolean flag=false;
        Long ExistRelationId=null;//保存已有的收藏记录的id
        Integer updateRow=0,insertRow=0;
        /*遍历该用户已有收藏记录,如果已有,flag为true,此时只需更改修改时间;否则,插入一条收藏记录*/
        for(ConsumerGoodsRelation relationElement:relationsList){
            if ( relationElement.getGoodsId().equals(relation.getGoodsId()) && relationElement.getSize().equals( relation.getSize()) ){
                flag=true;
                ExistRelationId=relationElement.getId();
                break;
            }
        }

        if (flag){
            updateRow=myCollectionDaoImpl.updateLastTime(ExistRelationId);
        }else{
            insertRow=myCollectionDaoImpl.insertMyCollection(relation);
        }

        if (updateRow==0 && insertRow==0){
            updateStatus.put("status",1);
            updateStatus.put("msg","添加收藏失败");
        }else {
            updateStatus.put("status",0);
            updateStatus.put("msg","添加收藏成功");
        }
        return updateStatus;
    }

    public Map<String,Object> deleteMyCollection(Long relationid) {
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        Integer updateRow = myCollectionDaoImpl.deleteMyCollection(relationid);
        if (updateRow==1){
            updateStatus.put("status",0);
            updateStatus.put("msg","删除收藏成功");
        }else {
            updateStatus.put("status",1);
            updateStatus.put("msg","删除收藏失败");
        }
        return updateStatus;
    }

    /*如果购物车中已经存在此商品信息,则更改数量*/
    public Map<String,Object> addToShopCarFromCollection(ConsumerGoodsRelation relation) {
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        Long shopCarGoodsRelationId=myCollectionDaoImpl.findExistGoods(relation);//返回购物车详情ID
        Integer updateRow=0;
        Integer insertRow=0;
        if (shopCarGoodsRelationId==null){//如果购物车中不存在该商品，则将该商品添加至购物车当中
            insertRow=myCollectionDaoImpl.addToShopCarFromCollection(relation);
        }else {
            updateRow=myCollectionDaoImpl.AddGoodsCount(shopCarGoodsRelationId);//否则，增加该商品数量
        }

        if (updateRow==0 && insertRow==0){
            updateStatus.put("status",1);
            updateStatus.put("msg","添加购物车失败");
        }else {
            updateStatus.put("status",0);
            updateStatus.put("msg","添加/修改购物车成功");
        }

        return updateStatus;
    }

    public Map<String,Object> deleteCollectionList(ArrayList<Long> CollectionIdList){
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        Integer updateRow=myCollectionDaoImpl.deleteCollectionList(CollectionIdList);
        if(updateRow==0){
            updateStatus.put("status",1);
            updateStatus.put("msg","批量删除收藏失败");
        }else{
            updateStatus.put("status",0);
            updateStatus.put("msg","批量删除收藏成功");
        }
        return updateStatus;
    }

    public Map<String,Object> addToShopCarFromCollectionList(ArrayList<ConsumerGoodsRelation> collectionList){
        Map<String, Object> updateStatus = new HashMap<String, Object>();
        Integer updateRow=myCollectionDaoImpl.addToShopCarFromCollectionList(collectionList);
        if(updateRow==0){
            updateStatus.put("status",1);
            updateStatus.put("msg","批量添加购物车失败");
        }else{
            updateStatus.put("status",0);
            updateStatus.put("msg","批量添加购物车成功");
        }
        return updateStatus;
    }

}
