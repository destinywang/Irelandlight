package com.irelandlight.service;

import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/9
 * Time: 16:58
 * Description: OrderService 接口 .
 */
public interface OrderService {

    //查询订单的所有信息
    public List<Order> findAllOrder() throws Exception;

    //查找某个用户的所有订单
    public List<Order> findOrderByConsumerId(@Param("consumerId") Long consumerId) throws Exception;

    //查找用户有效订单
    public List<Order> findValidOrderByConsumerId(@Param("consumerId") Long consumerId) throws Exception;

    //查找某个用户的所有订单详情
    public Consumer findAllOrderByConsumerId(@Param("consumerId") Long consumerId) throws Exception;

    //查询用户的某个订单详情
    public Order findOneOrderDetail( @Param("consumerId") Long consumerId  ) throws Exception;

    //查询用户的某种状态的订单信息
    public Consumer findOneStatusOrder( @Param("consumerId") Long consumerId , @Param("status") Integer status  ) throws Exception;

    //增加订单（下单） 返回订单ID
    public void insertOrder(@Param("order") Order order )throws Exception;
}
