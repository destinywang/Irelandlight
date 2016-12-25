package com.irelandlight.service;

import com.irelandlight.model.ShopCar;

import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 17:52
 * Description: 购物车接口 .
 */
public interface ShopCarService {

    /**
     * 添加用户购物车 返回主键 insertShopCarByShopCar
     * @param shopCar
     * @throws Exception
     */
    //添加用户购物车(ShopCar) 返回主键
    public Map<String, Object> insertShopCarByShopCar(ShopCar shopCar) throws Exception;

    /**
     * 添加用户购物车 insertShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    //添加用户购物车(用户id) 返回主键
    public Map<String, Object> insertShopCarByConsumerId(Long consumerId) throws Exception;

    /**
     * 删除用户购物车 deleteConsumerShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    //删除用户购物车
    public Map<String, Object> deleteShopCarByConsumerId(Long consumerId) throws Exception;

    //暂不提供修改用户购物车功能

    /**
     * 通过用户Id查找购物车商品详情列表(resultMap) findShopCarGoodsDetailByConsumerId
     * @param consumerId
     * @return Map<String, Object>
     * @throws Exception
     */
    //通过用户Id查找购物车商品详情列表(resultMap)
    public Map<String, Object> findShopCarGoodsDetailByConsumerId (Long consumerId) throws Exception;

    /**
     * 通过用户Id查询其购物车信息 findShopCarDetailByConsumerId
     * @param consumerId
     * @return ShopCar
     * @throws Exception
     */
    public Map<String, Object> findShopCarDetailByConsumerId(Long consumerId)throws Exception;

}
