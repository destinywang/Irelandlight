package com.irelandlight.manager;

import com.irelandlight.dao.LoginTicketDao;
import com.irelandlight.exception.LoginTicketException;
import com.irelandlight.model.LoginTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    private static final List<Character> HEX_DECIMAL =
            Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f');

    /**
     * 用于验证ticket是否符合UUID的规则而非伪造
     *
     * @param ticket    cookie中的ticket对象
     * @return          是否是正常的ticket
     */
    private boolean verifyTicket(String ticket) {
        boolean result = true;
        if (ticket == null || ticket.length() != 32) {
            return false;
        }
        for (Character eachChar:
             ticket.toCharArray()) {
            if ( !HEX_DECIMAL.contains(eachChar)) {
                result = false;
            }
        }
        return result;
    }

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
        if (!verifyTicket(ticket)) {
            return null;
        }
        return loginTicketDao.getByLoginTicket(ticket);
    }
}