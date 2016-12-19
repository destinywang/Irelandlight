package com.irelandlight.service.impl;

import com.irelandlight.dao.CouponDao;
import com.irelandlight.dao.OrderDao;
import com.irelandlight.dao.OrderGoodsRelationDao;
import com.irelandlight.manager.OrderManager;
import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import com.irelandlight.service.OrderService;
import com.irelandlight.service.ShopCarGoodsRelationService;
import com.irelandlight.util.MakeOrderNum;
import com.irelandlight.vo.ShopCarOrderVo;
import com.sun.org.apache.bcel.internal.generic.DMUL;
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
    private OrderManager orderManager;

    @Resource
    private OrderGoodsRelationDao orderGoodsRelationDao;

    @Resource
    private ShopCarGoodsRelationService shopCarGoodsRelationService;

    @Resource
    private CouponDao couponDao;

    /**
     * 查找所有订单 findAllOrder
     * @return Lise<Order> 订单列表
     * @throws Exception yc
     */
    public List<Order> findAllOrder() throws Exception {
        List<Order> orders = orderManager.findAllOrder();
         if (orders == null){
             return null;
         }
         return orders;
    }

    /**
     * 查找某个用户的所有订单 findOrderByConsumerId
     * @param consumerId 用户id
     * @return Lise<Order> 订单列表
     * @throws Exception 异常
     */
    public List<Order> findOrderByConsumerId(Long consumerId) throws Exception {
        List<Order> orders = orderManager.findOrderByConsumerId(consumerId);
        if (orders == null){
            return null;
        }
        return orders;
    }

    /**
     * 查找用户的有效订单 findValidOrderByConsumerId
     * @param consumerId 用户id
     * @return List<Order> 订单列表
     * @throws Exception 异常
     */
    public List<Order> findValidOrderByConsumerId(Long consumerId) throws Exception {
        List<Order> orders = orderManager.findValidOrderByConsumerId(consumerId);
        if (orders == null){
            return null;
        }
        return orders;
    }


    /**
     * 查找用户的所有订单详情 findAllOrderDetailByConsumerId
     * @param consumerId 用户id
     * @return Consumer （resultMap）
     * @throws Exception 异常
     */
    public Consumer findAllOrderDetailByConsumerId(Long consumerId) throws Exception {
        return orderManager.findAllOrderDetailByConsumerId(consumerId);
    }

    /**
     * 查找某个订单详情 findOneOrderDetail
     * @param consumerId 用户id
     * @param orderId 订单号
     * @return Order 订单（resultMap）
     * @throws Exception 异常
     */
    public Order findOneOrderDetail(Long consumerId ,Long orderId ) throws Exception {
        Order order = orderManager.findOneOrderDetail(consumerId,orderId);
        if(order == null){
            return null;
        }
        return order;
    }

    /**
     * 查找用户某个状态的所有订单详情 findOneStatusOrderDetail
     * @param consumerId 用户Id
     * @param status 订单状态
     * @return Consumer （resultMap）
     * @throws Exception 异常
     */
    public Consumer findOneStatusOrderDetail(Long consumerId, Integer status) throws Exception {
        Consumer consumer = orderManager.findOneStatusOrderDetail(consumerId, status);
        if (consumer == null){
            return null;
        }
        return consumer;
    }

    /**
     * 新建订单，返回订单主键，用于插入订单详情 insertOrder
     * @param order 订单
     * @throws Exception 异常
     */
    public Integer insertOrder(Order order) throws Exception {
        if(orderManager.insertOrder(order) == 1){
            return 1;
        }
        return 0;
    }

    /**
     * 下单过程：
     * 用户购物车商品选中添加订单中，当点击去结算，发送购物车选择商品信息，更改所选购物车商品的状态为待加入订单详情（状态字：2），
     * 返回填写订单信息，点击去结算，先做订单信息生成，再从用户购物车选择该用户状态字为2 的购物车商品信息。
     * 为其添加订单号，插入订单详情列表，删除购物车商品详情
     * 完成订单创建。
     * 已过期
     *
     * 新下单过程
     *
     *
     */
    @Transactional
    public Integer placeAnOrder(ShopCarOrderVo shopCarOrderVo) throws Exception{

        Order order = shopCarOrderVo.getOrder();
        //利用工具类生成订单号，添加到订单中
        String orderNum = MakeOrderNum.makeOrderNum();
        shopCarOrderVo.getOrder().setOrderNumber(orderNum);
        //生成订单，返回主键
        if(insertOrder(shopCarOrderVo.getOrder())==1){
            return 1;
        }

        //添加订单详情
        orderGoodsRelationDao.insertOrderDetail(order.getId() ,shopCarOrderVo.getShopCarGoodsRelations());
        //删除购物车已购商品信息
        shopCarGoodsRelationService.batchDeleteShopCarGoodsRelations(shopCarOrderVo.getShopCarGoodsRelations());
        //删除已用优惠券
        Long couponId = order.getCouponId();
        if (couponId != null){
            if(couponDao.deleteCoupon(order.getConsumerId(),couponId)==0){
                System.out.println("优惠券使用失败");
            }
        }else {
            return 1;
        }
        return 0;
    }
}
