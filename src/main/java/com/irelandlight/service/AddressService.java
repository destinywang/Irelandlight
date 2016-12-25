package com.irelandlight.service;

import com.irelandlight.model.Address;

import java.util.List;
import java.util.Map;

/**
 * Created  with Intellij IDEA.
 * User: Ele_Chen
 * Date: 2016/12/11
 * Time: 9:08
 * Description: 用户地址service.
 */
public interface AddressService {

    public Map<String,Object> findAddressByConsumerId(Long consumerId) throws Exception;
}
