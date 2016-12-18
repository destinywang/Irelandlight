package com.irelandlight.dao;

import com.irelandlight.vo.MessageCustom;
import com.irelandlight.vo.OrderCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lenovo on 2016/12/12.
 */
@Repository
public interface InterMsgDaoFront {

    /* 前台逻辑 */
    public List<MessageCustom> getMsgHistory(Long consumer_id)throws Exception;

    public OrderCustom getNewDeliver(Long consumer_id)throws Exception;

    public String getLastestNews()throws Exception;

    public int insertMsg(MessageCustom messageCustom)throws Exception;

    public String getOneMsg(Long consumer_id)throws Exception;

    public String getProductorName(Long productor_id)throws Exception;

    public String getUserHeadUrl(Long consumer_id) throws Exception;

}
