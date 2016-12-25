package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.service.MyHistoryService;
import com.irelandlight.vo.GoodDisplay;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * User: Matt
 * Date: 2016/12/18
 * Time: 12:16
 * Description: MyHistoryController
 */
@Controller
public class MyHistoryController {

    @Resource
    private MyHistoryService myHistoryServiceImpl;

    private final ThreadLocal<Long> consumerId = new ThreadLocal<Long>();

    @RequestMapping(value = "/history", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/json;charset=UTF-8 ")
    public ModelAndView display() throws Exception {
        consumerId.set(1001l);
        ModelAndView modelAndView=new ModelAndView();
        List<GoodDisplay> historyList = myHistoryServiceImpl.findMyHistory(consumerId.get());
        System.out.println(historyList);
        JSONObject json = new JSONObject();
        String historyListJson = json.toJSONString(historyList);
        return modelAndView;
    }

    public void deleteMyHistory(@RequestBody Long historyId)throws Exception{
        myHistoryServiceImpl.deleteMyHistory(historyId);
    }

    public void deleteMyHistory(@RequestBody List<Long> historyIdList)throws Exception{
        myHistoryServiceImpl.deleteHistoryList(historyIdList);
    }

}
