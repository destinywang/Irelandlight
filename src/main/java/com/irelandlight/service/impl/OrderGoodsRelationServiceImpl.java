package com.irelandlight.service.impl;

import com.irelandlight.manager.OrderGoodsRelationManager;
import com.irelandlight.model.OrderGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.OrderGoodsRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/9
 * Time: 17:55
 * Description: 订单详情service实现类.
 */
@Service
public class OrderGoodsRelationServiceImpl implements OrderGoodsRelationService {

    @Resource
    private OrderGoodsRelationManager orderGoodsRelationManager;

    /**
     * 添加订单详情 insertOrderDetail
     * @param orderId 订单号
     * @param shopCarGoodsRelations 购物车详情信息
     * @return Map<String , Object> rMap
     * @throws Exception 异常
     */
    //添加订单详情
    public Map<String,Object> insertOrderDetail(Long orderId , List<ShopCarGoodsRelation> shopCarGoodsRelations) throws Exception {
        return orderGoodsRelationManager.insertOrderDetail(orderId,shopCarGoodsRelations);
    }

    /**
     * 立刻购买 buyNow
     * @param orderGoodsRelation 订单详情
     * @return Map<String , Object> rMap
     * @throws Exception 异常
     */
    //立刻购买
    public Map<String,Object> buyNow(OrderGoodsRelation orderGoodsRelation) throws Exception {
        return orderGoodsRelationManager.buyNow(orderGoodsRelation);
    }
}
