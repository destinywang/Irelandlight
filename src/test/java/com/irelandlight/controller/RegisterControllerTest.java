package com.irelandlight.controller;

import com.irelandlight.model.Consumer;
import com.irelandlight.service.RegisterService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.spi.RegisterableService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * User: Matt
 * Date: 2016/12/10
 * Time: 16:15
 * Description: description
 */
public class RegisterControllerTest {

    @Resource
    private RegisterController registerControllerImpl;

    public static Consumer build() throws ParseException {
        Consumer consumer=new Consumer();
        consumer.setUsername("ttt");
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

    @Test
    public void testRes()throws Exception {
        //registerControllerImpl.RegisterNewConsumer(  );
    }


    /* @ResponseBody


    public void testGet(@RequestBody Consumer consumer)throws Exception{
        //registerService.RegisterConsumer(consumer);
        System.out.println("test:"+consumer);
        registerService.RegisterConsumer(consumer);
    }


    public void testRegisterNewConsumer() throws Exception {
        *//*Consumer consumer=;*//*
        *//*RegisterControllerTest.testGet( RegisterControllerTest.build() );*//*

    }*/

}
