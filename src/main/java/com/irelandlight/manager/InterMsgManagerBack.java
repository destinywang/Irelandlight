package com.irelandlight.manager;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.irelandlight.dao.InterMsgDaoBack;
import com.irelandlight.model.Message;
import com.irelandlight.vo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2016/12/20.
 */
@Component
public class InterMsgManagerBack {

    @Resource
    private InterMsgDaoBack interMsgDaoBack;

    private static final Logger LOGGER = LoggerFactory.getLogger(InterMsgManagerBack.class);

    public ConsumerCustomSingle getUserInfo(Long consumer_id) throws Exception {
        if(consumer_id != null){
            ConsumerCustomSingle consumerCustomSingle = interMsgDaoBack.getUserInfo(consumer_id);
            if(consumerCustomSingle == null){
                throw new Exception("获取用户信息异常");
            }
            return consumerCustomSingle;
        }else {
            throw new Exception("获取用户信息参数异常");
        }
    }

    public List<PurchaseHistory> getPurchaseHistory(Long consumer_id) throws Exception {
        if(consumer_id != null){
            List<PurchaseHistory> purchaseHistoryList = interMsgDaoBack.getPurchaseHistory(consumer_id);
            return purchaseHistoryList;
        }else{
            throw new Exception("获取购买信息参数异常");
        }
    }

    public ProductorCustom getProductorInfo(Long productor_id) throws Exception {
        if(productor_id != null){
            ProductorCustom productorCustom = interMsgDaoBack.getProductorInfo(productor_id);
            if(productorCustom == null){
                throw new Exception("获取管理员信息异常");
            }
            return productorCustom;
        }
        throw new Exception("获取管理员信息参数异常");
    }

    public List<MessageCustom> getMsgHistory(Long consumer_id) throws Exception {
        if(consumer_id != null){
            List<MessageCustom> messageCustomList = interMsgDaoBack.getMsgHistory(consumer_id);
            if(messageCustomList == null){
                throw new Exception("获取历史消息异常");
            }
            return messageCustomList;
        }
        throw new Exception("获取历史消息参数异常");
    }

    public void insertMsg(MessageCustom messageCustom)throws Exception{
        if(messageCustom != null){
            int flag = interMsgDaoBack.insertMsg(messageCustom);
            if(flag == 0){
                throw new Exception("插入信息异常");
            }
        }else{
            throw new Exception("插入信息参数异常");
        }
    }

}
