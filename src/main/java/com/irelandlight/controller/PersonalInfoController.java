package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.irelandlight.model.Consumer;
import com.irelandlight.service.PersonalInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.ws.rs.GET;

/**
 * Created by Matt on 2016/12/9.
 */

@Controller
@RequestMapping("/PersonalInfo")
public class PersonalInfoController {

    @Resource
    private PersonalInfoService personalInfoServiceImpl;

    private static final ThreadLocal<Long> consumerId=new ThreadLocal<Long>();

    {
        consumerId.set(1001L);
    }

    @RequestMapping(value = "/display", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/json;charset=UTF-8 ")
    @ResponseBody
    public String display() throws Exception {
        Consumer consumer = personalInfoServiceImpl.findPersonalInfo(consumerId.get());
        //字段为我们需要序列化的字段，如果实体类中没有该字段则不解析放弃该字段而不会报错。
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Consumer.class, "username", "nickname", "gender", "birthday", "telephone", "email");
        //创建JSON对象
        JSONObject json = new JSONObject();
        //创建json的String对象
        String Sjson = json.toJSONString(consumer, filter);
        return Sjson;
    }

}
