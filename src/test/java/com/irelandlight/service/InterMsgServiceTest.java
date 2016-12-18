package com.irelandlight.service;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.vo.MessageFrontSingle;
import com.irelandlight.vo.SinglePageParam;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 2016/12/10.
 */
public class InterMsgServiceTest extends BaseJunitTest {

    @Autowired
    private InterMsgService interMsgService;

    @Test
    public void testMessageFrontSinglePage()throws Exception{
        SinglePageParam singlePageParam = new SinglePageParam();
        singlePageParam.setConsumer_id(1002L);
        singlePageParam.setProductor_id(1L);
        MessageFrontSingle messageFrontSingle = interMsgService.MessageFrontSinglePage(singlePageParam);
        System.out.println(messageFrontSingle.getProductorName());
        System.out.println(messageFrontSingle.getConsumerHeadUrl());
        System.out.println(messageFrontSingle.getMessageList().size());
    }

}
