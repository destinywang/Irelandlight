package com.irelandlight.controller;

import com.irelandlight.model.Consumer;
import com.irelandlight.service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * User: Matt
 * Date: 2016/12/10
 * Time: 16:02
 * Description: 提供用户注册功能
 */
@Controller
public class RegisterController {

    @Resource
    private RegisterService registerServiceImpl;

    @RequestMapping("/register")
    public String RegisterNewConsumer(@RequestBody Consumer consumer)throws Exception{
        int row = registerServiceImpl.RegisterConsumer(consumer);
        if (row==0)
            return "ERROR";
        return "hello";
    }


}
