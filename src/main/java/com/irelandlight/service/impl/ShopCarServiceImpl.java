package com.irelandlight.service.impl;

import com.irelandlight.dao.ShopCarDao;
import com.irelandlight.model.ShopCar;
import com.irelandlight.service.ShopCarService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 17:52
 * Description: 购物车service .
 */
@Service
public class ShopCarServiceImpl implements ShopCarService {

    @Autowired
    private ShopCarDao shopCarDao;

    public void insertShopCarByShopCar(ShopCar shopCar) throws Exception {
        shopCarDao.insertShopCarByShopCar(shopCar);
    }

    public void insertShopCarByConsumerId(@Param("consumerId") Long consumerId) throws Exception {
        shopCarDao.insertShopCarByConsumerId(consumerId);
    }

    public void deleteConsumerShopCarByConsumerId(@Param("consumerId") Long consumerId) throws Exception {
        shopCarDao.deleteConsumerShopCarByConsumerId(consumerId);
    }

    public ShopCar findShopCarByConsumerId(@Param("consumerId") Long consumerId) throws Exception {
        ShopCar shopCar = shopCarDao.findShopCarByConsumerId(consumerId);
        return shopCar;
    }
}
