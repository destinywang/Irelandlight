package com.irelandlight.dao;

import com.irelandlight.BaseJunitTest;
import com.irelandlight.model.History;
import com.irelandlight.service.MyCollectionService;
import com.irelandlight.vo.GoodDisplay;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Matt
 * Date: 2016/12/18
 * Time: 11:32
 * Description: MyHistory Dao层测试
 */
public class MyHistoryDaoTest extends BaseJunitTest {

    @Resource
    private MyHistoryDao myHistoryDaoImpl;

    @Test
    public void insertMyHistoryTest() throws Exception {
        History history = new History();
        history.setConsumerId(1003L);
        history.setGoodsId(3L);
        myHistoryDaoImpl.insertMyHistory(history);
    }

    @Test
    public void deleteMyHistoryTest() throws Exception {
        myHistoryDaoImpl.deleteMyHistory(6L);
    }

    @Test
    public void findHistoryTest() throws Exception {
        System.out.println(myHistoryDaoImpl.findHistoryTest(1001L));
    }

    @Test
    public void findExistHistoryTest() throws Exception {
        History history = new History();
        history.setConsumerId(1001L);
        history.setGoodsId(1l);
        System.out.println(myHistoryDaoImpl.findExistHistory(history));
    }

    @Test
    public void updateHistoryTimeTest() throws Exception {
        System.out.println(myHistoryDaoImpl.updateHistoryTime(2L));
    }

    @Test
    public void testOthers()throws Exception{
        /*List<Long> historyId =new ArrayList<Long>();
        historyId.add(1l);
        historyId.add(2l);
        myHistoryDaoImpl.deleteHistoryList(historyId);*/

        /*List <GoodDisplay> goodDisplayList=myHistoryDaoImpl.findMyHistory(1001l);
        System.out.println(goodDisplayList);*/

        System.out.println(myHistoryDaoImpl.findMyHistoryByHistoryId(1l));

    }




}
