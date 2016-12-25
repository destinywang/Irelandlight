package com.irelandlight.service;

import com.irelandlight.model.Address;
import com.irelandlight.model.Consumer;

import java.util.Map;

/**
 * Created by Matt on 2016/12/9.
 */
public interface AccountManageService {

    public Map<String ,Object> changePassword(Long consumerId,String oldPass,String newPass);

    public Map<String ,Object> displayAccountManage(Long consumerId);

    public Map<String ,Object> changeTelephone(Long consumerId, String Telephone);

    public Map<String ,Object> addNewAddress(Long consumerId,Address address,Integer flag);

    public Map<String ,Object> displayAddress(Long id);

}
