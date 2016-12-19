package com.irelandlight.manager;

import com.irelandlight.dao.ShopCarDao;
import com.irelandlight.model.ShopCar;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/18
 * Time: 14:28
 * Description: ShopCarManager .
 */
@Component
public class ShopCarManager {
    @Resource
    private ShopCarDao shopCarDao;

    /**
     * 添加用户购物车(ShopCar) 返回主键 insertShopCarByShopCar
     * @param shopCar 用于主键返回
     * @throws Exception
     */
    //添加用户购物车(ShopCar) 返回主键
    public Integer insertShopCarByShopCar(ShopCar shopCar) throws Exception{
        //参数判断
        if (shopCar == null){
            System.out.println("购物车");
            return 0;
        }

        //返回值判断
        if(shopCarDao.insertShopCarByShopCar(shopCar) == 0){
            return 0;
        }
        return 1;
    }


    /**
     * 添加用户购物车 insertShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    //添加用户购物车(用户id)
    public Integer insertShopCarByConsumerId(Long consumerId) throws Exception{
        if(consumerId == null){
            return 0;
        }

        if(shopCarDao.insertShopCarByConsumerId(consumerId) == 0){
            return 0;
        }
        return 1;

    }

    /**
     * 删除用户购物车 deleteConsumerShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    //删除用户购物车
    public Integer deleteShopCarByConsumerId(Long consumerId) throws Exception{
        if (consumerId == null){
            return 0;
        }
        if (shopCarDao.deleteShopCarByConsumerId(consumerId) == 0){
            return 0;
        }
        return 1;
    }

    //暂不提供修改用户购物车功能

    /**
     * 通过用户Id查询其购物车信息 findShopCarDetailByConsumerId
     * @param consumerId
     * @return
     * @throws Exception
     */
    //通过用户Id查询其购物车信息
    public ShopCar findShopCarDetailByConsumerId(Long consumerId) throws Exception{
        if (consumerId == null){
            return null;
        }
        ShopCar shopCar = shopCarDao.findShopCarDetailByConsumerId(consumerId);
        if(shopCar == null){
            return null;
        }
        return shopCar;
    }

    /**
     * 通过用户Id查找购物车商品详情列表(resultMap) findShopCarGoodsDetailByConsumerId
     * @param consumerId
     * @return
     * @throws Exception
     */
    //通过用户Id查找购物车商品详情列表(resultMap)
    public ShopCar findShopCarGoodsDetailByConsumerId (Long consumerId) throws Exception{
        if (consumerId == null){
            System.out.println("用户不存在");
            return null;
        }
        ShopCar shopCar = shopCarDao.findShopCarGoodsDetailByConsumerId(consumerId);
        if(shopCar == null){
            System.out.println("无此购物车信息");
            return null;
        }
        return shopCar;
    }
}
