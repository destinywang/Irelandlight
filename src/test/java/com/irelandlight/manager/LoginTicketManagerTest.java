package com.irelandlight.manager;

import com.irelandlight.exception.LoginTicketException;
import com.irelandlight.model.LoginTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by destiny on 2016/12/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-*.xml"})
public class LoginTicketManagerTest {

    @Resource
    private LoginTicketManager loginTicketManager;

    @Test
    public void testCreateLoginTicket() {
        // 59140f3309164c799b2cb960982380cb
        // f3c2e1a0097f475a99f402d73ecdd4b3
        // dba8760f3b604967ac362f418edd0c7d
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setVisibility(0);
        loginTicket.setConsumerId(1001L);
        Date date = new Date();
        date.setTime(date.getTime() + 1000 * 3600 * 24);
        loginTicket.setExpired(date);
        loginTicket.setTicket(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTicket.setStatus(0);
        try {
            System.out.println(loginTicketManager.createLoginTicket(loginTicket));
        } catch (LoginTicketException e) {
            e.printStackTrace();
        }
    }

}
