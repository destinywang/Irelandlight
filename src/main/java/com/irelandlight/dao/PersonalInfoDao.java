package com.irelandlight.dao;

import com.irelandlight.model.Consumer;
import org.springframework.stereotype.Repository;

/**
 * Created by Matt on 2016/12/9.
 */
@Repository
public interface PersonalInfoDao {

    public Consumer findPersonalInfo(Long id)throws Exception;

    public void updateEmail(Long id,String email)throws Exception;

    public void updateNickname(Long id,String Nickname)throws Exception;

}
