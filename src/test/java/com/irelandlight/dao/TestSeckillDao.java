package com.irelandlight.dao;

import com.irelandlight.model.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by destiny on 2016/11/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TestSeckillDao {

    @Resource
    private SeckillDao seckillDao;

    @Test
    public void testQueryAll() throws Exception {
        //Java没有保存形参的记录
        List<Seckill> seckillList = seckillDao.queryAll(0, 100);
        for (Seckill seckill: seckillList) {
            System.out.println(seckill);
        }
    }

}
