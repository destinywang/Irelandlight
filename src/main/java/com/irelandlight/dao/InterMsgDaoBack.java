package com.irelandlight.dao;

import com.irelandlight.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2016/12/12.
 */
@Repository
public interface InterMsgDaoBack {

    /* 后台逻辑 */
    public List<ConsumerCustomRecently> getConsumerList(Long productor_id)throws Exception;

    public ConsumerCustom  getConsumerContent(Long consumer_id)throws Exception;

    public List<NewsHistory> getNewsRecently()throws Exception;

    public ProductorCustom getProductorInfo(Long productor_id)throws Exception;

    public void sendAllMessage(SendAllMessage sendAllMessage)throws Exception;

    public ConsumerCustomSingle getUserInfo(Long consumer_id)throws Exception;

    public List<PurchaseHistory> getPurchaseHistory(Long consumer_id)throws Exception;

    public List<String> getLastMsgTest(List<Long> IdList)throws Exception;

    public int insertMsg(MessageCustom messageCustom)throws Exception;

    public List<MessageCustom> getMsgHistory(Long consumer_id)throws Exception;

    public List<CsmMsgFromContentType> getConsumerFromToList(Long productor_id)throws Exception;

    public ConsumerBackHome getConsumerBackHomeList(Long consumer_id)throws Exception;

}
