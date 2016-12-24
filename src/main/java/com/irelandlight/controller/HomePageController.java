package com.irelandlight.controller;

import com.irelandlight.service.HomePageService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Zichu on 2016/12/19.
 */
//@RequestMapping()
//@ResponseBody
public class HomePageController{
    @Resource
    private HomePageService homePageService;
    public String homePage(Model model){
        Map<String,Object> homePageImage=homePageService.queryHomePageImage();
        Map<String,Object> homePageNews=homePageService.queryNews();
        Map<String,Object> homePageGoods=homePageService.queryHotGoods();
        model.addAttribute("homePageImage",homePageImage);
        model.addAttribute("homePageNews",homePageNews);
        model.addAttribute("homePageGoods",homePageGoods);
        return "";
    }
}
