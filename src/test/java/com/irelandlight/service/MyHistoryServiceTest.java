package com.irelandlight.service;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.model.History;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * User: Matt
 * Date: 2016/12/18
 * Time: 16:31
 * Description: description
 */
public class MyHistoryServiceTest extends BaseJunitTest {

    @Resource
    private MyHistoryService myHistoryServiceImpl;

    @Test
    public void insertMyHistoryTest()throws Exception{
        History history=new History();
        history.setConsumerId(1001l);
        history.setGoodsId(1l);
        myHistoryServiceImpl.insertMyHistory(history);
    }

}
