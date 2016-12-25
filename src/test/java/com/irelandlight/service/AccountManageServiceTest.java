package com.irelandlight.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Matt on 2016/12/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class AccountManageServiceTest {

    @Resource
    private AccountManageService accountManageServiceImpl;

    @Test
    public void displayAccountManage() throws Exception {
        accountManageServiceImpl.displayAccountManage(1001L);
    }



}
