package com.irelandlight.controller;

import com.alibaba.fastjson.JSON;
import com.irelandlight.model.vo.FilterGoodsVO;
import com.irelandlight.model.vo.GoodsVO;
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
import java.util.List;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/19.
 */
@Controller
public class GoodsListController {
    @Resource
    private GoodsListService goodsListService;

    /**
     * 查询全部商品列表
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryGoods" ,produces = "text/json;charset=utf-8")
    public String queryAllGoods(Model model){
        List<GoodsVO> cakeList=goodsListService.queryAllGoods();
        model.addAttribute("cakeList",cakeList);
        return "goodsList";
    }

    /**
     * 根据搜索框查询商品列表
     * @param searchBox
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryGoodsBySearchBox",produces = "text/json;charset=utf-8")
    public String queryBySearchGoods(@RequestBody String searchBox, Model model){
        Map<String,Object> cakeList=goodsListService.queryBySearchGoods(searchBox);
        model.addAttribute("cakeList",cakeList);
       return "goodsList";
    }



    /**
     * 根据筛选框进行搜索全部商品
     * @param fileter
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryGooodsByFilter",produces = "text/json;charset=utf-8")
    public String queryFilterGoods(@RequestBody FilterGoodsVO fileter,Model model){
        Map<String,Object> cakeList=goodsListService.queryFilterGoods(fileter);
        model.addAttribute("cakeList",cakeList);
        return "goodsList";
    }


}
