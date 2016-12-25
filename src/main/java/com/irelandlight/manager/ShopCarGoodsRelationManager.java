package com.irelandlight.manager;

import com.irelandlight.dao.ShopCarGoodsRelationDao;
import com.irelandlight.model.ShopCarGoodsRelation;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/18
 * Time: 22:14
 * Description: ShopCarGoodsRelationManager.
 */
@Component("shopCarGoodsRelationManager")
public class ShopCarGoodsRelationManager {

    @Resource
    private ShopCarGoodsRelationDao shopCarGoodsRelationDao;

    /**
     * 购物车没有需要添加的商品，就直接添加 insertGoodsWithNo
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //购物车没有需要添加的商品，就直接添加
    public Map<String,Object> insertGoodsWithNo(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception{
        Map<String,Object> insertGoods = new HashMap<String,Object>();
        if (shopCarGoodsRelation == null){
            insertGoods.put("code",1);
            insertGoods.put("status","无购物车详情信息");
            return insertGoods;
        }
        if (shopCarGoodsRelationDao.insertGoodsWithNo(shopCarGoodsRelation) == 0){
            insertGoods.put("code",2);
            insertGoods.put("status","插入购物车信息异常");
            return insertGoods;
        }
        insertGoods.put("code",0);
        insertGoods.put("status","插入购物车信息成功");
        return insertGoods;
    }


    /**
     * 购物车有需要添加的商品，修改购物车商品信息 updateShopCarGoodsRelation
     * 修改购物车商品信息
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //购物车有需要添加的商品，修改购物车商品信息
    //修改购物车商品信息
    public Map<String,Object> updateShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception{
        Map<String,Object> insertGoods = new HashMap<String,Object>();
        if (shopCarGoodsRelation == null){
            insertGoods.put("code",1);
            insertGoods.put("status","无购物车详情信息");
            return insertGoods;
        }
        if (shopCarGoodsRelationDao.updateShopCarGoodsRelation(shopCarGoodsRelation) == 0){
            insertGoods.put("code",2);
            insertGoods.put("status","修改购物车信息异常");
            return insertGoods;
        }
        insertGoods.put("code",0);
        insertGoods.put("status","修改购物车信息成功");
        return insertGoods;
    }

    /**
     * 删除购物车详情 deleteShopCarGoodsRelation
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @throws Exception
     */
    //删除购物车详情
    public Map<String,Object> deleteShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception{
        Map<String,Object> insertGoods = new HashMap<String,Object>();
        if (shopCarGoodsRelation == null){
            insertGoods.put("code",1);
            insertGoods.put("status","无购物车详情信息");
            return insertGoods;
        }
        if (shopCarGoodsRelationDao.deleteShopCarGoodsRelation(shopCarGoodsRelation) == 0){
            insertGoods.put("code",2);
            insertGoods.put("status","删除购物车信息异常");
            return insertGoods;
        }
        insertGoods.put("code",0);
        insertGoods.put("status","删除购物车信息成功");
        return insertGoods;
    }

    /**
     * 批量删除某购物车中某商品详情 batchDeleteShopCarGoodsRelations
     * @param shopCarGoodsRelations 需要添加的购物车详情信息
     * @throws Exception
     */
    //批量删除某购物车中某商品详情
    public Map<String,Object> batchDeleteShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) throws  Exception{
        Map<String,Object> insertGoods = new HashMap<String,Object>();
        if (shopCarGoodsRelations == null || shopCarGoodsRelations.size() <= 0){
            insertGoods.put("code",1);
            insertGoods.put("status","无购物车详情信息");
            return insertGoods;
        }
        if (shopCarGoodsRelationDao.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations) == 0){
            insertGoods.put("code",2);
            insertGoods.put("status","删除购物车信息异常");
            return insertGoods;
        }
        insertGoods.put("code",0);
        insertGoods.put("status","删除购物车信息成功");
        return insertGoods;
    }

    /**
     * 查找购物车详情 findShopCarGoodsRelationByShopCarGoodsRelation
     * @param shopCarGoodsRelation 需要添加的购物车详情信息
     * @return List<ShopCarGoodsRelation> 购物车详情列表
     * @throws Exception
     */
    //查找购物车详情
    public Map<String,Object> findShopCarGoodsRelationByShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws  Exception{
        Map<String,Object> insertGoods = new HashMap<String,Object>();
        List<ShopCarGoodsRelation> shopCarGoodsRelations = null;
        if (shopCarGoodsRelation == null){
            insertGoods.put("code",1);
            insertGoods.put("status","无购物车详情信息");
        } else if ((shopCarGoodsRelations = shopCarGoodsRelationDao.findShopCarGoodsRelationByShopCarGoodsRelation(shopCarGoodsRelation))==null){
            insertGoods.put("code",2);
            insertGoods.put("status","无购物车详情信息");
        }else {
            insertGoods.put("code",0);
            insertGoods.put("shopCarGoodsRelations",shopCarGoodsRelations);
        }
        return insertGoods;
    }

    /**
     * 查找用户购物车是否有该商品 findSameGoodsRelation
     * @param shopCarGoodsRelation 购物车详情
     * @return ShopCarGoodsRelation
     * @throws Exception
     */
    //查找用户购物车是否有该商品
    public Map<String,Object> findSameGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation)throws  Exception{
        Map<String,Object> findGoods = new HashMap<String,Object>();

        ShopCarGoodsRelation shopCarGoodsRelation1 = null;

        if (shopCarGoodsRelation == null){
            findGoods.put("code",1);
            findGoods.put("status","无购物车详情信息");
        } else if ((shopCarGoodsRelation1 = shopCarGoodsRelationDao.findSameGoodsRelation(shopCarGoodsRelation))==null){
            findGoods.put("code",2);
            findGoods.put("status","无购物车详情信息");
        }else {
            findGoods.put("code",0);
            findGoods.put("shopCarGoodsRelation",shopCarGoodsRelation1);
        }
        return findGoods;
    }
}
