package com.irelandlight.service;

import com.irelandlight.model.OrderGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/9
 * Time: 16:58
 * Description: 订单详情service 接口 .
 */
public interface OrderGoodsRelationService {

    //添加订单详情
    public void insertOrderDetail(@Param("orderId") Long orderId , @Param("shopCarGoodsRelation")List<ShopCarGoodsRelation> shopCarGoodsRelation )throws Exception;

    //立即购买
    public void buyNow(@Param("orderGoodsRelation")OrderGoodsRelation orderGoodsRelation) throws Exception;

}
