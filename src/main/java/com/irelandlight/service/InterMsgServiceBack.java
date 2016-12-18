package com.irelandlight.service;

import com.irelandlight.vo.*;

import java.util.List;

/**
 * Created by lenovo on 2016/12/11.
 */
public interface InterMsgServiceBack {

    /* 后台逻辑 */
    /* 获取最近用户列表 */
    public List<ConsumerCustomRecently> getConsumerList(Long productor_id)throws Exception;

    /* 为最近用户列表添加最新的一条聊天内容 */
    public String getConsumerContent(Long consumer_id)throws Exception;

    /* 后台总页面 */
    public MessageBackHome MessageBackHome(Long productor_id)throws Exception;

    /* 获取历史公告 - 按时间降序 */
    public List<NewsHistory> getNewsRecently()throws Exception;

    /* 获取管理员信息 */
    public ProductorCustom getProductorInfo(Long productor_id)throws Exception;

    /* 群发消息 */
    public void sendAllMessage(SendAllMessage sendAllMessage)throws Exception;

    /* 单人页面 */
    /* 获取用户信息 */
    public ConsumerCustomSingle getUserInfo(Long consumer_id)throws Exception;

    /* 获取聊天记录 */
    public List<MessageCustom> getMsgHistory(Long consumer_id)throws Exception;

    /* 获取购买记录 */
    public List<PurchaseHistory> getPurchaseHistory(Long consumer_id)throws Exception;

    /* 后台客服单人页面 */
    public MessageSingleBack MessageSingleBack(SinglePageParam singlePageParam)throws Exception;

    /* 发送一条新消息 */
    public void insertMsg(MessageCustom messageCustom)throws Exception;

}
