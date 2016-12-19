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

    /**
     * 购物车没有需要添加的商品，就直接添加 insertGoodsWithNo
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //购物车没有需要添加的商品，就直接添加
    public Integer insertGoodsWithNo(@Param("shopCarGoodsRelation")  ShopCarGoodsRelation shopCarGoodsRelation) throws Exception;


    /**
     * 购物车有需要添加的商品，修改购物车商品信息 updateShopCarGoodsRelation
     * 修改购物车商品信息
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //购物车有需要添加的商品，修改购物车商品信息
    //修改购物车商品信息
    public Integer updateShopCarGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    /**
     * 删除购物车详情 deleteShopCarGoodsRelation
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //删除购物车详情
    public Integer deleteShopCarGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    /**
     * 批量删除某购物车中某商品详情 batchDeleteShopCarGoodsRelations
     * @param shopCarGoodsRelations 需要添加的购物车详情信息
     * @throws Exception
     */
    //批量删除某购物车中某商品详情
    public Integer batchDeleteShopCarGoodsRelations(@Param("shopCarGoodsRelations") List<ShopCarGoodsRelation> shopCarGoodsRelations) throws  Exception;

    /**
     * 查找购物车详情 findShopCarGoodsRelationByShopCarGoodsRelation
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @return List<ShopCarGoodsRelation> 购物车详情列表
     * @throws Exception
     */
    //查找购物车详情
    public List<ShopCarGoodsRelation> findShopCarGoodsRelationByShopCarGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception;

    /**
     * 查找用户购物车详情 findSameGoodsRelation
     * @param shopCarGoodsRelation 购物车详情
     * @return ShopCarGoodsRelation
     * @throws Exception
     */
    //查找用户
    public ShopCarGoodsRelation findSameGoodsRelation(@Param("shopCarGoodsRelation") ShopCarGoodsRelation shopCarGoodsRelation)throws  Exception;

}
