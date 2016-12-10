package com.irelandlight.service.impl;

import com.irelandlight.dao.ShopCarDao;
import com.irelandlight.dao.ShopCarGoodsRelationDao;
import com.irelandlight.model.ShopCar;
import com.irelandlight.service.ShopCarService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 17:52
 * Description: 购物车service实现类 .
 */
@Service("shopCarService")
public class ShopCarServiceImpl implements ShopCarService {

    @Resource
    private ShopCarDao shopCarDao;

    @Resource
    private ShopCarGoodsRelationDao shopCarGoodsRelationDao;

    /**
     * 添加用户购物车 返回主键 insertShopCarByShopCar
     * @param shopCar
     * @throws Exception
     */
    public void insertShopCarByShopCar(ShopCar shopCar) throws Exception {
        shopCarDao.insertShopCarByShopCar(shopCar);
    }

    /**
     * 添加用户购物车 insertShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    public void  insertShopCarByConsumerId(Long consumerId) throws Exception {
       shopCarDao.insertShopCarByConsumerId(consumerId);
    }

    /**
     * 删除用户购物车 deleteShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    public void deleteShopCarByConsumerId(Long consumerId) throws Exception {
        shopCarDao.deleteShopCarByConsumerId(consumerId);
    }

    /**
     * 通过用户Id查找购物车商品详情列表(resultMap) findShopCarGoodsDetailByConsumerId
     * @param consumerId
     * @return
     * @throws Exception
     */
    //通过用户Id查找购物车商品详情列表(resultMap)
    public ShopCar findShopCarGoodsDetailByConsumerId (Long consumerId) throws Exception{
        ShopCar shopCar = shopCarDao.findShopCarGoodsDetailByConsumerId(consumerId);
        return shopCar;
    }

    /**
     * 通过用户Id查询其购物车信息 findShopCarDetailByConsumerId
     * @param consumerId
     * @return ShopCar
     * @throws Exception
     */
    public ShopCar findShopCarDetailByConsumerId(Long consumerId) throws Exception {
        return  shopCarDao.findShopCarDetailByConsumerId(consumerId);
    }

}
