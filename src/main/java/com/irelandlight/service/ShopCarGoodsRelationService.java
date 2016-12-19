package com.irelandlight.service;

import com.irelandlight.model.ShopCarGoodsRelation;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/8
 * Time: 15:18
 * Description: 购物车详情service接口.
 */
public interface ShopCarGoodsRelationService {

    //添加购物车详情
    public Integer insertGoodsWithNo(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception;

    //修改购物车商品信息
    public Integer updateShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    //删除购物车详情
    public Integer deleteShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    //批量删除某购物车中某商品详情
    public Integer batchDeleteShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) throws  Exception;

    //查找购物车详情
    public List<ShopCarGoodsRelation> findShopCarGoodsRelationByShopCarId(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    //添加购物车请求
    public Integer insertGoodsRelation(Long comsumerId ,ShopCarGoodsRelation shopCarGoodsRelation) throws Exception;


}
