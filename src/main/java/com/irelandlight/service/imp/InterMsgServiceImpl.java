package com.irelandlight.service.imp;

import com.irelandlight.dao.InterMsgDao;
import com.irelandlight.vo.*;
import com.irelandlight.service.InterMsgService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/12/5.
 */
@Service("InterMsgService")
public class InterMsgServiceImpl implements InterMsgService {

    @Resource
    private InterMsgDao interMsgDao;

    /**
     * 获取历史消息列表
     * @param consumer_id
     * @return
     * @throws Exception
     */
    public List<MessageCustom> getMsgHistory(Long consumer_id) throws Exception {
        return interMsgDao.getMsgHistory(consumer_id);
    }

    public OrderCustom getNewDeliver(Long consumer_id) throws Exception {
        return interMsgDao.getNewDeliver(consumer_id);
    }

    public String getLastestNews() throws Exception {
        return interMsgDao.getLastestNews();
    }

    /**
     * 发送消息功能
     * 前台的客服页面,后台的客服页面
     * 都要用到这个功能
     * @param messageCustom
     * @throws Exception
     */
    public void insertMsg(MessageCustom messageCustom)throws Exception{
        //TODO  为什么dao层的insert中resultType无法添加,insert影响的行数如何返回
        System.out.println("aaaaaaaaaa");
        System.out.println("aaaaaaaaaa");
        System.out.println("aaaaaaaaaa");
        System.out.println(interMsgDao.insertMsg(messageCustom));
    }

    public String getOneMsg(Long consumer_id) throws Exception {
        return interMsgDao.getOneMsg(consumer_id);
    }

    /**
     * 站内信前台首页
     * message - 最后一条聊天记录
     * status - 最新订单的状态
     * news - 最新的公告
     * 调用时刻:跳转到新的页面
     * 返回值处理:用json的注解修饰返回值和形参
     * @param consumer_id
     * @return
     * @throws Exception
     */
    public MessageHome MsgHomePage(Long consumer_id) throws Exception {

        MessageHome messageHome = new MessageHome();
        String message = interMsgDao.getOneMsg(consumer_id);
        OrderCustom order = interMsgDao.getNewDeliver(consumer_id);
        String news = interMsgDao.getLastestNews();
        messageHome.setMessage(message);
        messageHome.setNews(news);
        messageHome.setOrder(order);
        return messageHome;
    }

    public String getProductorName(Long productor_id) throws Exception {
        return interMsgDao.getProductorName(productor_id);
    }

    public String getUserHeadUrl(Long consumer_id) throws Exception {
        return interMsgDao.getUserHeadUrl(consumer_id);
    }

    /**
     * 站内信前台单人客服页
     * @return
     * @throws Exception
     */
    public MessageFrontSingle MessageFrontSinglePage(SinglePageParam singlePageParam)throws Exception{

        String productorName = getProductorName(singlePageParam.getProductor_id());
        String consumerName = getUserHeadUrl(singlePageParam.getConsumer_id());
        List<MessageCustom> list = getMsgHistory(singlePageParam.getConsumer_id());

        MessageFrontSingle messageFrontSingle = new MessageFrontSingle();
        messageFrontSingle.setMessageList(list);
        messageFrontSingle.setConsumerHeadUrl(consumerName);
        messageFrontSingle.setProductorName(productorName);
        return messageFrontSingle;
    }

    public List<ConsumerCustomRecently> getConsumerList(Long productor_id)throws Exception {
        List<ConsumerCustomRecently> consumerCustomRecentlyList =
                interMsgDao.getConsumerList(productor_id);
        for(ConsumerCustomRecently consumer: consumerCustomRecentlyList){
            Long id = consumer.getId();
            consumer.setContent(interMsgDao.getConsumerContent(id));
        }
        return consumerCustomRecentlyList;
    }

    public String getConsumerContent(Long consumer_id) throws Exception {
        return interMsgDao.getConsumerContent(consumer_id);
    }

    /* 站内信后台首页 */
    public MessageBackHome MessageBackHome(Long productor_id) throws Exception {
        MessageBackHome messageBackHome = new MessageBackHome();
        /* 客服用户对象列表 */
        List<ConsumerCustomRecently> userList = getConsumerList(productor_id);
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
        return interMsgDao.getNewsRecently();
    }

    public ProductorCustom getProductorInfo(Long productor_id) throws Exception {
        return interMsgDao.getProductorInfo(productor_id);
    }

    public void sendAllMessage(SendAllMessage sendAllMessage) throws Exception {
        sendAllMessage = new SendAllMessage();
        List<Long> idList = new ArrayList<Long>();
        idList.add(1003L);
        idList.add(1004L);
        idList.add(1005L);
        sendAllMessage.setIdList(idList);
        sendAllMessage.setContent("警告,警告,这不是演习,这不是演习");
        sendAllMessage.setFromId(1L);
        sendAllMessage.setType(3);
        interMsgDao.sendAllMessage(sendAllMessage);
    }
    /* 后台单人页面 */
    /* 获取用户信息 */
    public ConsumerCustomSingle getUserInfo(Long consumer_id) throws Exception {
        return interMsgDao.getUserInfo(consumer_id);
    }

    /* 获取用户的购买订单记录 */
    public List<PurchaseHistory> getPurchaseHistory(Long consumer_id) throws Exception {
        return interMsgDao.getPurchaseHistory(consumer_id);
    }

    /**
     * 后台单人客服页
     * @param singlePageParam
     * @return
     * @throws Exception
     */
    public MessageSingleBack MessageSingleBack(SinglePageParam singlePageParam) throws Exception {
        MessageSingleBack messageSingleBack = new MessageSingleBack();
        messageSingleBack.setUserinfo(getUserInfo(singlePageParam.getConsumer_id()));
        messageSingleBack.setPurchaseHistory(getPurchaseHistory(singlePageParam.getConsumer_id()));
        messageSingleBack.setAdministatorinfo(getProductorInfo(singlePageParam.getProductor_id()));
        messageSingleBack.setReceive(getMsgHistory(singlePageParam.getConsumer_id()));
        return messageSingleBack;
    }


}
