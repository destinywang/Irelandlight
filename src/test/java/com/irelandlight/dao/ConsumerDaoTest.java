package com.irelandlight.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by destiny on 2016/12/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ConsumerDaoTest {

    @Resource
    private ConsumerDao consumerDao;

    @Test
    public void testGetById() {
        System.out.println(consumerDao.getById(1001L));
    }

    @Test
    public void testGetByUserName() {
        System.out.println(consumerDao.getByUserName("destiny"));
    }

    @Test
    public void testGetByIdList() {
        System.out.println(consumerDao.getByIdList(Arrays.<Long>asList(1001L, 1002L, 1003L)));
    }

    @Test
    public void testGetByNickName() {
        System.out.println(consumerDao.getByNickName("会"));
    }

}
