package com.irelandlight.manager;

import com.irelandlight.dao.LoginTicketDao;
import com.irelandlight.exception.LoginTicketException;
import com.irelandlight.model.LoginTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>This is the manager part of LoginTicket</p>
 *
 * <p>In this </p>
 *
 * @author destiny
 * @see LoginTicket
 * @see LoginTicketDao
 * @since 2016-12-15 on jdk 1.8
 */
@Component
public class LoginTicketManager {

    @Resource
    private LoginTicketDao loginTicketDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginTicketManager.class);

    public Integer createLoginTicket(LoginTicket loginTicket) throws LoginTicketException {
        if (loginTicket != null) {
            if (new Date().after(loginTicket.getExpired())) {
                LOGGER.error("LoginTicket插入异常");
                throw new LoginTicketException();
            }
            return loginTicketDao.addLoginTicket(loginTicket);
        }
        return 0;
    }

    public LoginTicket getByTicket(String ticket) {
        if (ticket == null || ticket.length() != 32) {
            return null;
        }
        LoginTicket loginTicket = loginTicketDao.getByLoginTicket(ticket);
        if (loginTicket == null) {

        }
        // TODO 完成dao层返回值的判断
        return null;
    }

}