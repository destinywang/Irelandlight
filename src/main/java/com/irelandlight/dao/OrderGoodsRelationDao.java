package com.irelandlight.dao;

import com.irelandlight.model.OrderGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/6
 * Time: 16:35
 * Description: 订单详情dao .
 */
@Repository
public interface OrderGoodsRelationDao {



    /**
     * 添加订单详情 insertOrderDetail
     * @param orderId 需要插入的订单id
     * @param shopCarGoodsRelation 从购物车添加的商品信息
     * @throws Exception
     */
    //添加订单详情
    public void insertOrderDetail( @Param("orderId") Long orderId , @Param("shopCarGoodsRelations")List<ShopCarGoodsRelation> shopCarGoodsRelation )throws Exception;


    /**
     * 立即购买 buyNow
     * @param orderGoodsRelation 订单详情
     * @throws Exception
     */
    //立即购买
    public void buyNow(@Param("orderGoodsRelation")OrderGoodsRelation orderGoodsRelation) throws Exception;

}
