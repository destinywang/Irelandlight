package com.irelandlight.dao;

import com.irelandlight.model.Consumer;
import org.omg.CORBA.Object;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Matt on 2016/12/9.
 */
@Repository
public interface PersonalInfoDao {

    public Consumer findPersonalInfo(Long consumerId);

    public Integer updateEmail(Long consumerId, String email);

    public Integer updateNickname(Long consumerId,String Nickname);

}
