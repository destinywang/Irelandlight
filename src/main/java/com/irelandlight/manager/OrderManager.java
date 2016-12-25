package com.irelandlight.manager;

import com.irelandlight.dao.OrderDao;
import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/15
 * Time: 22:49
 * Description: orderManager .
 */
@Component("orderManager")
public class OrderManager {

    @Resource
    private OrderDao orderDao;

    /**
     * 查询订单的所有信息 findAllOrder
     *
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查询订单的所有信息
    public Map<String , Object> findAllOrder() throws Exception {
        Map<String ,Object> findOrders = new HashMap<String,Object>();
        List<Order> orders = orderDao.findAllOrder();
        if (orders == null) {
            findOrders.put("code",1);
            findOrders.put("status","订单不存在");
            return findOrders;
        }
        findOrders.put("code",0);
        findOrders.put("orders",orders);
        return findOrders;
    }


    /**
     * 查找某个用户的所有订单 findOrderByConsumerId
     *
     * @param consumerId 用户id
     * @return List<Order>   订单列表
     * @throws Exception
     */
    //查找某个用户的所有订单
    public Map<String , Object> findOrderByConsumerId(Long consumerId) throws Exception {
        Map<String ,Object> findOrders = new HashMap<String,Object>();
        if (consumerId == null || consumerId < 0) {
            findOrders.put("code",1);
            findOrders.put("status","用户不存在");
            return findOrders;
        }
        List<Order> orders = orderDao.findOrderByConsumerId(consumerId);
        if (orders == null) {
            findOrders.put("code",1);
            findOrders.put("status","无订单");
            return findOrders;
        }
        findOrders.put("code",1);
        findOrders.put("orders",orders);
        return findOrders;
    }


    /**
     * 查找用户有效订单 findValidOrderByConsumerId
     *
     * @param consumerId 用户id
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查找用户有效订单
    public Map<String , Object> findValidOrderByConsumerId(Long consumerId) throws Exception {
        Map<String ,Object> findOrders = new HashMap<String,Object>();
        if (consumerId == null || consumerId < 0) {
            findOrders.put("code",1);
            findOrders.put("status","用户不存在");
            return findOrders;
        }
        List<Order> orders = orderDao.findValidOrderByConsumerId(consumerId);
        if (orders == null) {
            findOrders.put("code",1);
            findOrders.put("status","无订单");
            return findOrders;
        }
        findOrders.put("code",1);
        findOrders.put("orders",orders);
        return findOrders;
    }

    /**
     * 查找某个用户的所有订单详情 findAllOrderByConsumerId
     *
     * @param consumerId
     * @return
     * @throws Exception
     */
    //查找某个用户的所有订单详情
    public Map<String , Object> findAllOrderDetailByConsumerId(Long consumerId) throws Exception {
        Map<String ,Object> findOrderDetails = new HashMap<String,Object>();
        if (consumerId == null || consumerId < 0) {
            findOrderDetails.put("code",1);
            findOrderDetails.put("status","用户不存在");
            return findOrderDetails;
        }
        Consumer consumer = orderDao.findAllOrderDetailByConsumerId(consumerId);
        if (consumer == null) {
            findOrderDetails.put("code",1);
            findOrderDetails.put("status","无订单详情");
            return findOrderDetails;
        }
        findOrderDetails.put("code",0);
        findOrderDetails.put("consumer",consumer);
        return findOrderDetails;
    }

    /**
     * 查询用户的某个订单详情 findOneOrderDetail
     *
     * @param consumerId 用户id
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查询用户的某个订单详情
    public Map<String , Object> findOneOrderDetail(Long consumerId, Long orderId) throws Exception {
        Map<String ,Object> oneOrderDetails = new HashMap<String,Object>();

        if (consumerId == null || consumerId < 0) {
            oneOrderDetails.put("code",1);
            oneOrderDetails.put("status","用户不存在");
            return oneOrderDetails;
        }
        if (orderId == null || orderId < 0) {
            oneOrderDetails.put("code",2);
            oneOrderDetails.put("status","订单不存在");
            return oneOrderDetails;
        }
        Order order = orderDao.findOneOrderDetail(consumerId, orderId);
        if (order == null) {
            oneOrderDetails.put("code",3);
            oneOrderDetails.put("status","无此订单信息");
            return oneOrderDetails;
        }
        oneOrderDetails.put("code",0);
        oneOrderDetails.put("order",order);
        return oneOrderDetails;
    }


    /**
     * 查询用户的某种状态的订单信息 findOneStatusOrder
     *
     * @param consumerId 用户id
     * @param status     订单状态
     * @return Consumer 用户订单map
     * @throws Exception
     */
    //查询用户的某种状态的订单信息
    public Map<String , Object> findOneStatusOrderDetail(Long consumerId, Integer status) throws Exception {
        Map<String ,Object> oneStatusOrderDetails = new HashMap<String,Object>();
        if (consumerId == null || consumerId < 0) {
            oneStatusOrderDetails.put("code",1);
            oneStatusOrderDetails.put("status","用户不存在");
            return oneStatusOrderDetails;
        }
        if (status == null || status < 0) {
            oneStatusOrderDetails.put("code",2);
            oneStatusOrderDetails.put("status","状态不存在");
            return oneStatusOrderDetails;
        }
        Consumer consumer = orderDao.findOneStatusOrderDetail(consumerId, status);
        if (consumer == null) {
            oneStatusOrderDetails.put("code",1);
            oneStatusOrderDetails.put("status","无订单详情");
            return oneStatusOrderDetails;
        }
        oneStatusOrderDetails.put("code",0);
        oneStatusOrderDetails.put("consumer",consumer);
        return oneStatusOrderDetails;
        }

    /**
     * 增加订单（下单） insertOrder
     *
     * @param order 订单参数
     * @throws Exception insert 添加，返回自增主键时候，参数不能添加@param 注释，否则自增主键无法绑定到原对象。
     */
    //增加订单（下单） 返回订单ID
    public Map<String , Object> insertOrder(Order order) throws Exception {
        Map<String ,Object> insertOrder = new HashMap<String,Object>();
        if (order == null) {
            insertOrder.put("code",1);
            insertOrder.put("status","订单不存在");
            return insertOrder;
        }
        if (orderDao.insertOrder(order)== 0) {
            insertOrder.put("code",2);
            insertOrder.put("status","添加订单失败");
            return insertOrder;
        }
        insertOrder.put("code",0);
        insertOrder.put("status","添加订单成功");
        return insertOrder;
    }
}
