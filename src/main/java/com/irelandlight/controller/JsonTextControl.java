package com.irelandlight.controller;

import com.irelandlight.model.Consumer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by mac on 2016/11/29.
 */
@Controller
public class JsonTextControl {
    @RequestMapping(value = "/requestJson",method  = RequestMethod.POST)
    public @ResponseBody
    Consumer jsonTest(@RequestBody Consumer itemsCustom){
        itemsCustom.setUserName("Dell 显示器");
        itemsCustom.setNickName("质量到位，做工优美，产品念赞！");
        itemsCustom.setCreateTime(new Date(2014,12,16));
        itemsCustom.setId(new Long(123456));
        itemsCustom.setPassword("123456");
        return itemsCustom;
    }
}
