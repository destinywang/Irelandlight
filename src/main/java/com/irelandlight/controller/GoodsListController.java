package com.irelandlight.controller;

import com.alibaba.fastjson.JSON;
import com.irelandlight.service.GoodsListService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.HttpRequestHandlerServlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/19.
 */
@Controller
public class GoodsListController {
    @Resource
    private GoodsListService goodsListService;
    /*
    @RequestMapping
    public String queryAllGoods(Model model){
        Map<String,Object> cakeList=goodsListService.queryAllGoods();
        model.addAttribute("cakeList",cakeList);
        return "";
    }

    @RequestMapping
    public String queryBySearchGoods(HttpServletRequest request, Model model){
        String searchBox=request.getParameter("searchBox");
        Map<String,Object> cakeList=goodsListService.queryBySearchGoods(searchBox);
        model.addAttribute("cakeList",cakeList);
        return "";
    }
    */
    public String queryBySearchGoods2(String json){
        Map<String,Object>search=JSON.parseObject(json,HashMap.class);
        System.out.println(search.toString());
        return "";
    }

    /*
    @RequestMapping
    public String queryFilterGoods(String json,
                                   Model model){
        Map<String,Object>fil=JSON.parseObject(json, HashMap.class);
        System.out.println(fil.toString());
        return "";
    }
    */
}
