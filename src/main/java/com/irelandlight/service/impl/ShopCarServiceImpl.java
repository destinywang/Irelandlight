package com.irelandlight.service.impl;

import com.irelandlight.manager.ShopCarGoodsRelationManager;
import com.irelandlight.manager.ShopCarManager;
import com.irelandlight.model.ShopCar;
import com.irelandlight.service.ShopCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

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
    private ShopCarManager shopCarManager;

    /**
     * 添加用户购物车 返回主键 insertShopCarByShopCar
     * @param shopCar
     * @throws Exception
     */
    public Map<String, Object> insertShopCarByShopCar(ShopCar shopCar) throws Exception {
        return shopCarManager.insertShopCarByShopCar(shopCar);
    }

    /**
     * 添加用户购物车 insertShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    public Map<String, Object> insertShopCarByConsumerId(Long consumerId) throws Exception {
       return shopCarManager.insertShopCarByConsumerId(consumerId);
    }

    /**
     * 删除用户购物车 deleteShopCarByConsumerId
     * @param Map<String, Object>
     * @throws Exception
     */
    public Map<String, Object> deleteShopCarByConsumerId(Long consumerId) throws Exception {
        return shopCarManager.deleteShopCarByConsumerId(consumerId);
    }

    /**
     * 通过用户Id查找购物车商品详情列表(resultMap) findShopCarGoodsDetailByConsumerId
     * @param consumerId
     * @return Map<String, Object>
     * @throws Exception
     */
    //通过用户Id查找购物车商品详情列表(resultMap)
    public Map<String, Object> findShopCarGoodsDetailByConsumerId (Long consumerId) throws Exception{
        return shopCarManager.findShopCarGoodsDetailByConsumerId(consumerId);
    }

    /**
     * 通过用户Id查询其购物车信息 findShopCarDetailByConsumerId
     * @param consumerId
     * @return Map<String, Object>
     * @throws Exception
     */
    public Map<String, Object> findShopCarDetailByConsumerId(Long consumerId) throws Exception {
        return shopCarManager.findShopCarDetailByConsumerId(consumerId);
    }

}
