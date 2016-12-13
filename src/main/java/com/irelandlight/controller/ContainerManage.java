package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.service.GoodsContainerService;
import com.irelandlight.vo.ItemsInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by mac on 2016/12/13.
 */
@Controller
@RequestMapping("/container")
public class ContainerManage {
    @Resource
    private GoodsContainerService containerService;

    @RequestMapping(value = "/queryGoodsSimpleInfo",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public  ItemsInfo showGoodsCountInfo(){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();
        return itemsInfo;
    }

    @RequestMapping(value = "/queryGoodsInfo",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView showGoodsCountInfo(ModelAndView model){
        ItemsInfo itemsInfo=containerService.searchForGoodsCountInfo();

        model.addObject("itemsInfo",itemsInfo);
        model.setViewName("");  //待填充,需要前端的页面名称
        return model;
    }



}
