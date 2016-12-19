package com.irelandlight.service.impl;

import com.irelandlight.dao.PersonalInfoDao;
import com.irelandlight.model.Consumer;
import com.irelandlight.service.AccountManageService;
import com.irelandlight.service.PersonalInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by Matt on 2016/12/9.
 */
@Service
public class PersonalInfoServiceImpl implements PersonalInfoService{

    @Resource
    private PersonalInfoDao personalInfoDao;

    public Consumer findPersonalInfo(Long id) throws Exception {
        return personalInfoDao.findPersonalInfo(id);
    }

    public void changeEmail(Long id, String email) throws Exception {
        personalInfoDao.updateEmail(id,email);
    }

    public void changeNickName(Long id, String nickname) throws Exception {
        personalInfoDao.updateNickname(id,nickname);
    }
}
