package com.irelandlight.manager;

import com.irelandlight.dao.InterMsgDaoFront;
import com.irelandlight.vo.MessageCustom;
import com.irelandlight.vo.OrderCustom;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/12/16.
 */
@Component
public class InterMsgManagerFront {

    @Resource
    private InterMsgDaoFront interMsgDaoFront;

    private static final Logger LOGGER = LoggerFactory.getLogger(InterMsgManagerFront.class);

    public int insertMsg(MessageCustom messageCustom)throws Exception{
        if(messageCustom != null){
            int flag = interMsgDaoFront.insertMsg(messageCustom);
            if(flag == 0){
                throw new Exception("插入信息异常");
            }
            return flag;
        }else {
            throw new Exception("插入信息参数异常");
        }
    }

    public String getOneMsg(Long consumer_id) throws Exception {
        if(consumer_id != null){
            String message = interMsgDaoFront.getOneMsg(consumer_id);
            if(message == null){
                throw new Exception("获取最新聊天记录异常");
            }
            return message;
        }else {
            throw new Exception("获取最新聊天记录参数异常");
        }
    }

    public OrderCustom getNewDeliver(Long consumer_id) throws Exception {
        if(consumer_id != null){
            OrderCustom orderCustom = interMsgDaoFront.getNewDeliver(consumer_id);
            if(orderCustom == null){
                return null;
            }
            return orderCustom;
        }else {
            throw new Exception("获取最新物流信息参数异常");
        }
    }

    public String getLastestNews() throws Exception {
        String news = interMsgDaoFront.getLastestNews();
        if(news != null){
            return news;
        }else {
            throw new Exception("获取最新公告异常");
        }
    }

    public String getProductorName(Long productor_id) throws Exception {
        if(productor_id != null){
            String productorName = interMsgDaoFront.getProductorName(productor_id);
            if(productorName == null){
                throw new Exception("获取管理员名称异常");
            }
            return productorName;
        }else {
            throw new Exception("获取管理员名称参数异常");
        }
    }

    public String getUserHeadUrl(Long consumer_id) throws Exception {
        if(consumer_id != null){
            String headUrl = interMsgDaoFront.getUserHeadUrl(consumer_id);
            if(headUrl == null){
                throw new Exception("获取用户头像异常");
            }
            return headUrl;
        }else {
            throw new Exception("获取用户头像参数异常");
        }
    }

    public List<MessageCustom> getMsgHistory(Long consumer_id) throws Exception {
        if(consumer_id != null){
            List<MessageCustom> messageList = interMsgDaoFront.getMsgHistory(consumer_id);
            if(messageList == null){
                throw new Exception("获取用户聊天记录异常");
            }
            return messageList;
        }else {
            throw new Exception("获取用户聊天记录参数异常");
        }
    }

}
