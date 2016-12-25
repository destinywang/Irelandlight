package com.irelandlight.service;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.BaseJunitTest;
import com.irelandlight.dao.RegisterDao;
import com.irelandlight.model.Consumer;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

/**
 * User: Matt
 * Date: 2016/12/10
 * Time: 15:50
 * Description: description
 */

public class RegisterServiceTest extends BaseJunitTest {

    @Resource
    private RegisterService registerServiceImpl;

    @Test
    public void testRegisterService()throws Exception{
        Consumer consumer=new Consumer();
        consumer.setUsername("ttt");
        consumer.setNickname("test");
        /*进行日期转换*/
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date="2009-5-3";
        consumer.setBirthday( dateFormat.parse(date) );

        consumer.setEmail("4452@qq.com");
        consumer.setGender("男");
        consumer.setPassword("456951");
        consumer.setTelephone("110");
        consumer.setHeadImgurl("http://ohnx2nsuw.bkt.clouddn.com/20150303104600_PmTmE.thumb.224_0.jpeg");
        /*生成随机盐值*/
        String u = UUID.randomUUID().toString();
        consumer.setSalt(u.substring(0,6));

        JSONObject jsonObject=new JSONObject();
        String consumerJson=jsonObject.toJSONString( consumer );
        System.out.println(consumerJson);
        //registerServiceImpl.RegisterConsumer(consumer);
    }

    /*----------------------*/

    @ResponseBody
    public Consumer build()throws Exception{
        Consumer consumer=new Consumer();
        consumer.setUsername("t2t");
        consumer.setNickname("test");
        //*进行日期转换*//
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String date="2009-5-3";
        consumer.setBirthday( dateFormat.parse(date) );
        consumer.setEmail("4452@qq.com");
        consumer.setGender("男");
        consumer.setPassword("456951");
        consumer.setTelephone("110");
        consumer.setHeadImgurl("http://ohnx2nsuw.bkt.clouddn.com/20150303104600_PmTmE.thumb.224_0.jpeg");
        //*生成随机盐值*//*
        String u = UUID.randomUUID().toString();
        consumer.setSalt(u.substring(0,6));
        return consumer;
    }

    public void testGet(@RequestBody Consumer consumer)throws Exception{
        System.out.println(consumer);
        registerServiceImpl.RegisterConsumer(consumer);
    }

    @Test
    public void testRegisterConatroller() throws Exception {
        RegisterServiceTest registerServiceTest=new RegisterServiceTest();
        Consumer consumer=registerServiceTest.build();
        //registerServiceTest.testGet( consumer );
    }


}
