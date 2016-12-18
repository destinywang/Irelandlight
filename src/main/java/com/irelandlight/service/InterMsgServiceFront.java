package com.irelandlight.service;

import com.irelandlight.dao.InterMsgDao;
import com.irelandlight.vo.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by lenovo on 2016/12/11.
 */
public interface InterMsgServiceFront {

    /* 获取聊天记录 */
    public List<MessageCustom> getMsgHistory(Long consumer_id)throws Exception;

    /* 获取最新订单状态 */
    public OrderCustom getNewDeliver(Long consumer_id)throws Exception;

    /* 获取最新公告 */
    public String getLastestNews()throws Exception;

    /* 发送新消息 */
    public void insertMsg(MessageCustom messageCustom)throws Exception;

    /* 获取最新的一条聊天记录 */
    public String getOneMsg(Long consumer_id)throws Exception;

    /* 站内信前台首页 */
    public MessageHome MsgHomePage(Long consumer_id)throws Exception;

    /* 获取管理员姓名 */
    public String getProductorName(Long productor_id)throws Exception;

    /* 获取用户头像地址 */
    public String getUserHeadUrl(Long consumer_id) throws Exception;

    /* 站内信前台客服单人页 */
    public MessageFrontSingle MessageFrontSinglePage(Long consumer_id,Long productor_id)throws Exception;

}
