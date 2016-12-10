package com.irelandlight.controller;

import com.irelandlight.service.HomePageService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by Zichu on 2016/12/9.
 */
@Controller
public class HomePageController {

    @Resource
    private HomePageService homePageService;

    public void testHomePage(){

    }
}
