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

    public int insertNewConsumer(Consumer consumer);

    public void insertShopCar(Long id);

    public int countProductor();

    public void sendWelcome(Long from_id, Long to_id);
}
