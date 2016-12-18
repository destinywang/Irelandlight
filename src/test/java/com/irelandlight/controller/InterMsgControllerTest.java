package com.irelandlight.controller;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.vo.MessageSingleBack;
import com.irelandlight.vo.SinglePageParam;
import com.irelandlight.service.InterMsgService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lenovo on 2016/12/10.
 */
public class InterMsgControllerTest extends BaseJunitTest {

    @Autowired
    private InterMsgService interMsgService;

    @Test
    public void testMessageSingleBack()throws Exception{
        SinglePageParam singlePageParam = new SinglePageParam();
        singlePageParam.setProductor_id(1L);
        singlePageParam.setConsumer_id(1002L);
        MessageSingleBack messageSingleBack = interMsgService.MessageSingleBack(singlePageParam);
        System.out.println(messageSingleBack);
    }

}