package com.irelandlight.service.impl;

import com.irelandlight.manager.*;
import com.irelandlight.model.Order;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.OrderService;
import com.irelandlight.util.MakeOrderNum;
import com.irelandlight.vo.ShopCarOrderVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private OrderGoodsRelationManager orderGoodsRelationManager;

    @Resource
    private ShopCarGoodsRelationManager shopCarGoodsRelationManager;

    @Resource
    private CouponManager couponManager;

    @Resource
    private GoodsManager goodsManager;

    /**
     * 查找所有订单 findAllOrder
     *
     * @return Lise<Order> 订单列表
     * @throws Exception yc
     */
    public Map<String, Object> findAllOrder() throws Exception {
        return orderManager.findAllOrder();
    }

    /**
     *  查找某个用户的所有订单 findOrderByConsumerId
     * @param consumerId 用户id
     * @return Map<String,Object> map
     * @throws Exception 异常
     */
    public Map<String, Object> findOrderByConsumerId(Long consumerId) throws Exception {
        return orderManager.findOrderByConsumerId(consumerId);
    }

    /**
     * 查找用户的有效订单 findValidOrderByConsumerId
     *
     * @param consumerId 用户id
     * @return List<Order> 订单列表
     * @throws Exception 异常
     */
    public Map<String, Object> findValidOrderByConsumerId(Long consumerId) throws Exception {
        return orderManager.findValidOrderByConsumerId(consumerId);
    }


    /**
     * 查找用户的所有订单详情 findAllOrderDetailByConsumerId
     *
     * @param consumerId 用户id
     * @return Consumer （resultMap）
     * @throws Exception 异常
     */
    public Map<String, Object> findAllOrderDetailByConsumerId(Long consumerId) throws Exception {
        return orderManager.findAllOrderDetailByConsumerId(consumerId);
    }

    /**
     * 查找某个订单详情 findOneOrderDetail
     *
     * @param consumerId 用户id
     * @param orderId    订单号
     * @return Order 订单（resultMap）
     * @throws Exception 异常
     */
    public Map<String, Object> findOneOrderDetail(Long consumerId, Long orderId) throws Exception {
        return orderManager.findOneOrderDetail(consumerId, orderId);
    }

    /**
     * 查找用户某个状态的所有订单详情 findOneStatusOrderDetail
     *
     * @param consumerId 用户Id
     * @param status     订单状态
     * @return Consumer （resultMap）
     * @throws Exception 异常
     */
    public Map<String, Object> findOneStatusOrderDetail(Long consumerId, Integer status) throws Exception {
        return orderManager.findOneStatusOrderDetail(consumerId, status);
    }

    /**
     * 新建订单，返回订单主键，用于插入订单详情 insertOrder
     *
     * @param order 订单
     * @throws Exception 异常
     */
    public Map<String, Object> insertOrder(Order order) throws Exception {
        return orderManager.insertOrder(order);
    }

    /**
     * 下单过程：
     * 用户购物车商品选中添加订单中，当点击去结算，发送购物车选择商品信息，更改所选购物车商品的状态为待加入订单详情（状态字：2），
     * 返回填写订单信息，点击去结算，先做订单信息生成，再从用户购物车选择该用户状态字为2 的购物车商品信息。
     * 为其添加订单号，插入订单详情列表，删除购物车商品详情
     * 完成订单创建。
     * 已过期
     * <p>
     * 新下单过程
     *
     */
    @Transactional
    public Map<String, Object> placeAnOrder(ShopCarOrderVo shopCarOrderVo) throws Exception {
        Map<String, Object> rMap = new HashMap<String, Object>();
        Order order = shopCarOrderVo.getOrder();
        List<ShopCarGoodsRelation> shopCarGoodsRelations = shopCarOrderVo.getShopCarGoodsRelations();
        //利用工具类生成订单号，添加到订单中
        String orderNum = MakeOrderNum.makeOrderNum();
        order.setOrderNumber(orderNum);
        //添加订单
        // 生成订单，返回主键
        Map<String, Object> iOrder = insertOrder(order);
        Integer code = (Integer)iOrder.get("code");
        if (code == 0){         //添加订单成功
            //添加订单详情
            Map<String, Object> iODetail =orderGoodsRelationManager.insertOrderDetail(order.getId(),shopCarGoodsRelations);
            Integer code1 = (Integer) iODetail.get("code");
            if(code1 == 0){
                //删除购物车已购商品信息
                Map<String, Object> bdel = shopCarGoodsRelationManager.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations);
                Integer code2 = (Integer)bdel.get("code");
                if(code2 == 0){
                    Long couponId = order.getCouponId();
                    if (couponId != null){
                        //删除已用优惠券
                        Map<String, Object> delCoupon = couponManager.deleteCoupon(order.getConsumerId(),couponId);
                        Integer code3 = (Integer)delCoupon.get("code");
                        if(code3 == 0){
                            //修改库存和销量
                            Map<String, Object> update = goodsManager.updateBatchSaleQuantity(shopCarGoodsRelations);
                            Integer code4 = (Integer)update.get("code");
                            if(code4 == 0){
                                rMap.put("code",0);
                                rMap.put("status","添加订单商品成功");
                            }else if(code4 == 1){
                                rMap.put("code",0);
                                rMap.put("status","商品列表不存在");
                            }else {
                                rMap.put("code",2);
                                rMap.put("status","更新库存销量失败");
                            }
                        }else if(code3 == 1){
                            rMap.put("code",1);
                            rMap.put("status","用户不存在");
                        }else if(code3 == 2){
                            rMap.put("code",2);
                            rMap.put("status","优惠券不存在");
                        }else {
                            rMap.put("code",3);
                            rMap.put("status","优惠券删除失败");
                        }
                    }else{
                        Map<String, Object> update = goodsManager.updateBatchSaleQuantity(shopCarGoodsRelations);
                        Integer code4 = (Integer)update.get("code");
                        if(code4 == 0){
                            rMap.put("code", 0);
                            rMap.put("status","添加订单商品成功");
                        }else if(code4 == 1){
                            rMap.put("code", 0);
                            rMap.put("status" , "商品列表不存在");
                        }else {
                            rMap.put("code",2);
                            rMap.put("status ","更新库存销量失败");
                        }
                    }
                }else if(code2 == 1){
                    rMap.put("code",1);
                    rMap.put("status","无购物车详情信息");
                }else{
                    rMap.put("code",2);
                    rMap.put("status","删除购物车信息异常");
                }
            }else if(code1 == 1){
                rMap.put("code",1);
                rMap.put("status","订单号不存在");
            }else if (code1 == 2){
                rMap.put("code",2);
                rMap.put("status","商品信息不存在");
            }else {
                rMap.put("code",3);
                rMap.put("status","添加订单商品失败");
            }
        }else if (code == 1){
            rMap.put("code",1);
            rMap.put("status","订单不存在");
        }else{
            rMap.put("code",2);
            rMap.put("status","添加订单失败");
        }
        return  rMap;
    }
}
