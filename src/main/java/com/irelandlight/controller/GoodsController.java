package com.irelandlight.controller;

import com.irelandlight.model.vo.SomeGoods;
import com.irelandlight.service.GoodsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Joyoung on 2016/12/10.
 */
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;
    @RequestMapping("/send")
    public String selGoods(@Param("SomeGoods")SomeGoods somegoods, HttpServletRequest request, HttpServletResponse response)throws Exception{
        List<SomeGoods> list=goodsService.selectGoods();
        request.setAttribute("list",list);
        return "send";
    }
    @RequestMapping("/change")
    public void updateWeight(Long id,HttpServletRequest request,HttpServletResponse response)throws Exception{
        goodsService.updateGoodsWeight(id);
        request.getRequestDispatcher("/goods/send.action").forward(request,response);
    }
}
