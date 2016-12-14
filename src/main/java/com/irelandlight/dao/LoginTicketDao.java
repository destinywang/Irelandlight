package com.irelandlight.dao;

import com.irelandlight.model.LoginTicket;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by destiny on 2016/12/14.
 */
@Repository
public interface LoginTicketDao {

    /**
     * insert a ticket
     * to login_ticket
     *
     * @param loginTicket   model of LoginTicket
     * @return              the count of insert
     */
    Integer addTicket(LoginTicket loginTicket);

    /**
     * get a model of Ticket
     *
     * @param ticket    the ticket of user's login
     * @return          the model of LoginTicket
     */
    LoginTicket getByTicket(String ticket);

    /**
     * update the status of LoginTicket's record
     *
     * @param ticket    the ticket of user's login
     * @param status    the status of user's login
     */
    void updateStatus(@Param("ticket") String ticket,
                      @Param("status") Integer status);

}
