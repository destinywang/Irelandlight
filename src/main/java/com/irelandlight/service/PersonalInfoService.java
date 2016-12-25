package com.irelandlight.service;

import com.irelandlight.model.Consumer;

import java.util.Map;

/**
 * Created by Matt on 2016/12/9.
 */
public interface PersonalInfoService {

    public Map<String, Object> findPersonalInfo(Long id);

    public Map<String, Object> changeEmail(Long id, String email);

    public Map<String, Object> changeNickName(Long id, String nickname);

}
