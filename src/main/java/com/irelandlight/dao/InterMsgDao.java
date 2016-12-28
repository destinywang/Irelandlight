package com.irelandlight.dao;

import com.irelandlight.vo.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2016/12/5.
 */
@Repository
public interface InterMsgDao {

    /* 前台逻辑 */
    public List<MessageCustom> getMsgHistory(Long consumer_id)throws Exception;

    public OrderCustom getNewDeliver(Long consumer_id)throws Exception;

    public String getLastestNews()throws Exception;

    public int insertMsg(MessageCustom messageCustom)throws Exception;

    public String getOneMsg(Long consumer_id)throws Exception;

    public String getProductorName(Long productor_id)throws Exception;

    public String getUserHeadUrl(Long consumer_id) throws Exception;

    /* 后台逻辑 */
    public List<ConsumerCustomRecently> getConsumerList(Long productor_id)throws Exception;

    public String getConsumerContent(Long consumer_id)throws Exception;

    public List<NewsHistory> getNewsRecently()throws Exception;

    public ProductorCustom getProductorInfo(Long productor_id)throws Exception;

    public void sendAllMessage(SendAllMessage sendAllMessage)throws Exception;

    public ConsumerCustomSingle getUserInfo(Long consumer_id)throws Exception;

    public List<PurchaseHistory> getPurchaseHistory(Long consumer_id)throws Exception;

    public List<String> getLastMsgTest(List<Long> IdList)throws Exception;
}
