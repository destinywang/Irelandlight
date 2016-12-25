package com.irelandlight.service.impl;

import com.irelandlight.manager.PersonalInfoManager;
import com.irelandlight.service.PersonalInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by Matt on 2016/12/9.
 */
@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Resource
    private PersonalInfoManager personalInfoManagerImpl;

    public  Map<String,Object> findPersonalInfo(Long consumerId){
        return personalInfoManagerImpl.findPersonalInfo(consumerId);
    }

    public Map<String, Object> changeEmail(Long consumerId, String email)  {
        return personalInfoManagerImpl.updateEmail(consumerId, email);
    }

    public Map<String, Object> changeNickName(Long consumerId, String nickname) {
        return personalInfoManagerImpl.updateNickname(consumerId, nickname);
    }
}
