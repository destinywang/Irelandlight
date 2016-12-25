package com.irelandlight.service;

import com.alibaba.fastjson.JSON;
import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.test.BaseJunitTest;
import com.irelandlight.vo.ShopCarOrderVo;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/9
 * Time: 22:49
 * Description: 订单service测试 .
 */
public class OrderTest extends BaseJunitTest {

    @Resource
    private OrderService orderService;

    //查询订单的所有信息
    @Test
    public void testFindAllOrder() throws Exception{
        Map<String,Object> orders = orderService.findAllOrder();
        System.out.println(orders);
    }
    //查找某个用户的所有订单
    @Test
    public void testFindOrderByConsumerId() throws Exception{
        Map<String,Object> orders = orderService.findOrderByConsumerId(1002L);
        System.out.println(orders);
    }

    //查找用户有效订单
    @Test
    public void testFindValidOrderByConsumerId() throws Exception{
        Map<String,Object> orders = orderService.findValidOrderByConsumerId(1002L);
        System.out.println(orders);
    }
    //查找某个用户的所有订单详情
    @Test
    public void testFindAllOrderDetailByConsumerId() throws Exception{
        Map<String,Object> consumer = orderService.findAllOrderDetailByConsumerId(1002L);
        System.out.println(consumer);
    }
    //查询用户的某个订单详情
    @Test
    public void testFindOneOrderDetail() throws Exception{
        Map<String,Object> order = orderService.findOneOrderDetail(1002L,2L);
        System.out.println(order);
    }
    //查询用户的某种状态的订单信息
    @Test
    public void testFindOneStatusOrderDetail() throws Exception{
        Map<String,Object> consumer = orderService.findOneStatusOrderDetail(1001L,1);
        System.out.println(consumer);
    }
    //增加订单（下单） 返回订单ID
    @Test
    public void testInsertOrder() throws Exception{
        Order order = new Order();
        order.setConsumerId(1002L);
        order.setAddressId(2L);
        order.setCouponId(2L);
        order.setGift("小礼物");
        order.setOrderNumber("cx04141061");
        order.setPayWay(1);
        order.setTransferWay(1);
        order.setTableWareCount(4);
        order.setPrice(new BigDecimal(123.38));
        order.setRemark("生日快乐");
        order.setTransferTime("今天下午两点");
        System.out.println(order.getPrice());

        List<ShopCarGoodsRelation> shopCarGoodsRelations = new ArrayList<ShopCarGoodsRelation>();
        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        ShopCarGoodsRelation shopCarGoodsRelation2 = new ShopCarGoodsRelation();

        shopCarGoodsRelation.setGoodsId(1L);
        shopCarGoodsRelation.setSize("2");
        shopCarGoodsRelation.setCount(4);

        shopCarGoodsRelation2.setGoodsId(2L);
        shopCarGoodsRelation2.setSize("2");
        shopCarGoodsRelation2.setCount(6);

        shopCarGoodsRelations.add(shopCarGoodsRelation);
        shopCarGoodsRelations.add(shopCarGoodsRelation2);
        orderService.insertOrder(order);
        System.out.println(order.getId());
    }

    @Test
    public void testPlaceAnOrder()throws Exception{

        Order order = new Order();
        order.setConsumerId(1002L);
        order.setAddressId(2L);
        order.setCouponId(2L);
        order.setGift("小礼物");
        order.setOrderNumber("cx04141061");
        order.setPayWay(1);
        order.setTransferWay(1);
        order.setTableWareCount(4);
        order.setPrice(new BigDecimal(123.38));
        order.setRemark("生日快乐");
        order.setTransferTime("今天下午两点");

        List<ShopCarGoodsRelation> shopCarGoodsRelations = new ArrayList<ShopCarGoodsRelation>();
        ShopCarGoodsRelation shopCarGoodsRelation = new ShopCarGoodsRelation();
        ShopCarGoodsRelation shopCarGoodsRelation2 = new ShopCarGoodsRelation();

        shopCarGoodsRelation.setGoodsId(1L);
        shopCarGoodsRelation.setSize("2");
        shopCarGoodsRelation.setCount(4);
        shopCarGoodsRelation.setShopCarId(1L);

        shopCarGoodsRelation2.setGoodsId(2L);
        shopCarGoodsRelation2.setSize("2");
        shopCarGoodsRelation2.setCount(6);
        shopCarGoodsRelation2.setShopCarId(1L);

        shopCarGoodsRelations.add(shopCarGoodsRelation);
        shopCarGoodsRelations.add(shopCarGoodsRelation2);


        ShopCarOrderVo shopCarOrderVo = new ShopCarOrderVo();
        shopCarOrderVo.setOrder(order);
        shopCarOrderVo.setShopCarGoodsRelations(shopCarGoodsRelations);

        String s = JSON.toJSONString(shopCarOrderVo);
        System.out.println(s);
        orderService.placeAnOrder(shopCarOrderVo);

    }
}
