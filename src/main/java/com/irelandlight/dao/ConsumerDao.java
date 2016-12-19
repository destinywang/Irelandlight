package com.irelandlight.dao;

import com.irelandlight.model.Consumer;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>This is a Data Access Object of Consumer</p>
 *
 * @author destiny
 * @see
 * @since 2016-12-15 on jdk 1.8
 */
@Repository
public interface ConsumerDao {

    /**
     * select one consumer
     * in tb_consumer
     * by one key
     *
     * @param id    key of consumer
     * @return      A consumer
     */
    Consumer getById(Long id);

    /**
     * select one consumer
     * in tb_consumer
     * by unique userName
     *
     * @param userName  unique user name
     * @return          A consumer
     */
    Consumer getByUserName(String userName);

    /**
     * select consumers
     * in tb_consumer
     * by keys
     *
     * @param idList
     * @return
     */
    List<Consumer> getByIdList(List<Long> idList);

    /**
     *
     * @param nickName
     * @return
     */
    List<Consumer> getByNickName(String nickName);

}
