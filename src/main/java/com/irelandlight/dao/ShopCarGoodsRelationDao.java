package com.irelandlight.dao;

import com.irelandlight.model.ShopCarGoodsRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 16:53
 * Description: 购物车详情Dao.
 */
@Repository("shopCarGoodsRelationDao")
public interface ShopCarGoodsRelationDao {

    //购物车没有需要添加的商品，就直接添加
    public void insertGoodsWithNo(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception;

    //购物车有需要添加的商品，修改购物车商品信息
    //修改购物车商品信息
    public void updateShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    //删除购物车详情
    public void deleteShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    //批量删除某购物车中某商品详情
    public void batchdeleteShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) throws  Exception;

    //查找购物车详情
    public ShopCarGoodsRelation findShopCarGoodsRelationByShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;



}
