package com.irelandlight.service.impl;

import com.irelandlight.dao.OrderGoodsRelationDao;
import com.irelandlight.model.OrderGoodsRelation;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.OrderGoodsRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    private OrderGoodsRelationDao orderGoodsRelationDao;


    public void insertOrderDetail(Long orderId, List<ShopCarGoodsRelation> shopCarGoodsRelation) throws Exception {
        orderGoodsRelationDao.insertOrderDetail(orderId,shopCarGoodsRelation);
    }

    public void buyNow(OrderGoodsRelation orderGoodsRelation) throws Exception {
        orderGoodsRelationDao.buyNow(orderGoodsRelation);
    }
}
