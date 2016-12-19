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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    private static final ThreadLocal<Long> consumerId=new ThreadLocal<Long>();

    {
        consumerId.set(1001L);
    }

    @RequestMapping(value = "/collection", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/json;charset=UTF-8 ")
    @ResponseBody
    public String display()throws Exception{
        //展示我的收藏页
        //此处应该使用modelandview填充页面后返回
        List<GoodDisplay> collectionList= myCollectionServiceImpl.findMyCollection(consumerId.get());
        JSONObject json=new JSONObject();
        String collectionListJson=json.toJSONString( collectionList );
        return collectionListJson;
    }

    public void addCollection(@RequestBody ConsumerGoodsRelation consumerGoodsRelation)throws Exception{
        myCollectionServiceImpl.insertMyCollection(consumerGoodsRelation,consumerId.get());
    }

    public void deleteCollection(@RequestBody Long relationId)throws Exception{
        myCollectionServiceImpl.deleteMyCollection(relationId);
    }

    public void deleteCollectionList(@RequestBody  ArrayList<Long> collectionIdList) throws Exception {
        myCollectionServiceImpl.deleteCollectionList(collectionIdList);
    }

    public void addToShopCarFromCollection(@RequestBody ConsumerGoodsRelation relation)throws Exception{
        myCollectionServiceImpl.addToShopCarFromCollection(relation);
    }

    public void addToShopCarFromCollectionList(@RequestBody ArrayList<ConsumerGoodsRelation> collectionList )throws Exception{
        myCollectionServiceImpl.addToShopCarFromCollectionList(collectionList);
    }

}
