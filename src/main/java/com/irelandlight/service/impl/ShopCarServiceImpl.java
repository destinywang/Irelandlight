package com.irelandlight.service.impl;

import com.irelandlight.dao.ShopCarDao;
import com.irelandlight.dao.ShopCarGoodsRelationDao;
import com.irelandlight.manager.ShopCarManager;
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
    private ShopCarManager shopCarManager;

    @Resource
    private ShopCarGoodsRelationDao shopCarGoodsRelationDao;

    /**
     * 添加用户购物车 返回主键 insertShopCarByShopCar
     * @param shopCar
     * @throws Exception
     */
    public Integer insertShopCarByShopCar(ShopCar shopCar) throws Exception {
        if (shopCarManager.insertShopCarByShopCar(shopCar) == 0){
            return 0;
        }
        return 1;
    }

    /**
     * 添加用户购物车 insertShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    public Integer  insertShopCarByConsumerId(Long consumerId) throws Exception {
       if(shopCarManager.insertShopCarByConsumerId(consumerId) == 0){
           return 0;
       }
       return 1;
    }

    /**
     * 删除用户购物车 deleteShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    public Integer deleteShopCarByConsumerId(Long consumerId) throws Exception {
        if(shopCarManager.deleteShopCarByConsumerId(consumerId)==0){
            return 0;
        }
        return 1;
    }

    /**
     * 通过用户Id查找购物车商品详情列表(resultMap) findShopCarGoodsDetailByConsumerId
     * @param consumerId
     * @return
     * @throws Exception
     */
    //通过用户Id查找购物车商品详情列表(resultMap)
    public ShopCar findShopCarGoodsDetailByConsumerId (Long consumerId) throws Exception{
        ShopCar shopCar = shopCarManager.findShopCarGoodsDetailByConsumerId(consumerId);
        if (shopCar == null){
            return null;
        }
        return shopCar;
    }

    /**
     * 通过用户Id查询其购物车信息 findShopCarDetailByConsumerId
     * @param consumerId
     * @return ShopCar
     * @throws Exception
     */
    public ShopCar findShopCarDetailByConsumerId(Long consumerId) throws Exception {
        ShopCar shopCar = shopCarManager.findShopCarDetailByConsumerId(consumerId);
        if (shopCar == null){
            return null;
        }
        return shopCar;
    }

}
