package com.irelandlight.dao;

import com.irelandlight.model.ShopCar;
import com.irelandlight.service.impl.ShopCarServiceImpl;
import com.irelandlight.test.BaseJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 18:13
 * Description: ShopCar 测试类... .
 */
public class ShopCarTest extends BaseJunitTest {

    @Resource
    private ShopCarServiceImpl shopCarService;

    @Test
    public void testInsertShopCarByConsumerId() throws Exception {
        Long consumerId = new Long(1001);
        shopCarService.insertShopCarByConsumerId(consumerId);
    }

    @Test
    public void testInsertShopCarByShopCar() throws Exception {
        ShopCar shopCar = new ShopCar();
        shopCar.setConsumerId(1008L);
        shopCarService.insertShopCarByShopCar(shopCar);
        System.out.println(shopCar.getId());
    }

    @Test
    public void testFindShopCarGoodsDetailByConsumerId() throws Exception {
        Long consumerId = new Long(1001);
        ShopCar shopCar = shopCarService.findShopCarGoodsDetailByConsumerId(consumerId);
        System.out.println(shopCar);
    }

}

