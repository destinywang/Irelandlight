package com.irelandlight.controller;

import com.irelandlight.service.OrderManageService;
import com.irelandlight.util.ImgeUploadUtil;
import com.irelandlight.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by mac on 2016/12/13.
 */
@Controller
@RequestMapping("/order")
public class OrderManage {
    @Resource
    private OrderManageService orderManageService;

    /**
     * 展示订单基本信息
     * @return OrderInfo
     */
    @RequestMapping(value = "/queryOrderSimpleInfo",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public OrderInfo showOrderSimpleInfo(){
        OrderInfo orderInfo=orderManageService.queryOrderInfo();
        return orderInfo;
    }

    /**
     * 展示订单信息列表
     * @return List<OrderSimpleInfo>
     */
    @RequestMapping(value = "/queryOrderList",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public List<OrderSimpleInfo> showSimpleOrderList(){
        List<OrderSimpleInfo> orderSimpleInfoList=orderManageService.queryOrderSimpleInfoList();
        return orderSimpleInfoList;
    }

    /**
     * 展示订单的信息，以及订单中所包含的商品基本信息
     * @param orderId
     * @return Map<String,Object>
     */
    @RequestMapping(value = "/queryOrderDetail",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Map<String,Object> showOrderDetaiByOrderId(@RequestParam("orderId") Long orderId){
        Map<String,Object> orderDetail=new HashMap<String,Object>();
        OrderDetail orderInfo=orderManageService.queryOrderDetaiByOrderId(orderId);
        List<OrderGoodsDetail> orderGoodsInfo=orderManageService.queryOrderGoodsDetail(orderId);
        orderDetail.put("orderInfo",orderInfo);
        orderDetail.put("orderGoodsInfoList",orderGoodsInfo);
        return orderDetail;
    }

    @RequestMapping(value = "/modifyOrder",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String modifyOrder(ModelAndView mv,Long orderId,OrderModify orderModify)throws Exception{
        if(paramValidate(orderModify)){
            mv.setViewName("errorPage");
        }
        String message="Modify success!";
        if(orderManageService.modifyOrderById(orderId,orderModify)){message="Modify success!";}
        return message;
    }


    private boolean paramValidate(OrderModify orderModify){
        if(orderModify.getTransferWay()==null) return false;
        if(orderModify.getTransferEnd()==null) return false;
        if(orderModify.getTransferBegin()==null) return false;
        if(orderModify.getOrderStatus()==null) return false;
        return true;
    }


}