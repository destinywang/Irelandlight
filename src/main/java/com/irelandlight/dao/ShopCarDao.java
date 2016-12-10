package com.irelandlight.dao;

import com.irelandlight.model.ShopCar;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 16:53
 * Description: 购物车Dao .
 */
@Repository
public interface ShopCarDao {
    //添加用户购物车(ShopCar) 返回主键
    public void insertShopCarByShopCar(@Param("shopCar")ShopCar shopCar) throws Exception;

    //添加用户购物车(用户id) 返回主键
    public Long insertShopCarByConsumerId( @Param("consumerId") Long consumerId) throws Exception;

    //删除用户购物车
    public void deleteConsumerShopCarByConsumerId(@Param("consumerId") Long consumerId) throws Exception;

    //暂不提供修改用户购物车功能

    //通过用户Id查询其购物车信息
    public ShopCar findShopCarDetailByConsumerId(@Param("consumerId") Long consumerId) throws Exception;

    //通过用户Id查找购物车商品详情列表(resultMap)
    public ShopCar findShopCarGoodsDetailByConsumerId (@Param("consumerId") Long consumerId) throws Exception;
}
