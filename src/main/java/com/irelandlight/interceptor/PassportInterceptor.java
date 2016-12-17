package com.irelandlight.interceptor;

import com.irelandlight.dao.LoginTicketDao;
import com.irelandlight.manager.ConsumerManager;
import com.irelandlight.model.Consumer;
import com.irelandlight.model.HostHolder;
import com.irelandlight.model.LoginTicket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * <p>PassportInterceptor based implementation of the
 * <tt>HandlerInterceptor</tt>.
 * In this implementation, we can send a ticket from
 * server when the consumer login</p>
 *
 * <p>In preHandler, we can send to consumer a ticket
 * or get current ticket</p>
 *
 * <p>In postHandler, we can add this ticket to ModelAndView</p>
 *
 * <p>In afterCompletion, we can remove all ticket in ThreadLocal</p>
 *
 * @author destiny
 * @see org.springframework.web.servlet.ModelAndView
 * @see javax.servlet.http.HttpServletRequest
 * @see javax.servlet.http.HttpServletResponse
 *
 * @see LoginTicketDao
 * @see ConsumerManager
 * @see HostHolder
 * @since 2016-12-14 on jdk 1.8
 */
@Component
public class PassportInterceptor implements HandlerInterceptor{

    private static final Logger LOGGER = LoggerFactory.getLogger(PassportInterceptor.class);

    @Resource
    private LoginTicketDao loginTicketDao;

    @Resource
    private ConsumerManager consumerManager;

    @Resource
    private HostHolder hostHolder;

    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler)
            throws Exception {
        String ticket = null;
        // 找到cookie中key为ticket的value，并赋值给ticket
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("ticket".equals(cookie.getName())) {
                    ticket = cookie.getValue();
                    LOGGER.info("ticket = " + ticket);
                    break;
                }
            }
        }
        // 通过ticket查找到所属的用户
        if (ticket != null) {
            LoginTicket loginTicket = loginTicketDao.getByLoginTicket(ticket);
            LOGGER.info("LoginTicket = " + loginTicket);
            if (loginTicket == null || loginTicket.getExpired().before(new Date())
                    || loginTicket.getStatus() != 0) {
                return true;
            }

            Consumer consumer = consumerManager.getById(loginTicket.getConsumerId());
            hostHolder.setConsumer(consumer);
            LOGGER.info("Take a consumer in HostHolder successfully");
        }
        return true;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView)
            throws Exception {
        if (modelAndView != null && hostHolder.getConsumer() != null) {
            modelAndView.addObject("consumer", hostHolder.getConsumer());
        }
    }

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {
        hostHolder.clear();
    }
}
