package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.model.*;
import com.irelandlight.service.AddressService;
import com.irelandlight.service.CouponService;
import com.irelandlight.service.OrderService;
import com.irelandlight.vo.ShopCarOrderVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Observable;

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

    private static ThreadLocal<Long> consumerId = new ThreadLocal<Long>();

    @Resource
    private OrderService orderService;

    @Resource
    private AddressService addressService;

    @Resource
    private CouponService couponService;

    //下单
    @RequestMapping("/placeAnOrder")
    public String placeAnOrder( @RequestBody ShopCarOrderVo shopCarOrderVo)throws Exception{
        consumerId.set(1002L);
        Map<String,Object> map = orderService.placeAnOrder(shopCarOrderVo);
        if(map.get("code") == "0"){
            return "succeed";
        }
        return "error";
    }

    //查找某个用户的所有订单详情
    @ResponseBody
    @RequestMapping(value = "/findAllOrderDetail" ,produces = "text/json;charset=utf-8")
    public String allOrderDetail() throws Exception{
        consumerId.set(1002L);
        Map<String,Object> consumerMap = orderService.findAllOrderDetailByConsumerId(consumerId.get());
        Consumer consumer = (Consumer) consumerMap.get("consumer");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("consumer",consumer);

        return jsonObject.toJSONString();
    }

    //查找某个用户的某个状态的所有订单详情
    @ResponseBody
    @RequestMapping(value = "/oneStatusOrderDetail/{status}"  , method = RequestMethod.GET , produces = "text/json;charset=utf-8" )
    public String oneStatusOrderDetail(@PathVariable Integer status) throws Exception{
        //consumerId.set(1002L);
        Map<String,Object> consumerMap = orderService.findOneStatusOrderDetail(consumerId.get(),status);
        Consumer consumer = (Consumer) consumerMap.get("consumer");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("consumer",consumer);
        return jsonObject.toJSONString();
    }

    //查询某个订单的详情
    @ResponseBody
    @RequestMapping(value = "/oneOrderDetail/{orderId}"  , method = RequestMethod.GET , produces = "text/json;charset=utf-8" )
    public String oneOrderDetail(@PathVariable Long orderId) throws Exception{
        consumerId.set(1002L);
        Map<String,Object> order = orderService.findOneOrderDetail(consumerId.get(),orderId);

        //Thread thread = Thread.currentThread();
        //System.out.println(thread);

        JSONObject jsonObject = new JSONObject();
        if (order == null){
            jsonObject.put("error","未查询到订单详情");
        }else{
            jsonObject.put("order",order);
        }
        return jsonObject.toJSONString();
    }

    //生成订单填写页面（地址，优惠券）
    @RequestMapping(value ="/generateOrderPage" , produces = "text/json;charset=utf-8")
    public ModelAndView generateOrderPage() throws Exception {
        consumerId.set(1002L);
        Map<String,Object> addresses = addressService.findAddressByConsumerId(consumerId.get());
        Map<String,Object> coupons = couponService.findCouponByConsumerId(consumerId.get());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("addresses",addresses);
        jsonObject.put("coupons",coupons);
        ModelAndView modelAndView = new ModelAndView("succeed");
        modelAndView.addObject("addressAndCoupon",jsonObject);


        return modelAndView;
    }

}
