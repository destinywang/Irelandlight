package com.irelandlight.manager;

import com.irelandlight.dao.ConsumerDao;
import com.irelandlight.model.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * <p>This is a manager part of Consumer Chain</p>
 *
 * @author destiny
 * @see
 * @since 2016-12-16 on jdk 1.8
 */
@Component
public class ConsumerManager {

    @Resource
    private ConsumerDao consumerDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerManager.class);

    public Consumer getById(Long id) {
        if (id == null || id < 0) {
            return null;
        }
        Consumer consumer = consumerDao.getById(id);
        if (consumer == null) {
            LOGGER.error("ConsumerDao ERROR");
//            throw new IrelandLightException();
        }
        return consumer;
    }

}
