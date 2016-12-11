package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.model.Consumer;
import com.irelandlight.model.Order;
import com.irelandlight.service.OrderService;
import com.irelandlight.vo.ShopCarOrderVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 15:09
 * Description: 订单controller.
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    private static final ThreadLocal<Long> consumerId = new ThreadLocal<Long>();

    static {
        consumerId.set(1002L);
    }

    @Resource
    private OrderService orderService;

    //下单
    @RequestMapping("/placeAnOrder")
    public String placeAnOrder( @RequestBody ShopCarOrderVo shopCarOrderVo)throws Exception{

        orderService.placeAnOrder(shopCarOrderVo);

        return "succeed";
    }

    //查找某个用户的所有订单详情
    @ResponseBody
    @RequestMapping(value = "/findAllOrderDetail" ,produces = "text/json;charset=utf-8")
    public String allOrderDetail() throws Exception{

        Consumer consumer = orderService.findAllOrderDetailByConsumerId(consumerId.get());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("consumer",consumer);

        return jsonObject.toJSONString();
    }

    //查找某个用户的某个状态的所有订单详情
    @ResponseBody
    @RequestMapping(value = "/oneStatusOrderDetail/{status}"  , method = RequestMethod.GET , produces = "text/json;charset=utf-8" )
    public String oneStatusOrderDetail(@PathVariable Integer status) throws Exception{

        Consumer consumer = orderService.findOneStatusOrderDetail(consumerId.get(),status);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("consumer",consumer);

        return jsonObject.toJSONString();
    }

    //查询某个订单的详情
    @ResponseBody
    @RequestMapping(value = "/oneOrderDetail/{orderId}"  , method = RequestMethod.GET , produces = "text/json;charset=utf-8" )
    public String oneOrderDetail(@PathVariable Long orderId) throws Exception{

        Order order = orderService.findOneOrderDetail(consumerId.get(),orderId);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("order",order);

        return jsonObject.toJSONString();
    }

}
