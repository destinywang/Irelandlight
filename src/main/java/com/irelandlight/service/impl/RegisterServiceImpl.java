package com.irelandlight.service.impl;

import com.irelandlight.dao.RegisterDao;
import com.irelandlight.manager.RegisterManager;
import com.irelandlight.model.Consumer;
import com.irelandlight.service.RegisterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * User: Matt
 * Date: 2016/12/10
 * Time: 15:41
 * Description: description
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Resource
    private RegisterManager registerManagerImpl;

    public Map<String, Object> RegisterConsumer(Consumer consumer){
        return registerManagerImpl.RegisterConsumer(consumer);
    }

}
