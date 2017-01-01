package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.irelandlight.model.Consumer;
import com.irelandlight.service.PersonalInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Matt on 2016/12/9.
 */

@Controller
@RequestMapping("/PersonalInfo")
public class PersonalInfoController {

    @Resource
    private PersonalInfoService personalInfoServiceImpl;

    private static final ThreadLocal<Long> consumerId = new ThreadLocal<Long>();

    {
        consumerId.set(1001L);
    }

    @RequestMapping(value = "/display", method = {RequestMethod.GET, RequestMethod.POST}, produces = "text/json;charset=UTF-8 ")
    public ModelAndView display() {
        consumerId.set(1001L);
        Map<String, Object> personalInfoMap = personalInfoServiceImpl.findPersonalInfo(consumerId.get());
        Integer status = Integer.valueOf(personalInfoMap.get("status").toString());
        ModelAndView modelAndView = new ModelAndView();
        if (status == 0) {
            //字段为我们需要序列化的字段，如果实体类中没有该字段则不解析放弃该字段而不会报错。
            SimplePropertyPreFilter filter = new SimplePropertyPreFilter(Consumer.class, "username", "nickname", "gender", "birthday", "telephone", "email");
            //创建JSON对象
            JSONObject json = new JSONObject();
            //创建json的String对象
            String Sjson = json.toJSONString(personalInfoMap.get("msg"), filter);
            modelAndView.setViewName("前端MM快发viewname");
            modelAndView.addObject("personalInfo", Sjson);
            return modelAndView;
        }
        modelAndView.setViewName("ERROR");
        return modelAndView;
    }

    public ModelAndView changeNickName(@RequestBody String nickname) {
        consumerId.set(1001L);
        Map<String, Object> updateStatus = personalInfoServiceImpl.changeNickName(consumerId.get(), nickname);
        Integer status = Integer.valueOf(updateStatus.get("status").toString());
        //无论成功与否，跳转回display页面
        ModelAndView modelAndView=this.display();
        return modelAndView;
    }

    public ModelAndView changeEmail(@RequestBody String email) {
        consumerId.set(1001L);
        Map<String, Object> updateStatus = personalInfoServiceImpl.changeEmail(consumerId.get(), email);
        Integer status = Integer.valueOf(updateStatus.get("status").toString());
        //无论成功与否，跳转回display页面
        ModelAndView modelAndView=this.display();
        return modelAndView;
    }

}
