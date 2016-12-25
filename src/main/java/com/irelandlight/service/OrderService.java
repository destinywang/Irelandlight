package com.irelandlight.service;

import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import com.irelandlight.vo.ShopCarOrderVo;

import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/9
 * Time: 16:58
 * Description: OrderService 接口 .
 */
public interface OrderService {

    /**
     * 查找所有订单 findAllorder
     * @return Lise<Order> 订单列表
     * @throws Exception
     */
    //查询订单的所有信息
    public Map<String, Object> findAllOrder() throws Exception;

    /**
     * 查找某个用户的所有订单 findOrderByConsumerId
     * @param consumerId
     * @return Lise<Order> 订单列表
     * @throws Exception
     */
    //查找某个用户的所有订单
    public Map<String, Object> findOrderByConsumerId(Long consumerId) throws Exception;

    /**
     * 查找用户的有效订单 findValidOrderByConsumerId
     * @param consumerId
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查找用户有效订单
    public Map<String, Object> findValidOrderByConsumerId(Long consumerId) throws Exception;

    /**
     * 查找用户的所有订单详情 findAllOrderDetailByConsumerId
     * @param consumerId
     * @return Consumer （resultMap）
     * @throws Exception
     */
    //查找某个用户的所有订单详情
    public Map<String, Object> findAllOrderDetailByConsumerId(Long consumerId) throws Exception;

    /**
     * 查找某个订单详情 findOneOrderDetail
     * @param consumerId
     * @param orderId
     * @return Order 订单（resultMap）
     * @throws Exception
     */
    //查询用户的某个订单详情
    public Map<String, Object> findOneOrderDetail(Long consumerId ,Long orderId ) throws Exception;

    /**
     * 查找用户某个状态的所有订单详情 findOneStatusOrderDetail
     * @param consumerId
     * @param status
     * @return Consumer （resultMap）
     * @throws Exception
     */
    //查询用户的某种状态的订单信息
    public Map<String, Object> findOneStatusOrderDetail(Long consumerId ,Integer status) throws Exception;

    /**
     * 新建订单，返回订单主键，用于插入订单详情 insertOrder
     * @param order
     * @throws Exception
     */
    //增加订单（下单） 返回订单ID
    public Map<String, Object> insertOrder(Order order)throws Exception;

    public Map<String, Object> placeAnOrder(ShopCarOrderVo shopCarOrderVo) throws Exception;
}
