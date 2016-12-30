package com.irelandlight.controller;

import com.irelandlight.model.HomePageImage;
import com.irelandlight.model.vo.GoodsVO;
import com.irelandlight.model.vo.NewsVO;
import com.irelandlight.service.HomePageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Zichu on 2016/12/19.
 */
@Controller
public class HomePageController{
    @Resource
    private HomePageService homePageService;

    @RequestMapping("/homePage")
    public String homePage(Model model){
        List<GoodsVO> hotGoods=homePageService.queryHotGoods();
        List<HomePageImage> homePageImages =homePageService.queryHomePageImage();
        List<NewsVO> newsVOs=homePageService.queryNews();
        model.addAttribute("homePageImage",homePageImages);
        model.addAttribute("news",newsVOs);
        model.addAttribute("hotGoods",hotGoods);
        return "homePage";
    }
}
