package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.model.ConsumerGoodsRelation;
import com.irelandlight.service.MyCollectionService;
import com.irelandlight.vo.GoodDisplay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: Matt
 * Date: 2016/12/15
 * Time: 18:52
 * Description: description
 */
@Controller
public class MyCollectionController {

    @Resource
    private MyCollectionService myCollectionServiceImpl;

    private static final ThreadLocal<Long> consumerId = new ThreadLocal<Long>();

    {
        consumerId.set(1001L);
    }

    @RequestMapping(value = "/collection", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/json;charset=UTF-8 ")
    public ModelAndView display() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Map<String, Object> updateStatus = myCollectionServiceImpl.findMyCollection(consumerId.get());
        Integer status = Integer.valueOf(updateStatus.get("status").toString());
        if (status == 0) {
            modelAndView.addObject(updateStatus.get("msg"));
            modelAndView.setViewName("display");
        } else {
            modelAndView.setViewName("ERROR");
        }
        return modelAndView;
    }

    @ResponseBody
    public String addCollection(@RequestBody ConsumerGoodsRelation consumerGoodsRelation) throws Exception {
        Map<String, Object> updateStatus = myCollectionServiceImpl.insertMyCollection(consumerGoodsRelation, consumerId.get());
        JSONObject jsonObject=new JSONObject();
        String msg=jsonObject.toJSONString(updateStatus.get("msg").toString());
        return msg;
    }

    @ResponseBody
    public String deleteCollection(@RequestBody Long relationId) throws Exception {
        Map<String, Object> updateStatus =myCollectionServiceImpl.deleteMyCollection(relationId);
        JSONObject jsonObject=new JSONObject();
        String msg=jsonObject.toJSONString(updateStatus.get("msg").toString());
        return msg;
    }

    @ResponseBody
    public String deleteCollectionList(@RequestBody ArrayList<Long> collectionIdList) throws Exception {
        Map<String, Object> updateStatus = myCollectionServiceImpl.deleteCollectionList(collectionIdList);
        JSONObject jsonObject=new JSONObject();
        String msg=jsonObject.toJSONString(updateStatus.get("msg").toString());
        return msg;
    }

    @ResponseBody
    public String addToShopCarFromCollection(@RequestBody ConsumerGoodsRelation relation) throws Exception {
        Map<String, Object> updateStatus = myCollectionServiceImpl.addToShopCarFromCollection(relation);
        JSONObject jsonObject=new JSONObject();
        String msg=jsonObject.toJSONString(updateStatus.get("msg").toString());
        return msg;
    }

    @ResponseBody
    public String addToShopCarFromCollectionList(@RequestBody ArrayList<ConsumerGoodsRelation> collectionList) throws Exception {
        Map<String, Object> updateStatus = myCollectionServiceImpl.addToShopCarFromCollectionList(collectionList);
        JSONObject jsonObject=new JSONObject();
        String msg=jsonObject.toJSONString(updateStatus.get("msg").toString());
        return msg;
    }

}
