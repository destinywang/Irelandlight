package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.model.ShopCar;
import com.irelandlight.model.ShopCarGoodsRelation;
import com.irelandlight.service.ShopCarGoodsRelationService;
import com.irelandlight.service.ShopCarService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/5
 * Time: 18:09
 * Description: shopCar controller .
 */

@Controller
@RequestMapping("/shopCar")
public class ShopCarController {

    private static ThreadLocal<Long> consumerId = new ThreadLocal<Long>();

    @Resource
    private ShopCarService shopCarService ;

    @Resource
    private ShopCarGoodsRelationService shopCarGoodsRelationService;

    @ResponseBody
    @RequestMapping("findShopCar")
    public String findShopCarByConsumerId()throws Exception {
        consumerId.set(1002L);
        ShopCar shopCar = shopCarService.findShopCarDetailByConsumerId(consumerId.get());

        return JSONObject.toJSONString(shopCar);
    }

    //查询用户购物车详情
    @RequestMapping(value = "findShopCarGoodsDetail", produces ="text/json;charset=utf-8")
    @ResponseBody
    public String findShopCarGoodsDetail()throws Exception {
        consumerId.set(1002L);
        ShopCar shopCarGoodsDetail =  shopCarService.findShopCarGoodsDetailByConsumerId(consumerId.get());
        //String shopCarGoodsDetailJson = JSONObject.toJSONString(shopCarGoodsDetail);
        //创建json对象
        JSONObject json = new JSONObject();
        //给json添加数据对象
        json.put("goods", shopCarGoodsDetail);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("shopCarGoodsDetail",shopCarGoodsDetail);
        return json.toJSONString();
       // return "shopCar/shopCar";
    }

    //商品添加购物车
    @ResponseBody
    @RequestMapping(value = "addShopCar")
    public String addShopCar(@RequestBody ShopCarGoodsRelation shopCarGoodsRelation)throws Exception{
        consumerId.set(1002L);
        shopCarGoodsRelationService.insertGoodsRelation(consumerId.get() ,shopCarGoodsRelation);
        JSONObject code = new JSONObject();
        code.put("statusCode",1);
        return code.toJSONString();
    }

    //商品批量移出购物车
    @ResponseBody
    @RequestMapping(value = "removeGoodsFromShopCar")
    public String removeGoodsFromShopCar(@RequestBody List<ShopCarGoodsRelation> shopCarGoodsRelations)throws Exception{
        shopCarGoodsRelationService.batchDeleteShopCarGoodsRelations(shopCarGoodsRelations);
        JSONObject code = new JSONObject();
        code.put("statusCode",1);
        return code.toJSONString();
    }

}
