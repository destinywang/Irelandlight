package com.irelandlight.dao;

import com.irelandlight.model.ShopCar;
import com.irelandlight.service.ShopCarService;
import com.irelandlight.service.impl.ShopCarServiceImpl;
import com.irelandlight.test.BaseJunitTest;
import junit.runner.BaseTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void testInsertShopCarByShopCar() throws Exception {
        Long consumerId = new Long(1001);
        shopCarService.deleteConsumerShopCarByConsumerId(consumerId);
    }

    @Test
    public void testFindShopCarGoodsDetailByConsumerId() throws Exception {
        Long consumerId = new Long(1001);
        ShopCar shopCar = shopCarService.findShopCarGoodsDetailByConsumerId(consumerId);
        System.out.println(shopCar);
    }
}

