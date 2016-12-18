package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.service.InterMsgServiceBack;
import com.irelandlight.util.ImgeUploadUtil;
import com.irelandlight.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2016/12/11.
 */
@Controller
@RequestMapping("Back")
public class InterMsgControllerBack {

    @Resource
    private InterMsgServiceBack interMsgServiceBack;
    private ImgeUploadUtil imgeUploadUtil = new ImgeUploadUtil();

    /* 后台逻辑 */
    /**
     * 站内信后台首页
     * @param
     * @param productor_id
     * @return
     * @throws Exception
     * 测试完毕
     * 可以收到json串,但是sql还是有一些问题
     */
    @RequestMapping(value = "MessageBackHome",produces = "text/json;charset=UTF-8",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public String MessageBackHome( @RequestBody Long productor_id)throws Exception{
        MessageBackHome messageBackHome = interMsgServiceBack.MessageBackHome(productor_id);
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString(messageBackHome);
    }

    /**
     * 群发消息
     * @param sendAllMessage
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping("sendAllMessage")
    public void sendAllMessage(@RequestBody SendAllMessage sendAllMessage)throws Exception{
        interMsgServiceBack.sendAllMessage(sendAllMessage);
    }

    /**
     * 站内信后台客服单人页面
     * @param singlePageParam
     * @return
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping(value = "MessageSingleBack",produces = "text/json;charset=UTF-8")
    @ResponseBody
    public String MessageSingleBack(@RequestBody SinglePageParam singlePageParam)throws Exception{
        MessageSingleBack messageSingleBack = interMsgServiceBack.MessageSingleBack(singlePageParam);
        JSONObject jsonObject = new JSONObject();
        return jsonObject.toJSONString(messageSingleBack);
    }

    /**
     * 后台客服界面 发送消息
     * @param messageCustom
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping("insertMsg")
    @ResponseBody
    public void insertMsg(@RequestBody MessageCustom messageCustom) throws Exception{
        interMsgServiceBack.insertMsg(messageCustom);
    }

    @RequestMapping("insertMsgPic")
    public void insertMsgPic(@RequestBody MessagePicAjax messagePicAjax)throws Exception{
        String path = "http://ohlu5erjk.bkt.clouddn.com/";
        MultipartFile picFile = messagePicAjax.getMultipartFile();
        String originName = picFile.getOriginalFilename();
        String fullName = path + UUID.randomUUID() + originName.substring(originName.lastIndexOf(".")); //生成文件名
        imgeUploadUtil.upLoad(picFile.getInputStream(),fullName);
        MessageCustom messageCustom = new MessageCustom();
        messageCustom.setContent(fullName);
        messageCustom.setFromId(messageCustom.getFromId());
        messageCustom.setToId(messagePicAjax.getToId());
        messageCustom.setType(4);
        insertMsg(messageCustom);
    }


    /**
     * 每次发送完消息,都需要再获取一遍消息
     * @param consumer_id
     * @return
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping("getMsgHistory")
    @ResponseBody
    public String getMsgHistory(@RequestBody Long consumer_id) throws Exception{
        JSONObject jsonObject = new JSONObject();
        List<MessageCustom> messageCustomList = interMsgServiceBack.getMsgHistory(consumer_id);
        return jsonObject.toJSONString(messageCustomList);
    }

}
