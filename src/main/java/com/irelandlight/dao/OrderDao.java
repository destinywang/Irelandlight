package com.irelandlight.dao;

import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/6
 * Time: 16:32
 * Description: 订单 dao .
 */
@Repository
public interface OrderDao {

    /**
     * 查询订单的所有信息 findAllOrder
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查询订单的所有信息
    public List<Order> findAllOrder() throws Exception;


    /**
     * 查找某个用户的所有订单 findOrderByConsumerId
     * @param consumerId 用户id
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查找某个用户的所有订单
    public List<Order> findOrderByConsumerId(@Param("consumerId") Long consumerId) throws Exception;


    /**
     * 查找用户有效订单 findValidOrderByConsumerId
     * @param consumerId 用户id
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查找用户有效订单
    public List<Order> findValidOrderByConsumerId(@Param("consumerId") Long consumerId) throws Exception;

    /**
     * 查找某个用户的所有订单详情 findAllOrderByConsumerId
     * @param consumerId
     * @return
     * @throws Exception
     */
    //查找某个用户的所有订单详情
    public Consumer findAllOrderDetailByConsumerId(@Param("consumerId") Long consumerId) throws Exception;

    /**
     * 查询用户的某个订单详情 findOneOrderDetail
     * @param consumerId 用户id
     * @return List<Order> 订单列表
     * @throws Exception
     */
    //查询用户的某个订单详情
    public Order findOneOrderDetail( @Param("consumerId") Long consumerId , @Param("orderId") Long orderId ) throws Exception;


    /**
     * 查询用户的某种状态的订单信息 findOneStatusOrder
     * @param consumerId 用户id
     * @param status 订单状态
     * @return Consumer 用户订单map
     * @throws Exception
     */
    //查询用户的某种状态的订单信息
    public Consumer findOneStatusOrderDetail( @Param("consumerId") Long consumerId , @Param("status") Integer status  ) throws Exception;

    /**
     * 增加订单（下单） insertOrder
     * @param order 订单参数
     * @throws Exception
     *
     * insert 添加，返回自增主键时候，参数不能添加@param 注释，否则自增主键无法绑定到原对象。
     */
    //增加订单（下单） 返回订单ID
    public void insertOrder(Order order )throws Exception;

}
