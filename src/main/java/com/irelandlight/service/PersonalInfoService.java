package com.irelandlight.service;

import com.irelandlight.model.Consumer;

/**
 * Created by Matt on 2016/12/9.
 */
public interface PersonalInfoService {

    public Consumer findPersonalInfo(Long id) throws Exception;

    public void changeEmail(Long id,String email) throws Exception;

    public void changeNickName(Long id,String nickname) throws Exception;

}
