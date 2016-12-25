package com.irelandlight.manager;

import com.irelandlight.dao.ShopCarDao;
import com.irelandlight.model.ShopCar;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/18
 * Time: 14:28
 * Description: ShopCarManager .
 */
@Component("shopCarManager")
public class ShopCarManager {
    @Resource
    private ShopCarDao shopCarDao;

    /**
     * 添加用户购物车(ShopCar) 返回主键 insertShopCarByShopCar
     * @param shopCar 用于主键返回
     * @throws Exception
     */
    //添加用户购物车(ShopCar) 返回主键
    public Map<String,Object> insertShopCarByShopCar(ShopCar shopCar) throws Exception{
        Map<String,Object> insertShopCar = new HashMap<String,Object>();
        //参数判断
        if (shopCar == null){
            insertShopCar.put("code",1);
            insertShopCar.put("status","无购物车信息");
            return insertShopCar;
        }
        //返回值判断
        if(shopCarDao.insertShopCarByShopCar(shopCar) == 0){
            insertShopCar.put("code",2);
            insertShopCar.put("status","插入购物车失败");
            return insertShopCar;
        }
        insertShopCar.put("code",0);
        insertShopCar.put("status","插入购物车成功");
        return insertShopCar;
    }

    /**
     * 添加用户购物车 insertShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    //添加用户购物车(用户id)
    public Map<String,Object> insertShopCarByConsumerId(Long consumerId) throws Exception{
        Map<String,Object> insertShopCar = new HashMap<String,Object>();
        //参数判断
        if (consumerId == null||consumerId<0){
            insertShopCar.put("code",1);
            insertShopCar.put("status","用户id错误");
            return insertShopCar;
        }
        //返回值判断
        if(shopCarDao.insertShopCarByConsumerId(consumerId) == 0){
            insertShopCar.put("code",2);
            insertShopCar.put("status","插入购物车失败");
            return insertShopCar;
        }
        insertShopCar.put("code",0);
        insertShopCar.put("status","插入购物车成功");
        return insertShopCar;
    }

    /**
     * 删除用户购物车 deleteConsumerShopCarByConsumerId
     * @param consumerId
     * @throws Exception
     */
    //删除用户购物车
    public Map<String,Object> deleteShopCarByConsumerId(Long consumerId) throws Exception{
        Map<String,Object> insertShopCar = new HashMap<String,Object>();
        //参数判断
        if (consumerId == null||consumerId<0){
            insertShopCar.put("code",1);
            insertShopCar.put("status","用户id错误");
            return insertShopCar;
        }
        //返回值判断
        if(shopCarDao.deleteShopCarByConsumerId(consumerId) == 0){
            insertShopCar.put("code",2);
            insertShopCar.put("status","删除购物车失败");
            return insertShopCar;
        }
        insertShopCar.put("code",0);
        insertShopCar.put("status","删除购物车成功");
        return insertShopCar;
    }

    //暂不提供修改用户购物车功能

    /**
     * 通过用户Id查询其购物车信息 findShopCarDetailByConsumerId
     * @param consumerId
     * @return
     * @throws Exception
     */
    //通过用户Id查询其购物车信息
    public Map<String,Object> findShopCarDetailByConsumerId(Long consumerId) throws Exception{
        Map<String,Object> insertShopCar = new HashMap<String,Object>();
        ShopCar shopCar =null;
        //参数判断
        if (consumerId == null||consumerId<0){
            insertShopCar.put("code",1);
            insertShopCar.put("status","用户不存在");
            return insertShopCar;
        }
        //返回值判断
        if((shopCar = shopCarDao.findShopCarDetailByConsumerId(consumerId)) == null){
            insertShopCar.put("code",2);
            insertShopCar.put("status","无购物车信息");
            return insertShopCar;
        }
        insertShopCar.put("code",0);
        insertShopCar.put("shopCar",shopCar);
        return insertShopCar;
    }

    /**
     * 通过用户Id查找购物车商品详情列表(resultMap) findShopCarGoodsDetailByConsumerId
     * @param consumerId
     * @return
     * @throws Exception
     */
    //通过用户Id查找购物车商品详情列表(resultMap)
    public Map<String,Object> findShopCarGoodsDetailByConsumerId (Long consumerId) throws Exception{
        Map<String,Object> insertShopCar = new HashMap<String,Object>();
        ShopCar shopCar =null;
        //参数判断
        if (consumerId == null||consumerId<0){
            insertShopCar.put("code",1);
            insertShopCar.put("status","用户id错误");
            return insertShopCar;
        }
        //返回值判断
        if((shopCar = shopCarDao.findShopCarGoodsDetailByConsumerId(consumerId)) == null){
            insertShopCar.put("code",2);
            insertShopCar.put("status","无购物车信息");
            return insertShopCar;
        }
        insertShopCar.put("code",0);
        insertShopCar.put("shopCar",shopCar);
        return insertShopCar;
    }
}
