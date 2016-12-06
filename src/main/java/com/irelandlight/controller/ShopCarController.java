package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.irelandlight.model.ShopCar;
import com.irelandlight.service.ShopCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 18:09
 * Description: 目的... .
 */

@Controller
@RequestMapping("/shopCar")
public class ShopCarController {

    @Autowired
    private ShopCarService shopCarService ;

    @RequestMapping("findShopCar")
    public String findShopCarByConsumerId(Long consumerId) throws Exception {
        shopCarService.findShopCarByConsumerId(consumerId);


        return "shopCar/shopCar";
    }

    @RequestMapping("findShopCarGoodsDetail")
    @ResponseBody
    public String findShopCarGoodsDetail(Long consumerId) throws Exception {
        ShopCar shopCarGoodsDetail =  shopCarService.findShopCarGoodsDetailByConsumerId(consumerId);
        //String shopCarGoodsDetailJson = JSONObject.toJSONString(shopCarGoodsDetail);
        JSONObject json = new JSONObject();
        json.put("goods", shopCarGoodsDetail);
//        json.put("goodsName", );
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("shopCarGoodsDetail",shopCarGoodsDetail);
        return json.toJSONString();
       // return "shopCar/shopCar";
    }





}
