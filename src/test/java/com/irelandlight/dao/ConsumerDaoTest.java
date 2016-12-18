package com.irelandlight.dao;

import com.irelandlight.BaseJunitTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by destiny on 2016/12/2.
 */
public class ConsumerDaoTest extends BaseJunitTest {

    @Autowired
    private InterMsgDao interMsgDao;

    @Test
    public void testUppercase(){

        System.out.println("lalla_yyiyi".toUpperCase());
    }

    @Test
    public void testgetProductorInfo()throws Exception{
        System.out.println((interMsgDao.getProductorInfo(1L)).toString());
    }

    @Test
    public void testgetPurchaseHistory() throws Exception{
        System.out.println(interMsgDao.getPurchaseHistory(1003L).toString());
    }

    @Test
    public void testgetLastMsgTest() throws Exception{
        List<Long> IdList = new ArrayList<Long>();
        IdList.add(1001L);
        IdList.add(1002L);
        IdList.add(1003L);
        List<String> contentList = interMsgDao.getLastMsgTest(IdList);
        System.out.println(contentList.size());
    }
}
