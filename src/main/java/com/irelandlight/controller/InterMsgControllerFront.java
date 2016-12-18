package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.manager.InterMsgManagerFront;
import com.irelandlight.service.InterMsgServiceFront;
import com.irelandlight.util.ImgeUploadUtil;
import com.irelandlight.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2016/12/11.
 */
@Controller
@RequestMapping("Front")
public class InterMsgControllerFront {

    @Resource
    private InterMsgServiceFront  InterMsgServiceFront;
    private ImgeUploadUtil imgeUploadUtil = new ImgeUploadUtil();

    /* 前台逻辑 */

    /**
     * 获取全部历史消息
     * 每次message插入后,前端都要通过Ajax方式调用此方法,重新获取历史聊天记录
     * @param consumer_id
     * @return
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping(value = "getMsgHistory",produces = "text/json;charset=UTF-8",method = {RequestMethod.POST})
    @ResponseBody
    public String getMsgHistory(@RequestBody Long consumer_id)throws Exception{

        List<MessageCustom> message = InterMsgServiceFront.getMsgHistory(consumer_id);
        JSONObject jsonObject = new JSONObject();
        String messageList = jsonObject.toJSONString(message);
        return messageList;
    }

    /**
     * 站内信前台首页
     * 需要
     * @param consumer_id
     * @return
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping("MessageHome")
    public String MessageHome(Long consumer_id,Model model)throws Exception{
        MessageHome messageHome = InterMsgServiceFront.MsgHomePage(consumer_id);
        model.addAttribute("messageHome",messageHome);
        return "/messageFrontHome";
    }

    /**
     * 发送聊天消息
     * @param messageCustom
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping(value = "insertMsg",produces = "text/json;charset=UTF-8")
    public void insertMsg(@RequestBody MessageCustom messageCustom)throws Exception{
        InterMsgServiceFront.insertMsg(messageCustom);
    }

    /**
     * 发送图片
     * @param messagePicAjax
     * @throws Exception
     * 测试完毕
     */
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
     * 站内信前台客服页面
     * @param
     * @return
     * @throws Exception
     * 测试完毕
     */
    @RequestMapping("CustomeServicePage")
    public String MessageFrontSinglePage(Long consumer_id,Long productor_id,Model model)throws Exception{
        MessageFrontSingle messageFrontSingle = InterMsgServiceFront.MessageFrontSinglePage(consumer_id,productor_id);
        model.addAttribute("MessageFrontSingle",messageFrontSingle);
        return "/CustomeServicePage";
    }

    @ExceptionHandler(Exception.class)
    public String HandleException(Exception ex,Model model){
        model.addAttribute("exceptionMessage",ex.getMessage());
        return "/ExceptionPage";
    }

}
