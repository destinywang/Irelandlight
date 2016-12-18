package com.irelandlight.util;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.vo.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 将对象转换成json字符串
 * 以获得测试的json字符串
 * Created by lenovo on 2016/12/12.
 */
public class JsonStringTansfer {

    private static JSONObject jsonObject = new JSONObject();


    public static void main(String[] args) throws Exception {
//        getSendAllMessage();
//        getSinglePageParam();
        getMessageCustom();
//        getMessagePicAjax();
//        getInputStream();
    }

    public static void getSendAllMessage(){
        SendAllMessage sendAllMessage = new SendAllMessage();
        sendAllMessage.setFromId(1L);
        sendAllMessage.setContent("postman群发测试");
        sendAllMessage.setType(3);
        List<Long> idList = new ArrayList<Long>();
        idList.add(1001L);
        idList.add(1003L);
        idList.add(1007L);
        sendAllMessage.setIdList(idList);
        System.out.println(jsonObject.toJSONString(sendAllMessage));
    }

    public static void getSinglePageParam(){
        SinglePageParam singlePageParam = new SinglePageParam();
        singlePageParam.setConsumer_id(1001L);
        singlePageParam.setProductor_id(1L);
        System.out.println(jsonObject.toJSONString(singlePageParam));
    }

    public static void getMessageCustom(){
        MessageCustom messageCustom = new MessageCustom();
        messageCustom.setType(2);
        messageCustom.setToId(1L);
        messageCustom.setFromId(1001L);
        messageCustom.setContent("后台发送消息测试");
        System.out.println(jsonObject.toJSONString(messageCustom));
    }

    public static void getMessagePicAjax(){
        MessagePicAjax messagePicAjax = new MessagePicAjax();
        messagePicAjax.setToId(1L);
        messagePicAjax.setFromId(1001L);
        messagePicAjax.setMultipartFile(null);
        System.out.println(jsonObject.toJSONString(messagePicAjax));
    }

    public static void getInputStream()throws Exception{
        File file = new File("E:\\1.png");
        InputStream inputStream = new FileInputStream(file);
    }


}
