package com.irelandlight.dao;

import com.irelandlight.model.LoginTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

/**
 * Created by destiny on 2016/12/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class LoginTicketDaoTest {

    @Resource
    private LoginTicketDao loginTicketDao;

    @Test
    public void testAddTicket() {
        System.out.println("LoginTicketDaoTest.testAddTicket");
        System.out.println(loginTicketDao);

        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setConsumerId(1001L);
        loginTicket.setVisibility(0);
        Date date = new Date();
        date.setTime(date.getTime() + 1000 * 3600 * 24);
        loginTicket.setExpired(date);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicket.setStatus(0);

        System.out.println(loginTicketDao.addLoginTicket(loginTicket));
    }

    @Test
    public void testGetByTicket() {
        System.out.println("LoginTicketDaoTest.testGetByTicket");

        System.out.println(loginTicketDao.getByLoginTicket("7e86b844898941878dac17eacf7c8300")
                .getExpired().getTime() - new Date().getTime());
//        System.out.println(l);
    }

    @Test
    public void testGetById() {
        System.out.println("LoginTicketDaoTest.testGetById");
        System.out.println(loginTicketDao.getById(5L));
    }

    @Test
    public void testGetByIdList() {
        System.out.println("LoginTicketDaoTest.testGetByIdList");
        System.out.println(loginTicketDao.getByIdList(Arrays.asList(5L, 6L, 7L)));
    }

    @Test
    public void testUpdateStatus() {
        System.out.println("LoginTicketDaoTest.testUpdateStatus");
        loginTicketDao.updateStatus("7e86b844898941878dac17eacf7c8300", 1);
    }

}
