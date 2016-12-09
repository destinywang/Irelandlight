package com.irelandlight.service.impl;

import com.irelandlight.dao.OrderDao;
import com.irelandlight.dao.OrderGoodsRelationDao;
import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import com.irelandlight.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/9
 * Time: 17:42
 * Description: 订单详情service实现类.
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;

    @Resource
    private OrderGoodsRelationDao orderGoodsRelationDao;

    public List<Order> findAllOrder() throws Exception {

        return orderDao.findAllOrder();
    }

    public List<Order> findOrderByConsumerId(Long consumerId) throws Exception {
        List<Order> orders = orderDao.findOrderByConsumerId(consumerId);
        return orders;
    }

    public List<Order> findValidOrderByConsumerId(Long consumerId) throws Exception {
        List<Order> orders = orderDao.findValidOrderByConsumerId(consumerId);
        return orders;
    }

    public Consumer findAllOrderByConsumerId(Long consumerId) throws Exception {
        Consumer consumer = orderDao.findAllOrderByConsumerId(consumerId);
        return consumer;
    }

    public Order findOneOrderDetail(Long consumerId) throws Exception {
        Order order = orderDao.findOneOrderDetail(consumerId);
        return order;
    }

    public Consumer findOneStatusOrder(Long consumerId, Integer status) throws Exception {
        Consumer consumer = orderDao.findOneStatusOrder(consumerId,status);
        return null;
    }

    public void insertOrder(Order order) throws Exception {
        orderDao.insertOrder(order);
    }
}
