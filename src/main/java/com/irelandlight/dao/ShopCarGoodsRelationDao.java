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
@Repository
public interface ShopCarGoodsRelationDao {

    //购物车没有需要添加的商品，就直接添加
    public void insertGoodsWithNo(@Param("shopCarGoodsRelation")  ShopCarGoodsRelation shopCarGoodsRelation) throws Exception;

    //购物车有需要添加的商品，修改购物车商品信息
    //修改购物车商品信息
    public void updateShopCarGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    //删除购物车详情
    public void deleteShopCarGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    //批量删除某购物车中某商品详情
    public void batchDeleteShopCarGoodsRelations(@Param("shopCarGoodsRelations") List<ShopCarGoodsRelation> shopCarGoodsRelations) throws  Exception;

    //查找购物车详情
    public List<ShopCarGoodsRelation> findShopCarGoodsRelationByShopCarGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    public ShopCarGoodsRelation findSameGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation)throws  Exception;

}
