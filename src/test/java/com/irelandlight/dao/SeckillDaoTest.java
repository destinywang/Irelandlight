package com.irelandlight.dao;

import com.irelandlight.model.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by destiny on 2016/11/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    @Resource
    SeckillDao seckillDao;

    @Test
    public void testQueryById(){
        Seckill seckill = seckillDao.queryById(1002L);
        System.out.println(seckill);
    }
}
