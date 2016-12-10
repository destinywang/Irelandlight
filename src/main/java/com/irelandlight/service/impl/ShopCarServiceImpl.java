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
     *
     * @param shopCar
     * @throws Exception
     */
    public void insertShopCarByShopCar(ShopCar shopCar) throws Exception {
        shopCarDao.insertShopCarByShopCar(shopCar);
        System.out.println(shopCar.getId());
    }

    /**
     *
     * @param consumerId
     * @throws Exception
     */

    public Long  insertShopCarByConsumerId(@Param("consumerId") Long consumerId) throws Exception {
       return shopCarDao.insertShopCarByConsumerId(consumerId);
    }

    public void deleteConsumerShopCarByConsumerId(@Param("consumerId") Long consumerId) throws Exception {
        shopCarDao.deleteConsumerShopCarByConsumerId(consumerId);
    }

    //通过用户Id查找购物车商品详情列表(resultMap)
    public ShopCar findShopCarGoodsDetailByConsumerId (@Param("consumerId") Long consumerId) throws Exception{
        ShopCar shopCar = shopCarDao.findShopCarGoodsDetailByConsumerId(consumerId);
        return shopCar;
    }

    public ShopCar findShopCarDetailByConsumerId(@Param("consumerId") Long consumerId) throws Exception {
        return  shopCarDao.findShopCarDetailByConsumerId(consumerId);
    }

}
