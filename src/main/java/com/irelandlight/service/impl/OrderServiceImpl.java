package com.irelandlight.service.impl;

import com.irelandlight.dao.OrderDao;
import com.irelandlight.dao.OrderGoodsRelationDao;
import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import com.irelandlight.service.OrderService;
import com.irelandlight.service.ShopCarGoodsRelationService;
import com.irelandlight.util.MakeOrderNum;
import com.irelandlight.vo.ShopCarOrderVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Resource
    private ShopCarGoodsRelationService shopCarGoodsRelationService;


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

    /**
     * 下单过程：
     * 用户购物车商品选中添加订单中，当点击去结算，发送购物车选择商品信息，更改所选购物车商品的状态为待加入订单详情（状态字：2），
     * 返回填写订单信息，点击去结算，先做订单信息生成，再从用户购物车选择该用户状态字为2 的购物车商品信息。
     * 为其添加订单号，插入订单详情列表，删除购物车商品详情
     * 完成订单创建。
     */

    /**
     *
     * 下单过程2：
     * 给用户
     *
     */

    @Transactional
    public void placeAnOrder(ShopCarOrderVo shopCarOrderVo) throws Exception{

        //利用工具类生成订单号，添加到订单中
        String orderNum = MakeOrderNum.makeOrderNum();
        shopCarOrderVo.getOrder().setOrderNumber(orderNum);
        //生成订单，返回主键
        insertOrder(shopCarOrderVo.getOrder());
        //添加订单详情
        orderGoodsRelationDao.insertOrderDetail(shopCarOrderVo.getOrder().getId() ,shopCarOrderVo.getShopCarGoodsRelations());
        //删除购物车已购商品信息
        shopCarGoodsRelationService.batchDeleteShopCarGoodsRelations(shopCarOrderVo.getShopCarGoodsRelations());

    }


}
