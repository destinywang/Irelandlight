package com.irelandlight.dao;

import com.irelandlight.model.Consumer;
import org.springframework.stereotype.Repository;

/**
 * User: Matt
 * Date: 2016/12/10
 * Time: 13:50
 * Description: description
 */
@Repository
public interface RegisterDao {

    public Integer insertNewConsumer(Consumer consumer);

    public Integer insertShopCar(Long id);

    public Integer countProductor();

    public Integer sendWelcome(Long from_id, Long to_id);

    public Long findConsumerByUserName(String userName);
}
