package com.irelandlight.service.impl;

import com.irelandlight.dao.ShopCarGoodsRelationDao;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.ShopCarGoodsRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/8
 * Time: 15:21
 * Description: 购物车详情service实现类.
 */
@Service
public class ShopCarGoodsRelationServiceImpl implements ShopCarGoodsRelationService {

    @Resource
    private ShopCarGoodsRelationDao shopCarGoodsRelationDao;

    /**
     * 添加购物车详情
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    public void insertGoodsWithNo(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        shopCarGoodsRelationDao.insertGoodsWithNo(shopCarGoodsRelation);
    }

    /**
     * 更新购物车商品详情
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    public void updateShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        shopCarGoodsRelationDao.updateShopCarGoodsRelation(shopCarGoodsRelation);
    }

    /**
     * 删除某条购物车详情 deleteShopCarGoodsRelation
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    public void deleteShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        shopCarGoodsRelationDao.deleteShopCarGoodsRelation(shopCarGoodsRelation);
    }

    /**
     * 批量删除购物车详情 batchDeleteShopCarGoodsRelations
     * @param shopCarGoodsRelations
     * @throws Exception
     */
    public void batchDeleteShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) throws Exception {
        shopCarGoodsRelationDao.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations);
    }


    /**
     * 查找用户购物车商品详情 findShopCarGoodsRelationByShopCarId
     * @param shopCarGoodsRelation
     * @return
     * @throws Exception
     */
    public List<ShopCarGoodsRelation> findShopCarGoodsRelationByShopCarId(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        return shopCarGoodsRelationDao.findShopCarGoodsRelationByShopCarGoodsRelation(shopCarGoodsRelation);
    }

    /**
     * 向购物车添加商品，解决购物车有需要添加的商品 insertGoodsRelation
     * @param shopCarGoodsRelation
     * @throws Exception
     */
    public void insertGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception{
        //查找用户购物车商品（通过购物车id + 商品id + 商品size） 如果有则返回的该商品详情
        ShopCarGoodsRelation shopCarGoodsRelation1 = shopCarGoodsRelationDao.findSameGoodsRelation(shopCarGoodsRelation);
        //判断时候有 有则更新， 无则添加
        if(shopCarGoodsRelation1==null){
            shopCarGoodsRelationDao.insertGoodsWithNo(shopCarGoodsRelation);
        }else {
            shopCarGoodsRelation1.setCount(shopCarGoodsRelation1.getCount()+shopCarGoodsRelation.getCount());
            shopCarGoodsRelationDao.updateShopCarGoodsRelation(shopCarGoodsRelation1);
        }
    }
}
