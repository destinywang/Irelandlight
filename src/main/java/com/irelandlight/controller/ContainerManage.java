package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.service.GoodsContainerService;
import com.irelandlight.vo.ContainerItem;
import com.irelandlight.vo.ItemsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mac on 2016/12/13.
 */
@Controller
@RequestMapping("/container")
public class ContainerManage {
    @Resource
    private GoodsContainerService containerService;

    //展示商品页的基本商品数量统计信息
    @RequestMapping(value = "/queryGoodsSimpleInfo",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  ItemsInfo showGoodsCountInfo(){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();
        return itemsInfo;
    }
    //展示商品页的基本商品数量统计信息,如果不是ajax请求则用这个方法
    @RequestMapping(value = "/queryGoodsInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView showGoodsCountInfo(ModelAndView model){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();

        model.addObject("itemsInfo",itemsInfo);
        model.setViewName("");  //待填充,需要前端的页面名称
        return model;
    }
    //查询未上架商品列表在商品上架选项卡显示
    @RequestMapping(value = "/queryUnputawayGoods",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<ContainerItem> showUnputawayGoods(){
        List<ContainerItem> containerItemList=null;
        containerItemList=containerService.searchForUnPutawayGoods();
        return containerItemList;
    }
    @RequestMapping(value = "/queryPutawayGoods",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public List<ContainerItem> showputawayGoods(){
        List<ContainerItem> containerItemList=null;
        containerItemList=containerService.searchForPutawayGoods();
        return containerItemList;
    }



}
