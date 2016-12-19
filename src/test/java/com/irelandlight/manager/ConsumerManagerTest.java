package com.irelandlight.manager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * <p>This is a test part of consumerManager</p>
 * @author destiny
 * @since 2016-12-16 on jdk 1.8
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class ConsumerManagerTest {

    @Resource
    private ConsumerManager consumerManager;

    @Test
    public void testGetById() {
        System.out.println(consumerManager.getById(0L));
    }

}
