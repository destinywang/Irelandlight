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

    /**
     * 查找所有订单 findAllorder
     * @return Lise<Order> 订单列表
     * @throws Exception
     */
    public List<Order> findAllOrder() throws Exception {

        return orderDao.findAllOrder();
    }

    /**
     * 查找某个用户的所有订单 findOrderByConsumerId
     * @param consumerId
     * @return Lise<Order> 订单列表
     * @throws Exception
     */
    public List<Order> findOrderByConsumerId(Long consumerId) throws Exception {
        List<Order> orders = orderDao.findOrderByConsumerId(consumerId);
        return orders;
    }

    /**
     * 查找用户的有效订单 findValidOrderByConsumerId
     * @param consumerId
     * @return List<Order> 订单列表
     * @throws Exception
     */
    public List<Order> findValidOrderByConsumerId(Long consumerId) throws Exception {
        List<Order> orders = orderDao.findValidOrderByConsumerId(consumerId);
        return orders;
    }


    /**
     * 查找用户的所有订单详情 findAllOrderDetailByConsumerId
     * @param consumerId
     * @return Consumer （resultMap）
     * @throws Exception
     */
    public Consumer findAllOrderDetailByConsumerId(Long consumerId) throws Exception {
        Consumer consumer = orderDao.findAllOrderDetailByConsumerId(consumerId);
        return consumer;
    }

    /**
     * 查找某个订单详情 findOneOrderDetail
     * @param consumerId
     * @param orderId
     * @return Order 订单（resultMap）
     * @throws Exception
     */
    public Order findOneOrderDetail(Long consumerId ,Long orderId ) throws Exception {
        Order order = orderDao.findOneOrderDetail(consumerId,orderId);
        return order;
    }

    /**
     * 查找用户某个状态的所有订单详情 findOneStatusOrderDetail
     * @param consumerId
     * @param status
     * @return Consumer （resultMap）
     * @throws Exception
     */
    public Consumer findOneStatusOrderDetail(Long consumerId, Integer status) throws Exception {
        Consumer consumer = orderDao.findOneStatusOrderDetail(consumerId,status);
        return consumer;
    }

    /**
     * 新建订单，返回订单主键，用于插入订单详情 insertOrder
     * @param order
     * @throws Exception
     */
    public void insertOrder(Order order) throws Exception {
        orderDao.insertOrder(order);
    }
}
