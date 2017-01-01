package com.irelandlight.controller;

import com.irelandlight.service.RegisterService;
import com.irelandlight.vo.RegisterCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Map;

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
    public String RegisterNewConsumer(@RequestBody RegisterCustomer registerCustomer)throws Exception{
        //对密码以及确认密码的判断
        if (registerCustomer.getPassword()!=registerCustomer.getConfirmPass())
            return "ERROR";

        Map<String, Object> row = registerServiceImpl.RegisterConsumer(registerCustomer);
        Integer insertRow= Integer.valueOf(row.get("status").toString());
        if (insertRow==1  ){
            return "hello";
        }
        return  "ERROR";
    }


}
