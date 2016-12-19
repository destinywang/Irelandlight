package com.irelandlight.manager;

import com.irelandlight.dao.ShopCarGoodsRelationDao;
import com.irelandlight.model.ShopCarGoodsRelation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/18
 * Time: 22:14
 * Description: ShopCarGoodsRelationManager.
 */
@Component
public class ShopCarGoodsRelationManager {

    @Resource
    private ShopCarGoodsRelationDao shopCarGoodsRelationDao;

    /**
     * 购物车没有需要添加的商品，就直接添加 insertGoodsWithNo
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //购物车没有需要添加的商品，就直接添加
    public Integer insertGoodsWithNo(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception{
        if (shopCarGoodsRelation == null){
            return null;
        }
        if (shopCarGoodsRelationDao.insertGoodsWithNo(shopCarGoodsRelation) == 0){
            return 0;
        }
        return 1;
    }


    /**
     * 购物车有需要添加的商品，修改购物车商品信息 updateShopCarGoodsRelation
     * 修改购物车商品信息
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //购物车有需要添加的商品，修改购物车商品信息
    //修改购物车商品信息
    public Integer updateShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception{
        if (shopCarGoodsRelation == null){
            return null;
        }
        if (shopCarGoodsRelationDao.updateShopCarGoodsRelation(shopCarGoodsRelation) == 0){
            return 0;
        }
        return 1;
    }

    /**
     * 删除购物车详情 deleteShopCarGoodsRelation
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //删除购物车详情
    public Integer deleteShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception{
        if (shopCarGoodsRelation == null){
            return null;
        }
        if (shopCarGoodsRelationDao.deleteShopCarGoodsRelation(shopCarGoodsRelation) == 0){
            return 0;
        }
        return 1;
    }

    /**
     * 批量删除某购物车中某商品详情 batchDeleteShopCarGoodsRelations
     * @param shopCarGoodsRelations 需要添加的购物车详情信息
     * @throws Exception
     */
    //批量删除某购物车中某商品详情
    public Integer batchDeleteShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) throws  Exception{
        if (shopCarGoodsRelations == null){
            return null;
        }
        if (shopCarGoodsRelationDao.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations) == 0){
            return 0;
        }
        return 1;
    }

    /**
     * 查找购物车详情 findShopCarGoodsRelationByShopCarGoodsRelation
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @return List<ShopCarGoodsRelation> 购物车详情列表
     * @throws Exception
     */
    //查找购物车详情
    public List<ShopCarGoodsRelation> findShopCarGoodsRelationByShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception{
        if (shopCarGoodsRelation == null){
            return null;
        }
        List<ShopCarGoodsRelation> shopCarGoodsRelations = shopCarGoodsRelationDao.findShopCarGoodsRelationByShopCarGoodsRelation(shopCarGoodsRelation);
        if (shopCarGoodsRelations == null){
            return null;
        }
        return shopCarGoodsRelations;
    }

    /**
     * 查找用户购物车是否有该商品 findSameGoodsRelation
     * @param shopCarGoodsRelation 购物车详情
     * @return ShopCarGoodsRelation
     * @throws Exception
     */
    //查找用户购物车是否有该商品
    public ShopCarGoodsRelation findSameGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation)throws  Exception{
        if(shopCarGoodsRelation == null){
            return null;
        }
        ShopCarGoodsRelation shopCarGoodsRelation1 = shopCarGoodsRelationDao.findSameGoodsRelation(shopCarGoodsRelation);
        if(shopCarGoodsRelation1 == null){
            return null;
        }
        return shopCarGoodsRelation1;
    }
}
