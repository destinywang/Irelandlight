package com.irelandlight.service;

import com.irelandlight.model.Address;
import com.irelandlight.model.Consumer;

/**
 * Created by Matt on 2016/12/9.
 */
public interface AccountManageService {

    /*public void registerNewConsumer(Consumer consumer) throws Exception;*/

    public String findConsumerPassword(Long id) throws Exception;

    public void displayAccountManage(Long id)throws Exception;

    public void changeTelephone(Long id,String Telephone) throws Exception;

    public void addNewAddress(Address address)throws Exception;

    public void displayAddress(Long id)throws Exception;

}
