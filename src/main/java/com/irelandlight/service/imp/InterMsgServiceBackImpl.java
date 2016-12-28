package com.irelandlight.service.imp;

import com.irelandlight.dao.InterMsgDaoBack;
import com.irelandlight.manager.InterMsgManagerBack;
import com.irelandlight.service.InterMsgServiceBack;
import com.irelandlight.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/12/11.
 */
@Service("InterMsgServiceBack")
public class InterMsgServiceBackImpl implements InterMsgServiceBack {

    @Resource
    private InterMsgDaoBack interMsgDaoBack;

    @Resource
    private InterMsgManagerBack interMsgManagerBack;

    /* X */
    @Transactional(rollbackFor = Exception.class)
    public List<ConsumerCustomRecently> getConsumerList(Long productor_id)throws Exception {
        List<ConsumerCustomRecently> consumerCustomRecentlyList =
                interMsgDaoBack.getConsumerList(productor_id);
        for(ConsumerCustomRecently consumer: consumerCustomRecentlyList){
            Long id = consumer.getId();
//            consumer.setContent(interMsgDaoBack.getConsumerContent(id));
        }
        return consumerCustomRecentlyList;
    }

    public List<ConsumerCustomRecently> getConsumerIdList(Long productor_id) throws Exception {
        List<ConsumerCustomRecently> consumerCustomRecentlyList = new ArrayList<ConsumerCustomRecently>();
        List<CsmMsgFromContentType> csmMsgList = interMsgDaoBack.getConsumerFromToList(productor_id);
        List<Long> consumerIdList = new ArrayList<Long>();
        for (CsmMsgFromContentType csmMsg: csmMsgList){
            consumerIdList.add(Long.parseLong(csmMsg.getFromTo().substring(1)));
        }
        List<ConsumerBackHome> consumerBackHomeList = new ArrayList<ConsumerBackHome>();
        for (int i=0;i<consumerIdList.size();i++){
            ConsumerBackHome consumerBackHome = interMsgDaoBack.getConsumerBackHomeList(consumerIdList.get(i));
            consumerBackHomeList.add(consumerBackHome);
        }
        for (int i=0;i<consumerIdList.size();i++){
            ConsumerCustomRecently consmerCustomerRecently = new ConsumerCustomRecently();
            consmerCustomerRecently.setContent(csmMsgList.get(i).getContent());
            consmerCustomerRecently.setType(csmMsgList.get(i).getType());
            consmerCustomerRecently.setId(consumerBackHomeList.get(i).getId());
            consmerCustomerRecently.setHeadImgUrl(consumerBackHomeList.get(i).getHeadImgUrl());
            consmerCustomerRecently.setNickName(consumerBackHomeList.get(i).getNickName());
            consumerCustomRecentlyList.add(consmerCustomerRecently);
        }
        return consumerCustomRecentlyList;
    }

    public ConsumerCustom getConsumerContent(Long consumer_id) throws Exception {
        return interMsgDaoBack.getConsumerContent(consumer_id);
    }

    /* 站内信后台首页 */
    public MessageBackHome MessageBackHome(Long productor_id) throws Exception {
        MessageBackHome messageBackHome = new MessageBackHome();
        /* 客服用户对象列表 */
        List<ConsumerCustomRecently> userList = getConsumerIdList(productor_id);
        messageBackHome.setUserList(userList);
        /* 最新公告列表 */
        List<NewsHistory> sendAllHistory = getNewsRecently();
        messageBackHome.setSendAllHistory(sendAllHistory);
        /* 管理员信息 */
        ProductorCustom administratorinfo = getProductorInfo(productor_id);
        messageBackHome.setAdministratorinfo(administratorinfo);
        return messageBackHome;
    }

    public List<NewsHistory> getNewsRecently() throws Exception {
        return interMsgDaoBack.getNewsRecently();
    }

    public ProductorCustom getProductorInfo(Long productor_id) throws Exception {
        return interMsgDaoBack.getProductorInfo(productor_id);
    }

    public void sendAllMessage(SendAllMessage sendAllMessage) throws Exception {
        /*
        模拟的假数据
        sendAllMessage = new SendAllMessage();
        List<Long> idList = new ArrayList<Long>();
        idList.add(1003L);
        idList.add(1004L);
        idList.add(1005L);
        sendAllMessage.setIdList(idList);
        sendAllMessage.setContent("警告,警告,这不是演习,这不是演习");
        sendAllMessage.setFromId(1L);
        sendAllMessage.setType(3);*/
        interMsgDaoBack.sendAllMessage(sendAllMessage);
    }
    /* 后台单人页面 */
    /* 获取用户信息 */
    public ConsumerCustomSingle getUserInfo(Long consumer_id) throws Exception {
        return interMsgDaoBack.getUserInfo(consumer_id);
    }

    /* 获取用户的购买订单记录 */
    public List<PurchaseHistory> getPurchaseHistory(Long consumer_id) throws Exception {
        return interMsgDaoBack.getPurchaseHistory(consumer_id);
    }

    /**
     * 获取历史消息
     * @param consumer_id
     * @return
     * @throws Exception
     */
    public List<MessageCustom> getMsgHistory(Long consumer_id) throws Exception {
        return interMsgDaoBack.getMsgHistory(consumer_id);
    }

    /**
     * 后台单人客服页
     * @param singlePageParam
     * @return
     * @throws Exception
     */
    public MessageSingleBack MessageSingleBack(SinglePageParam singlePageParam) throws Exception {
        MessageSingleBack messageSingleBack = new MessageSingleBack();
        messageSingleBack.setUserinfo(interMsgManagerBack.getUserInfo(singlePageParam.getConsumer_id()));
        messageSingleBack.setPurchaseHistory(interMsgManagerBack.getPurchaseHistory(singlePageParam.getConsumer_id()));
        messageSingleBack.setAdministatorinfo(interMsgManagerBack.getProductorInfo(singlePageParam.getProductor_id()));
        messageSingleBack.setReceive(interMsgManagerBack.getMsgHistory(singlePageParam.getConsumer_id()));
        return messageSingleBack;
    }

    /**
     * 发送一条消息
     * @param messageCustom
     * @throws Exception
     */
    public void insertMsg(MessageCustom messageCustom) throws Exception {
        interMsgManagerBack.insertMsg(messageCustom);
    }


}
