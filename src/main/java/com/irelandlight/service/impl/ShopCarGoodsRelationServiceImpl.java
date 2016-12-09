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

    public void insertGoodsWithNo(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        shopCarGoodsRelationDao.insertGoodsWithNo(shopCarGoodsRelation);
    }

    public void updateShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        shopCarGoodsRelationDao.updateShopCarGoodsRelation(shopCarGoodsRelation);
    }

    public void deleteShopCarGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        shopCarGoodsRelationDao.deleteShopCarGoodsRelation(shopCarGoodsRelation);
    }

    public void batchDeleteShopCarGoodsRelations(List<ShopCarGoodsRelation> shopCarGoodsRelations) throws Exception {
        shopCarGoodsRelationDao.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations);
    }

    public List<ShopCarGoodsRelation> findShopCarGoodsRelationByShopCarId(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception {
        return shopCarGoodsRelationDao.findShopCarGoodsRelationByShopCarGoodsRelation(shopCarGoodsRelation);
    }

    public void insertGoodsRelation(ShopCarGoodsRelation shopCarGoodsRelation) throws Exception{
        ShopCarGoodsRelation shopCarGoodsRelation1 = shopCarGoodsRelationDao.findSameGoodsRelation(shopCarGoodsRelation);
        if(shopCarGoodsRelation1==null){
            shopCarGoodsRelationDao.insertGoodsWithNo(shopCarGoodsRelation);
        }else {
            shopCarGoodsRelation1.setCount(shopCarGoodsRelation1.getCount()+shopCarGoodsRelation.getCount());
            shopCarGoodsRelationDao.updateShopCarGoodsRelation(shopCarGoodsRelation1);
        }
    }
}
