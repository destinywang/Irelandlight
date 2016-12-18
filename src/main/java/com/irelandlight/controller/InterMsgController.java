package com.irelandlight.controller;

import com.alibaba.fastjson.JSONObject;
import com.irelandlight.service.InterMsgService;
import com.irelandlight.util.ImgeUploadUtil;
import com.irelandlight.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by lenovo on 2016/12/5.
 */
@Controller
@RequestMapping("InterMessage")
public class InterMsgController {

    @Autowired
    private InterMsgService interMsgService;

    @Autowired
    private ImgeUploadUtil imgeUploadUtil;

    /* 前台逻辑 */

    /* 获取全部历史消息 */
    /* 需将consumer_id改为json格式进行绑定 */
    /* return的页面 需要指定到单人聊天页面 */
    /* 每次message插入后,前端都要通过Ajax调用此方法,重新获取历史聊天记录 */
    @RequestMapping("getMsgHistory")
    public String getMsgHistory(Long consumer_id)throws Exception{
        List<MessageCustom> messageList = interMsgService.getMsgHistory(consumer_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageList",messageList);
        return "/messageHistory";
    }

    /**
     * 站内信前台首页
     * 需要
     * @param consumer_id
     * @return
     * @throws Exception
     */
    @RequestMapping("MessageHome")
    public String MessageHome(Long consumer_id)throws Exception{
        MessageHome messageHome = interMsgService.MsgHomePage(consumer_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageHome",messageHome);
        return "page";
    }

    /* 测试的插入页面 */
    @RequestMapping("insertPage")
    public String insertPage(Model model)throws Exception{
        return "insert";
    }

    /* 发送消息 */
    //TODO insert问题
    @RequestMapping("insertMsg")
    public void insertMsg(@RequestBody MessageCustom messageCustom)throws Exception{
        interMsgService.insertMsg(messageCustom);
    }

    @RequestMapping(value = "insertMsgPic",produces = "text/json;charset=UTF-8")
    public void insertMsgPic(@RequestBody MessagePicAjax messagePicAjax)throws Exception{
        File file = new File("E:\\3.jpg"); //测试数据
        InputStream inputStream = new FileInputStream(file); //测试数据
        String path = "http://oi4dxpbc4.bkt.clouddn.com/";
        MultipartFile picFile = messagePicAjax.getMultipartFile();
//        String originName = picFile.getOriginalFilename();
        String fullName = UUID.randomUUID() +/*originName.substring(originName.lastIndexOf("."))*/".jpg"; //生成文件名
        imgeUploadUtil.upLoad(inputStream,fullName);
        MessageCustom messageCustom = new MessageCustom();
        messageCustom.setContent(path+fullName);
        messageCustom.setFromId(messagePicAjax.getFromId());
        messageCustom.setToId(messagePicAjax.getToId());
        messageCustom.setType(4);
        insertMsg(messageCustom);
    }

    /**
     * 站内信前台客服页面
     * @param singlePageParam
     * @return
     * @throws Exception
     */
    @RequestMapping("CustomeServicePage")
    public String MessageFrontSinglePage(@RequestBody SinglePageParam singlePageParam)throws Exception{
        MessageFrontSingle messageFrontSingle = interMsgService.MessageFrontSinglePage(singlePageParam);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageFrontSingle",messageFrontSingle);
        return "/CustomeServicePage";
    }

    /* 后台逻辑 */
    /**
     * 站内信后台首页
     * @param model
     * @param productor_id
     * @return
     * @throws Exception
     */
    @RequestMapping("MessageBackHome")
    public String MessageBackHome(Model model,@RequestBody Long productor_id)throws Exception{
        MessageBackHome messageBackHome = interMsgService.MessageBackHome(productor_id);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageBackHome",messageBackHome);
        return "/backHome";
    }

    /* 群发消息 */
    @RequestMapping("sendAllMessage")
    public String sendAllMessage()throws Exception{
        interMsgService.sendAllMessage(null);
        return "/sendAll";
    }

    public String MessageSingleBack(@RequestBody SinglePageParam singlePageParam)throws Exception{
        MessageSingleBack messageSingleBack = interMsgService.MessageSingleBack(singlePageParam);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("messageSingleBack",messageSingleBack);
        return "/messageBackSingle";
    }


    @ExceptionHandler(NullPointerException.class)
    public String exception() {
        return null;
    }
}
