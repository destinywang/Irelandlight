package com.irelandlight.service.imp;

import com.irelandlight.dao.InterMsgDaoFront;
import com.irelandlight.exception.InsertException;
import com.irelandlight.manager.InterMsgManagerFront;
import com.irelandlight.service.InterMsgServiceFront;
import com.irelandlight.vo.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/12/11.
 */

@Service("InterMsgServiceFront")
public class InterMsgServiceFrontImpl implements InterMsgServiceFront {

    @Resource
    private InterMsgDaoFront interMsgDaoFront;

    @Resource
    private InterMsgManagerFront interMsgManagerFront;

    /**
     * 获取历史消息列表
     * @param consumer_id
     * @return
     * @throws Exception
     */
    public List<MessageCustom> getMsgHistory(Long consumer_id) throws Exception {
        return interMsgDaoFront.getMsgHistory(consumer_id);
    }

    public OrderCustom  getNewDeliver(Long consumer_id) throws Exception {
        return interMsgDaoFront.getNewDeliver(consumer_id);
    }

    public String getLastestNews() throws Exception {
        return interMsgDaoFront.getLastestNews();
    }

    /**
     * 发送消息功能
     * 前台的客服页面,后台的客服页面
     * 都要用到这个功能
     * @param messageCustom
     * @throws Exception
     */
    public void insertMsg(MessageCustom messageCustom)throws Exception{
        interMsgManagerFront.insertMsg(messageCustom);
    }

    public String getOneMsg(Long consumer_id) throws Exception {
        return interMsgDaoFront.getOneMsg(consumer_id);
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
        String message = interMsgManagerFront.getOneMsg(consumer_id);
        OrderCustom order = interMsgManagerFront.getNewDeliver(consumer_id);
        String news = interMsgManagerFront.getLastestNews();
        messageHome.setMessage(message);
        messageHome.setNews(news);
        messageHome.setOrder(order);
        return messageHome;
    }

    public String getProductorName(Long productor_id) throws Exception {
        return interMsgDaoFront.getProductorName(productor_id);
    }

    public String getUserHeadUrl(Long consumer_id) throws Exception {
        return interMsgDaoFront.getUserHeadUrl(consumer_id);
    }

    /**
     * 站内信前台单人客服页
     * @return
     * @throws Exception
     */
    public MessageFrontSingle MessageFrontSinglePage(Long consumer_id,Long productor_id)throws Exception{

        String productorName = interMsgManagerFront.getProductorName(productor_id);
        String consumerName = interMsgManagerFront.getUserHeadUrl(consumer_id);
        List<MessageCustom> list = interMsgManagerFront.getMsgHistory(consumer_id);

        MessageFrontSingle messageFrontSingle = new MessageFrontSingle();
        messageFrontSingle.setMessageList(list);
        messageFrontSingle.setConsumerHeadUrl(consumerName);
        messageFrontSingle.setProductorName(productorName);
        return messageFrontSingle;
    }

}
